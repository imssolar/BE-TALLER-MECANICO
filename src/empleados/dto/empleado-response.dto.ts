import { Empleado } from '../entities/empleado.entity';
import { CargoEmpleado } from '../enums/cargo-empleado.enum';

export class EmpleadoResponseDto {
  id: number;
  rut: string;
  nombres: string;
  apellidoPaterno: string;
  apellidoMaterno: string;
  nombreCompleto: string;
  cargo: CargoEmpleado;
  telefono: string | null;
  activo: boolean;
  fechaIngreso: Date | null;
  licenciaConducir: string | null;
  fechaVencimientoLicencia: Date | null;

  constructor(entity: Empleado) {
    this.id = entity.id;
    this.rut = entity.rut;
    this.nombres = entity.nombres;
    this.apellidoPaterno = entity.apellidoPaterno;
    this.apellidoMaterno = entity.apellidoMaterno;
    this.nombreCompleto = `${entity.nombres} ${entity.apellidoPaterno} ${entity.apellidoMaterno}`.trim();
    this.cargo = entity.cargo;
    this.telefono = entity.telefono;
    this.activo = entity.activo;
    this.fechaIngreso = entity.fechaIngreso;
    this.licenciaConducir = entity.licenciaConducir;
    this.fechaVencimientoLicencia = entity.fechaVencimientoLicencia;
  }
}