package com.tallermecanico.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tallermecanico.dto.request.CreateCofpatioDto;
import com.tallermecanico.dto.request.UpdateCofpatioDto;
import com.tallermecanico.dto.response.CofpatioResponseDto;
import com.tallermecanico.dto.response.DeleteCofpatioResponseDto;
import com.tallermecanico.entity.Bus;
import com.tallermecanico.entity.Cofpatio;
import com.tallermecanico.entity.Empleado;
import com.tallermecanico.exception.ResourceNotFoundException;
import com.tallermecanico.repository.CofpatioRepository;
import com.tallermecanico.repository.EmpleadoRepository;

@Service
public class CofpatioService {

    private final CofpatioRepository cofpatioRepository;
    private final BusService busService;
    private final EmpleadoRepository empleadoRepository;

    public CofpatioService(CofpatioRepository cofpatioRepository,
                           BusService busService,
                           EmpleadoRepository empleadoRepository) {
        this.cofpatioRepository = cofpatioRepository;
        this.busService = busService;
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public CofpatioResponseDto create(CreateCofpatioDto dto) {
        Cofpatio cofpatio = new Cofpatio();

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            cofpatio.setBus(bus);
        }
        if (dto.getIdEmpleadoConductor() != null) {
            Empleado conductor = empleadoRepository.findById(dto.getIdEmpleadoConductor())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoConductor()));
            cofpatio.setConductor(conductor);
        }
        if (dto.getIdEmpleadoMecanico() != null) {
            Empleado mecanico = empleadoRepository.findById(dto.getIdEmpleadoMecanico())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoMecanico()));
            cofpatio.setMecanico(mecanico);
        }
        if (dto.getIdEmpleadoResponsable() != null) {
            Empleado responsable = empleadoRepository.findById(dto.getIdEmpleadoResponsable())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoResponsable()));
            cofpatio.setResponsable(responsable);
        }
        if (dto.getIdEmpleadoResponsableCierre() != null) {
            Empleado responsableCierre = empleadoRepository.findById(dto.getIdEmpleadoResponsableCierre())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoResponsableCierre()));
            cofpatio.setResponsableCierre(responsableCierre);
        }

        cofpatio.setKm(dto.getKm());
        cofpatio.setFechaHora(dto.getFechaHora());
        cofpatio.setFechaHoraOperativa(dto.getFechaHoraOperativa());
        cofpatio.setLugarPanne(dto.getLugarPanne());
        cofpatio.setCofPatio(dto.getCofPatio());
        cofpatio.setNroCp(dto.getNroCp());
        cofpatio.setCombustible(dto.getCombustible());
        cofpatio.setFalla(dto.getFalla());
        cofpatio.setUbicacion(dto.getUbicacion());
        cofpatio.setCabezal(dto.getCabezal());
        cofpatio.setHoraReal(dto.getHoraReal());
        cofpatio.setTrabajoTerreno(dto.getTrabajoTerreno());
        cofpatio.setObsTerreno(dto.getObsTerreno());
        cofpatio.setOperativaTerreno(dto.getOperativaTerreno());
        cofpatio.setGrua(dto.getGrua());
        cofpatio.setHoraLevantamiento(dto.getHoraLevantamiento());
        cofpatio.setTiempoDetencion(dto.getTiempoDetencion());
        cofpatio.setAceiteMotor(dto.getAceiteMotor());
        cofpatio.setAceiteTrans(dto.getAceiteTrans());
        cofpatio.setAceiteDir(dto.getAceiteDir());
        cofpatio.setRefrigerante(dto.getRefrigerante());
        cofpatio.setCodigoPanne(dto.getCodigoPanne());
        cofpatio.setIdIntranet(dto.getIdIntranet());
        cofpatio.setUbicacion2(dto.getUbicacion2());
        cofpatio.setUbicacionTerreno(dto.getUbicacionTerreno());
        cofpatio.setTipoFalla(dto.getTipoFalla());

        return toDto(cofpatioRepository.save(cofpatio));
    }

    @Transactional(readOnly = true)
    public List<CofpatioResponseDto> findAll() {
        return cofpatioRepository.findAllWithRelations()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CofpatioResponseDto findById(Integer id) {
        return toDto(cofpatioRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cofpatio", "id", id)));
       
    }

    @Transactional(readOnly = true)
    public List<CofpatioResponseDto> findByBus(Integer idBus) {
        return cofpatioRepository.findByBusWithRelations(idBus)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public CofpatioResponseDto update(Integer id, UpdateCofpatioDto dto) {
        Cofpatio cofpatio = cofpatioRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cofpatio", "id", id));

        if (dto.getIdBus() != null) {
            Bus bus = busService.findById(dto.getIdBus());
            cofpatio.setBus(bus);
        }
        if (dto.getIdEmpleadoConductor() != null) {
            Empleado conductor = empleadoRepository.findById(dto.getIdEmpleadoConductor())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoConductor()));
            cofpatio.setConductor(conductor);
        }
        if (dto.getIdEmpleadoMecanico() != null) {
            Empleado mecanico = empleadoRepository.findById(dto.getIdEmpleadoMecanico())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoMecanico()));
            cofpatio.setMecanico(mecanico);
        }
        if (dto.getIdEmpleadoResponsable() != null) {
            Empleado responsable = empleadoRepository.findById(dto.getIdEmpleadoResponsable())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoResponsable()));
            cofpatio.setResponsable(responsable);
        }
        if (dto.getIdEmpleadoResponsableCierre() != null) {
            Empleado responsableCierre = empleadoRepository.findById(dto.getIdEmpleadoResponsableCierre())
                    .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", dto.getIdEmpleadoResponsableCierre()));
            cofpatio.setResponsableCierre(responsableCierre);
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
        if (dto.getGrua() != null) {
            cofpatio.setGrua(dto.getGrua());
        }
        if (dto.getHoraLevantamiento() != null) {
            cofpatio.setHoraLevantamiento(dto.getHoraLevantamiento());
        }
        if (dto.getTiempoDetencion() != null) {
            cofpatio.setTiempoDetencion(dto.getTiempoDetencion());
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

        return toDto(cofpatioRepository.save(cofpatio));
    }

    @Transactional
    public DeleteCofpatioResponseDto delete(Integer id) {
        Cofpatio cofpatio = cofpatioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cofpatio", "id", id));
        cofpatioRepository.delete(cofpatio);
        return new DeleteCofpatioResponseDto(cofpatio.getId(), "Cofpatio eliminado exitosamente");
    }

    private CofpatioResponseDto toDto(Cofpatio c) {
        CofpatioResponseDto dto = new CofpatioResponseDto();
        dto.setId(c.getId());
        if (c.getBus() != null) {
            dto.setIdBus(c.getBus().getIdBus());
            dto.setPatenteB(c.getBus().getPatenteB());
        }
        if (c.getConductor() != null) {
            dto.setIdEmpleadoConductor(c.getConductor().getId());
            dto.setNombreCompletoConductor(
                c.getConductor().getNombres() + " " +
                c.getConductor().getApellidoPaterno() + " " +
                c.getConductor().getApellidoMaterno()
            );
        }
        if (c.getMecanico() != null) {
            dto.setIdEmpleadoMecanico(c.getMecanico().getId());
            dto.setNombreCompletoMecanico(
                c.getMecanico().getNombres() + " " +
                c.getMecanico().getApellidoPaterno() + " " +
                c.getMecanico().getApellidoMaterno()
            );
        }
        if (c.getResponsable() != null) {
            dto.setIdEmpleadoResponsable(c.getResponsable().getId());
            dto.setNombreCompletoResponsable(
                c.getResponsable().getNombres() + " " +
                c.getResponsable().getApellidoPaterno() + " " +
                c.getResponsable().getApellidoMaterno()
            );
        }
        if (c.getResponsableCierre() != null) {
            dto.setIdEmpleadoResponsableCierre(c.getResponsableCierre().getId());
            dto.setNombreCompletoResponsableCierre(
                c.getResponsableCierre().getNombres() + " " +
                c.getResponsableCierre().getApellidoPaterno() + " " +
                c.getResponsableCierre().getApellidoMaterno()
            );
        }
        dto.setKm(c.getKm());
        dto.setFechaHora(c.getFechaHora());
        dto.setFechaHoraOperativa(c.getFechaHoraOperativa());
        dto.setLugarPanne(c.getLugarPanne());
        dto.setCofPatio(c.getCofPatio());
        dto.setNroCp(c.getNroCp());
        dto.setCombustible(c.getCombustible());
        dto.setFalla(c.getFalla());
        dto.setUbicacion(c.getUbicacion());
        dto.setCabezal(c.getCabezal());
        dto.setHoraReal(c.getHoraReal());
        dto.setTrabajoTerreno(c.getTrabajoTerreno());
        dto.setObsTerreno(c.getObsTerreno());
        dto.setOperativaTerreno(c.getOperativaTerreno());
        dto.setGrua(c.getGrua());
        dto.setHoraLevantamiento(c.getHoraLevantamiento());
        dto.setTiempoDetencion(c.getTiempoDetencion());
        dto.setAceiteMotor(c.getAceiteMotor());
        dto.setAceiteTrans(c.getAceiteTrans());
        dto.setAceiteDir(c.getAceiteDir());
        dto.setRefrigerante(c.getRefrigerante());
        dto.setCodigoPanne(c.getCodigoPanne());
        dto.setIdIntranet(c.getIdIntranet());
        dto.setUbicacion2(c.getUbicacion2());
        dto.setUbicacionTerreno(c.getUbicacionTerreno());
        dto.setTipoFalla(c.getTipoFalla());
        return dto;
    }
}
