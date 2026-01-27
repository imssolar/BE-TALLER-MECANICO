import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';
import { CargoEmpleado } from '../enums/cargo-empleado.enum';

@Entity('empleados')
export class Empleado {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ type: 'varchar', length: 12, unique: true })
  rut: string;

  @Column({ type: 'varchar', length: 30 })
  nombres: string;

  @Column({ name: 'apellido_paterno', type: 'varchar', length: 20 })
  apellidoPaterno: string;

  @Column({ name: 'apellido_materno', type: 'varchar', length: 20 })
  apellidoMaterno: string;

  @Column({ type: 'enum', enum: CargoEmpleado })
  cargo: CargoEmpleado;

  @Column({ type: 'varchar', length: 15, nullable: true })
  telefono: string | null;

  @Column({ type: 'boolean', default: true })
  activo: boolean;

  @Column({ name: 'fecha_ingreso', type: 'date', nullable: true })
  fechaIngreso: Date | null;

  @Column({ name: 'licencia_conducir', type: 'varchar', length: 10, nullable: true })
  licenciaConducir: string | null;

  @Column({ name: 'fecha_vencimiento_licencia', type: 'date', nullable: true })
  fechaVencimientoLicencia: Date | null;
}
