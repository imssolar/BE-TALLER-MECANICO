package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRepuestosManagerDto;
import com.tallermecanico.dto.request.UpdateRepuestosManagerDto;
import com.tallermecanico.dto.response.DeleteRepuestosManagerResponseDto;
import com.tallermecanico.entity.Glosa;
import com.tallermecanico.entity.Terminal;
import com.tallermecanico.entity.RepuestosManager;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RepuestosManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepuestosManagerService {

    private final RepuestosManagerRepository repuestosManagerRepository;
    private final GlosaService glosaService;
    private final TerminalService terminalService;

    public RepuestosManagerService(RepuestosManagerRepository repuestosManagerRepository,
                                   GlosaService glosaService,
                                   TerminalService terminalService) {
        this.repuestosManagerRepository = repuestosManagerRepository;
        this.glosaService = glosaService;
        this.terminalService = terminalService;
    }

    @Transactional
    public RepuestosManager create(CreateRepuestosManagerDto dto) {
        RepuestosManager repuestosManager = new RepuestosManager();

        repuestosManager.setFecha(dto.getFecha());
        repuestosManager.setIdRepuesto(dto.getIdRepuesto());
        repuestosManager.setRepuesto(dto.getRepuesto());
        repuestosManager.setCantidad(dto.getCantidad());
        repuestosManager.setCosto(dto.getCosto());

        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            repuestosManager.setGlosa(glosa);
        }

        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            repuestosManager.setTerminal(terminal);
        }

        return repuestosManagerRepository.save(repuestosManager);
    }

    @Transactional(readOnly = true)
    public List<RepuestosManager> findAll() {
        return repuestosManagerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RepuestosManager findById(Integer id) {
        return repuestosManagerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestosManager", "id", id));
    }

    @Transactional(readOnly = true)
    public List<RepuestosManager> findByGlosa(Integer idGlosa) {
        return repuestosManagerRepository.findByGlosa_Id(idGlosa);
    }

    @Transactional(readOnly = true)
    public List<RepuestosManager> findByTerminal(Integer idTerminal) {
        return repuestosManagerRepository.findByTerminal_IdTerminal(idTerminal);
    }

    @Transactional
    public RepuestosManager update(Integer id, UpdateRepuestosManagerDto dto) {
        RepuestosManager repuestosManager = repuestosManagerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestosManager", "id", id));

        if (dto.getFecha() != null) {
            repuestosManager.setFecha(dto.getFecha());
        }
        if (dto.getIdRepuesto() != null) {
            repuestosManager.setIdRepuesto(dto.getIdRepuesto());
        }
        if (dto.getRepuesto() != null) {
            repuestosManager.setRepuesto(dto.getRepuesto());
        }
        if (dto.getIdGlosa() != null) {
            Glosa glosa = glosaService.findById(dto.getIdGlosa());
            repuestosManager.setGlosa(glosa);
        }
        if (dto.getCantidad() != null) {
            repuestosManager.setCantidad(dto.getCantidad());
        }
        if (dto.getCosto() != null) {
            repuestosManager.setCosto(dto.getCosto());
        }
        if (dto.getIdTerminal() != null) {
            Terminal terminal = terminalService.findById(dto.getIdTerminal());
            repuestosManager.setTerminal(terminal);
        }

        return repuestosManagerRepository.save(repuestosManager);
    }

    @Transactional
    public DeleteRepuestosManagerResponseDto delete(Integer id) {
        RepuestosManager repuestosManager = repuestosManagerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RepuestosManager", "id", id));

        repuestosManagerRepository.delete(repuestosManager);
        return new DeleteRepuestosManagerResponseDto(
                repuestosManager.getId(),
                "RepuestosManager eliminado exitosamente"
        );
    }
}
