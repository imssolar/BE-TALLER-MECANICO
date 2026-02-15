package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCargoDto;
import com.tallermecanico.entity.Cargo;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CargoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public Cargo create(CreateCargoDto cargoDto){
        String cargoNormalizado = normalizarCargo(cargoDto.getCargo());
        Optional<Cargo> encontrarDuplicado = cargoRepository.findByCargo(cargoNormalizado);
        if(encontrarDuplicado.isPresent()){
            throw new DuplicateResourceException("Cargo", "cargo", cargoDto.getCargo());
        }
        Cargo nuevoCargo = new Cargo();
        nuevoCargo.setCargo(cargoNormalizado);
        return cargoRepository.save(nuevoCargo);
    }

    @Transactional(readOnly = true)
    public List<Cargo> findAll(){
        return this.cargoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cargo findByID(Integer id){
        return cargoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cargo","id",id));
    }

    @Transactional
    public Cargo update(Integer id, CreateCargoDto cargoDto){
        String cargoNormalizado = normalizarCargo(cargoDto.getCargo());
        Cargo cargo = findByID(id);
        Optional<Cargo> encontrarDuplicado = cargoRepository.findByCargo(cargoNormalizado);
        if(encontrarDuplicado.isPresent() && !Objects.equals(cargo.getIdCargo(), encontrarDuplicado.get().getIdCargo())){
            throw new DuplicateResourceException("Cargo", "cargo", cargoDto.getCargo());
        }
        cargo.setCargo(cargoNormalizado);
        return this.cargoRepository.save(cargo);

    }

    @Transactional
    public void delete(Integer id){
        Cargo cargoAEliminar = findByID(id);
        this.cargoRepository.delete(cargoAEliminar);
    }

    private String normalizarCargo(String cargo){
        return cargo.toUpperCase().trim();
    }
}
