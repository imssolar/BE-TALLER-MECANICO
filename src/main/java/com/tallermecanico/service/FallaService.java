package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateFallaDto;
import com.tallermecanico.dto.request.UpdateFallaDto;
import com.tallermecanico.entity.Falla;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.FallaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FallaService {
    private final FallaRepository fallaRepository;

    public FallaService(FallaRepository fallaRepository){
        this.fallaRepository = fallaRepository;
    }

    @Transactional
    public Falla createFalla(CreateFallaDto createFallaDto){
        if(fallaRepository.existsById(createFallaDto.getIdFalla())){
            throw new DuplicateResourceException("Falla", "idFalla", createFallaDto.getIdFalla());
        }
        if(fallaRepository.existsByFalla(createFallaDto.getFalla())){
            throw new DuplicateResourceException("Falla", "falla", createFallaDto.getFalla());
        }
        Falla nuevaFalla = new Falla();
        nuevaFalla.setIdFalla(createFallaDto.getIdFalla());
        nuevaFalla.setFalla(createFallaDto.getFalla());
        return fallaRepository.save(nuevaFalla);
    }

    @Transactional(readOnly = true)
    public List<Falla> findAll(){
        return fallaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Falla findById(String idFalla){
        return fallaRepository.findById(idFalla)
                .orElseThrow(() -> new ResourceNotFoundException("Falla", "idFalla", idFalla));
    }

    @Transactional
    public Falla update(String id, UpdateFallaDto updateFallaDto){
        Falla existeFalla = this.findById(id);
        if(updateFallaDto.getFalla() != null && fallaRepository.existsByFallaAndIdFallaNot(updateFallaDto.getFalla(), id)){
            throw new DuplicateResourceException("Falla", "falla", updateFallaDto.getFalla());
        }
        existeFalla.setFalla(updateFallaDto.getFalla());
        return fallaRepository.save(existeFalla);
    }

    @Transactional
    public void delete(String id){
        Falla falla = findById(id);
        fallaRepository.delete(falla);
    }
}
