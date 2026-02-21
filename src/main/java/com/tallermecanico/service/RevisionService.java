package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateRevisionDto;
import com.tallermecanico.dto.request.UpdateRevisionDto;
import com.tallermecanico.dto.response.DeleteRevisionResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.PlanRevisiones;
import com.tallermecanico.entity.Revision;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.RevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RevisionService {

    private final RevisionRepository revisionRepository;
    private final BusService busService;
    private final PlanRevisionesService planRevisionesService;

    public RevisionService(RevisionRepository revisionRepository,
                           BusService busService,
                           PlanRevisionesService planRevisionesService) {
        this.revisionRepository = revisionRepository;
        this.busService = busService;
        this.planRevisionesService = planRevisionesService;
    }

    @Transactional
    public Revision create(CreateRevisionDto dto) {
        Revision revision = new Revision();

        if (dto.getIdPlanRevisiones() != null) {
            PlanRevisiones planRevisiones = planRevisionesService.findById(dto.getIdPlanRevisiones());
            revision.setPlanRevisiones(planRevisiones);
        }

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            revision.setBus(bus);
        }

        revision.setFechaRevision(dto.getFechaRevision());
        revision.setKm(dto.getKm());
        revision.setTipo(dto.getTipo());
        revision.setFechaControl(dto.getFechaControl());
        revision.setEstado(dto.getEstado());
        revision.setInstancia(dto.getInstancia());
        revision.setObservaciones(dto.getObservaciones());

        return revisionRepository.save(revision);
    }

    @Transactional(readOnly = true)
    public List<Revision> findAll() {
        return revisionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Revision findById(Integer id) {
        return revisionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Revision", "id", id));
    }

    @Transactional(readOnly = true)
    public List<Revision> findByBus(Integer idBus) {
        return revisionRepository.findByBus_IdBus(idBus);
    }

    @Transactional(readOnly = true)
    public List<Revision> findByPlanRevisiones(Integer idPlanRevisiones) {
        return revisionRepository.findByPlanRevisiones_Id(idPlanRevisiones);
    }

    @Transactional
    public Revision update(Integer id, UpdateRevisionDto dto) {
        Revision revision = findById(id);

        if (dto.getIdPlanRevisiones() != null) {
            PlanRevisiones planRevisiones = planRevisionesService.findById(dto.getIdPlanRevisiones());
            revision.setPlanRevisiones(planRevisiones);
        }
        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            revision.setBus(bus);
        }
        if (dto.getFechaRevision() != null) {
            revision.setFechaRevision(dto.getFechaRevision());
        }
        if (dto.getKm() != null) {
            revision.setKm(dto.getKm());
        }
        if (dto.getTipo() != null) {
            revision.setTipo(dto.getTipo());
        }
        if (dto.getFechaControl() != null) {
            revision.setFechaControl(dto.getFechaControl());
        }
        if (dto.getEstado() != null) {
            revision.setEstado(dto.getEstado());
        }
        if (dto.getInstancia() != null) {
            revision.setInstancia(dto.getInstancia());
        }
        if (dto.getObservaciones() != null) {
            revision.setObservaciones(dto.getObservaciones());
        }

        return revisionRepository.save(revision);
    }

    @Transactional
    public DeleteRevisionResponseDto delete(Integer id) {
        Revision revision = findById(id);
        revisionRepository.delete(revision);
        return new DeleteRevisionResponseDto(revision.getId(), "Revisión eliminada exitosamente");
    }
}
