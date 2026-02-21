package com.tallermecanico.service;

import com.tallermecanico.dto.request.CreateCofpatioDto;
import com.tallermecanico.dto.request.UpdateCofpatioDto;
import com.tallermecanico.dto.response.DeleteCofpatioResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Cofpatio;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CofpatioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CofpatioService {

    private final CofpatioRepository cofpatioRepository;
    private final BusService busService;

    public CofpatioService(CofpatioRepository cofpatioRepository,
                           BusService busService) {
        this.cofpatioRepository = cofpatioRepository;
        this.busService = busService;
    }

    @Transactional
    public Cofpatio create(CreateCofpatioDto dto) {
        Cofpatio cofpatio = new Cofpatio();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            cofpatio.setBus(bus);
        }

        cofpatio.setKm(dto.getKm());
        cofpatio.setFechaHora(dto.getFechaHora());
        cofpatio.setFechaHoraOperativa(dto.getFechaHoraOperativa());
        cofpatio.setLugarPanne(dto.getLugarPanne());
        cofpatio.setCofPatio(dto.getCofPatio());
        cofpatio.setNroCp(dto.getNroCp());
        cofpatio.setCombustible(dto.getCombustible());
        cofpatio.setConductor(dto.getConductor());
        cofpatio.setFalla(dto.getFalla());
        cofpatio.setUbicacion(dto.getUbicacion());
        cofpatio.setCabezal(dto.getCabezal());
        cofpatio.setHoraReal(dto.getHoraReal());
        cofpatio.setTrabajoTerreno(dto.getTrabajoTerreno());
        cofpatio.setObsTerreno(dto.getObsTerreno());
        cofpatio.setOperativaTerreno(dto.getOperativaTerreno());
        cofpatio.setMecanico(dto.getMecanico());
        cofpatio.setGrua(dto.getGrua());
        cofpatio.setHoraLevantamiento(dto.getHoraLevantamiento());
        cofpatio.setTiempoDetencion(dto.getTiempoDetencion());
        cofpatio.setResponsable(dto.getResponsable());
        cofpatio.setAceiteMotor(dto.getAceiteMotor());
        cofpatio.setAceiteTrans(dto.getAceiteTrans());
        cofpatio.setAceiteDir(dto.getAceiteDir());
        cofpatio.setRefrigerante(dto.getRefrigerante());
        cofpatio.setCodigoPanne(dto.getCodigoPanne());
        cofpatio.setResponsableCierre(dto.getResponsableCierre());
        cofpatio.setIdIntranet(dto.getIdIntranet());
        cofpatio.setUbicacion2(dto.getUbicacion2());
        cofpatio.setUbicacionTerreno(dto.getUbicacionTerreno());
        cofpatio.setTipoFalla(dto.getTipoFalla());

        return cofpatioRepository.save(cofpatio);
    }

    @Transactional(readOnly = true)
    public List<Cofpatio> findAll() {
        return cofpatioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cofpatio findById(Integer id) {
        return cofpatioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cofpatio", "id", id));
    }

    @Transactional(readOnly = true)
    public List<Cofpatio> findByBus(Integer idBus) {
        return cofpatioRepository.findByBus_IdBus(idBus);
    }

    @Transactional
    public Cofpatio update(Integer id, UpdateCofpatioDto dto) {
        Cofpatio cofpatio = findById(id);

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            cofpatio.setBus(bus);
        }
        if (dto.getKm() != null) {
            cofpatio.setKm(dto.getKm());
        }
        if (dto.getFechaHora() != null) {
            cofpatio.setFechaHora(dto.getFechaHora());
        }
        if (dto.getFechaHoraOperativa() != null) {
            cofpatio.setFechaHoraOperativa(dto.getFechaHoraOperativa());
        }
        if (dto.getLugarPanne() != null) {
            cofpatio.setLugarPanne(dto.getLugarPanne());
        }
        if (dto.getCofPatio() != null) {
            cofpatio.setCofPatio(dto.getCofPatio());
        }
        if (dto.getNroCp() != null) {
            cofpatio.setNroCp(dto.getNroCp());
        }
        if (dto.getCombustible() != null) {
            cofpatio.setCombustible(dto.getCombustible());
        }
        if (dto.getConductor() != null) {
            cofpatio.setConductor(dto.getConductor());
        }
        if (dto.getFalla() != null) {
            cofpatio.setFalla(dto.getFalla());
        }
        if (dto.getUbicacion() != null) {
            cofpatio.setUbicacion(dto.getUbicacion());
        }
        if (dto.getCabezal() != null) {
            cofpatio.setCabezal(dto.getCabezal());
        }
        if (dto.getHoraReal() != null) {
            cofpatio.setHoraReal(dto.getHoraReal());
        }
        if (dto.getTrabajoTerreno() != null) {
            cofpatio.setTrabajoTerreno(dto.getTrabajoTerreno());
        }
        if (dto.getObsTerreno() != null) {
            cofpatio.setObsTerreno(dto.getObsTerreno());
        }
        if (dto.getOperativaTerreno() != null) {
            cofpatio.setOperativaTerreno(dto.getOperativaTerreno());
        }
        if (dto.getMecanico() != null) {
            cofpatio.setMecanico(dto.getMecanico());
        }
        if (dto.getGrua() != null) {
            cofpatio.setGrua(dto.getGrua());
        }
        if (dto.getHoraLevantamiento() != null) {
            cofpatio.setHoraLevantamiento(dto.getHoraLevantamiento());
        }
        if (dto.getTiempoDetencion() != null) {
            cofpatio.setTiempoDetencion(dto.getTiempoDetencion());
        }
        if (dto.getResponsable() != null) {
            cofpatio.setResponsable(dto.getResponsable());
        }
        if (dto.getAceiteMotor() != null) {
            cofpatio.setAceiteMotor(dto.getAceiteMotor());
        }
        if (dto.getAceiteTrans() != null) {
            cofpatio.setAceiteTrans(dto.getAceiteTrans());
        }
        if (dto.getAceiteDir() != null) {
            cofpatio.setAceiteDir(dto.getAceiteDir());
        }
        if (dto.getRefrigerante() != null) {
            cofpatio.setRefrigerante(dto.getRefrigerante());
        }
        if (dto.getCodigoPanne() != null) {
            cofpatio.setCodigoPanne(dto.getCodigoPanne());
        }
        if (dto.getResponsableCierre() != null) {
            cofpatio.setResponsableCierre(dto.getResponsableCierre());
        }
        if (dto.getIdIntranet() != null) {
            cofpatio.setIdIntranet(dto.getIdIntranet());
        }
        if (dto.getUbicacion2() != null) {
            cofpatio.setUbicacion2(dto.getUbicacion2());
        }
        if (dto.getUbicacionTerreno() != null) {
            cofpatio.setUbicacionTerreno(dto.getUbicacionTerreno());
        }
        if (dto.getTipoFalla() != null) {
            cofpatio.setTipoFalla(dto.getTipoFalla());
        }

        return cofpatioRepository.save(cofpatio);
    }

    @Transactional
    public DeleteCofpatioResponseDto delete(Integer id) {
        Cofpatio cofpatio = findById(id);
        cofpatioRepository.delete(cofpatio);
        return new DeleteCofpatioResponseDto(cofpatio.getId(), "Cofpatio eliminado exitosamente");
    }
}
