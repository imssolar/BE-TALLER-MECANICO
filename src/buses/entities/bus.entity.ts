import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  PrimaryColumn,
} from 'typeorm';
import { Terminal } from '../../terminal/entities/terminal.entity';
import { Modelo } from '../../modelos/entities/modelo.entity';

@Entity('buses')
export class Bus {
  @PrimaryColumn({ name: 'id_bus' })
  idBus: number;

  @Column({ name: 'patente_b', type: 'varchar', length: 8, nullable: true })
  patenteB: string;

  @Column({ name: 'marca_b', type: 'varchar', length: 50, nullable: true })
  marcaB: string;

  @Column({ name: 'motor_b', type: 'varchar', length: 50, nullable: true })
  motorB: string;

  @Column({ name: 'anio_fab_b', type: 'numeric', nullable: true })
  anioFabB: number;

  @Column({ name: 'transmision_b', type: 'varchar', length: 15, nullable: true })
  transmisionB: string;

  @Column({ name: 'operativa_b', type: 'boolean', default: false })
  operativaB: boolean;

  @Column({ name: 'km_b', type: 'numeric', nullable: true })
  kmB: number;

  @Column({ name: 'zona_b', type: 'varchar', length: 2, nullable: true })
  zonaB: string;

  @Column({ name: 'nro_neumaticos_b', type: 'smallint', nullable: true })
  nroNeumaticosB: number;

  @Column({ name: 'activo_b', type: 'boolean', default: true })
  activoB: boolean;

  @Column({ name: 'nro_baterias', type: 'numeric', nullable: true })
  nroBaterias: number;

  @Column({ name: 'fecha_emergencia', type: 'timestamp', nullable: true })
  fechaEmergencia: Date;

  @Column({ name: 'obs_emergencia_b', type: 'varchar', length: 80, nullable: true })
  obsEmergenciaB: string | null;

  @Column({ name: 'abastecimiento_b', type: 'boolean', default: false })
  abastecimientoB: boolean;

  @Column({ name: 'mantencion_b', type: 'boolean', default: false })
  mantencionB: boolean;

  @Column({ name: 'operacion_b', type: 'boolean', default: false })
  operacionB: boolean;

  @Column({ name: 'no_controlada_b', type: 'boolean', default: false })
  noControladaB: boolean;

  @Column({ name: 'operativa_patio', type: 'boolean', default: false })
  operativaPatio: boolean;

  @Column({ name: 'proy_rep', type: 'varchar', length: 10, nullable: true })
  proyRep: string;

  @ManyToOne(() => Terminal, (terminal) => terminal.buses)
  @JoinColumn({ name: 'id_terminal' })
  terminal: Terminal;

  @ManyToOne(() => Modelo, (modelo) => modelo.buses)
  @JoinColumn({ name: 'id_modelo' })
  modelo: Modelo;
}
