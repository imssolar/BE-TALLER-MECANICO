package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateTrabajosMecDto;
import com.tallermecanico.dto.request.UpdateTrabajosMecDto;
import com.tallermecanico.dto.response.DeleteTrabajosMecResponseDto;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.entity.TrabajosMec;
import com.tallermecanico.exception.DuplicateResourceException;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.GlosaRepository;
import com.tallermecanico.repository.TrabajosMecRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrabajoMecService {
    private final TrabajosMecRepository trabajosMecRepository;
    private final GlosaRepository glosaRepository;

    public TrabajoMecService(TrabajosMecRepository trabajosMecRepository, GlosaRepository glosaRepository){
        this.trabajosMecRepository = trabajosMecRepository;
        this.glosaRepository = glosaRepository;
    }

    @Transactional
    public TrabajosMec create(CreateTrabajosMecDto createTrabajosMecDto){
        if(trabajosMecRepository.existsByTrabajoMec(createTrabajosMecDto.getTrabajoMec())){
            throw new DuplicateResourceException("TrabajoMec","trabajoMec", createTrabajosMecDto.getTrabajoMec());
        }
        TrabajosMec trabajosMec = new TrabajosMec();
        Glosa glosa = glosaRepository.findById(createTrabajosMecDto.getIdGlosa()).orElseThrow(()->new ResourceNotFoundException("Glosa", "id",createTrabajosMecDto.getIdGlosa()));
        trabajosMec.setTrabajoMec(createTrabajosMecDto.getTrabajoMec());
        trabajosMec.setGlosa(glosa);
        return trabajosMecRepository.save(trabajosMec);
    }

    @Transactional(readOnly = true)
    public List<TrabajosMec> findAll(){
        return trabajosMecRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TrabajosMec findById(Integer id){
        return trabajosMecRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TrabajoMec", "id", id));
    }

    @Transactional
    public TrabajosMec update(Integer id, UpdateTrabajosMecDto dto) {
        TrabajosMec trabajosMec = findById(id);

        if (dto.getTrabajoMec() != null) {
            if (trabajosMecRepository.existsByTrabajoMecAndIdNot(dto.getTrabajoMec(), id)) {
                throw new DuplicateResourceException("TrabajoMec", "trabajoMec", dto.getTrabajoMec());
            }
            trabajosMec.setTrabajoMec(dto.getTrabajoMec());
        }

        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaRepository.findById(dto.getIdGlosa())
                    .orElseThrow(() -> new ResourceNotFoundException("Glosa", "id", dto.getIdGlosa()));
            trabajosMec.setGlosa(glosa);
        }

        return trabajosMecRepository.save(trabajosMec);
    }

    @Transactional
    public DeleteTrabajosMecResponseDto delete(Integer id){
        TrabajosMec trabajosMec = findById(id);
        trabajosMecRepository.delete(trabajosMec);
        return new DeleteTrabajosMecResponseDto(id,trabajosMec.getTrabajoMec());
    }


}
