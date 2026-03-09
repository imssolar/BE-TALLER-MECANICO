package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateAuditoriaMenuDto;
import com.tallermecanico.dto.request.UpdateAuditoriaMenuDto;
import com.tallermecanico.dto.response.DeleteAuditoriaMenuResponseDto;
import com.tallermecanico.entity.AuditoriaMenu;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.AuditoriaMenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditoriaMenuService {

    private final AuditoriaMenuRepository auditoriaMenuRepository;

    public AuditoriaMenuService(AuditoriaMenuRepository auditoriaMenuRepository) {
        this.auditoriaMenuRepository = auditoriaMenuRepository;
    }

    @Transactional
    public AuditoriaMenu create(CreateAuditoriaMenuDto dto) {
        AuditoriaMenu auditoria = new AuditoriaMenu();
        auditoria.setUsuario(dto.getUsuario());
        auditoria.setMenu(dto.getMenu());
        auditoria.setOpcion(dto.getOpcion());
        auditoria.setFecha(LocalDateTime.now());
        auditoria.setTerminal(dto.getTerminal());
        auditoria.setIp(dto.getIp());

        return auditoriaMenuRepository.save(auditoria);
    }

    @Transactional(readOnly = true)
    public List<AuditoriaMenu> findAll() {
        return auditoriaMenuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AuditoriaMenu findById(Long id) {
        return auditoriaMenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AuditoriaMenu", "id", id));
    }

    @Transactional(readOnly = true)
    public List<AuditoriaMenu> findByUsuario(String usuario) {
        return auditoriaMenuRepository.findByUsuario(usuario);
    }

    @Transactional(readOnly = true)
    public List<AuditoriaMenu> findByFechaBetween(LocalDateTime desde, LocalDateTime hasta) {
        return auditoriaMenuRepository.findByFechaBetween(desde, hasta);
    }

    @Transactional
    public AuditoriaMenu update(Long id, UpdateAuditoriaMenuDto dto) {
        AuditoriaMenu auditoria = findById(id);

        if (dto.getUsuario() != null) {
            auditoria.setUsuario(dto.getUsuario());
        }
        if (dto.getMenu() != null) {
            auditoria.setMenu(dto.getMenu());
        }
        if (dto.getOpcion() != null) {
            auditoria.setOpcion(dto.getOpcion());
        }
        if (dto.getTerminal() != null) {
            auditoria.setTerminal(dto.getTerminal());
        }
        if (dto.getIp() != null) {
            auditoria.setIp(dto.getIp());
        }

        return auditoriaMenuRepository.save(auditoria);
    }

    @Transactional
    public DeleteAuditoriaMenuResponseDto delete(Long id) {
        AuditoriaMenu auditoria = findById(id);
        auditoriaMenuRepository.delete(auditoria);
        return new DeleteAuditoriaMenuResponseDto(auditoria.getId(), auditoria.getUsuario());
    }
}
