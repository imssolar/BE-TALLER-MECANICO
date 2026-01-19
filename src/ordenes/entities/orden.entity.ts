import { Column, Entity, ManyToOne, PrimaryGeneratedColumn } from 'typeorm';
import { Vehiculo } from '../../vehiculos/entities/vehiculo.entity';
import { EstadoOrden } from '../enums/estado-orden.enum';

@Entity('ordenes')
export class Orden {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ type: 'timestamp', default: () => 'CURRENT_TIMESTAMP' })
  fechaIngreso: Date;

  @Column({ type: 'timestamp', nullable: true })
  fechaSalida: Date;

  @Column({
    type: 'enum',
    enum: EstadoOrden,
    default: EstadoOrden.RECIBIDO,
  })
  estado: EstadoOrden;

  @Column({ length: 500 })
  descripcion: string;

  @Column({ length: 500, nullable: true })
  diagnostico: string;

  @Column({ type: 'decimal', precision: 10, scale: 2, nullable: true })
  costoTotal: number;

  @ManyToOne(() => Vehiculo, (vehiculo) => vehiculo.ordenes)
  vehiculo: Vehiculo;
}
