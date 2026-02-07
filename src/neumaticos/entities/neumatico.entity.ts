import { Bus } from '../../buses/entities/bus.entity';
import { EstadosNeumatico } from '../../estados-neumatico/entities/estados-neumatico.entity';
import { MarcasNeumatico } from '../../marcas-neumaticos/entities/marcas-neumatico.entity';
import { ModelosNeumatico } from '../../modelos-neumatico/entities/modelos-neumatico.entity';
import { Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn } from 'typeorm';

@Entity('neumaticos')
export class Neumatico {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ name: 'fecha_instalacion', type: 'date', nullable: true })
  fechaInstalacion: Date | null;

  @Column({ name: 'kilometraje', type: 'int', nullable: true })
  kilometraje: number | null;

  @Column({ name: 'posicion', type: 'smallint', nullable: true })
  posicion: number | null;

  @Column({ name: 'profundidad', type: 'decimal', precision: 8, scale: 2, nullable: true })
  profundidad: number | null;

  @Column({ name: 'presion', type: 'int', nullable: true })
  presion: number | null;

  @Column({ name: 'marca_fuego', type: 'varchar', length: 15, nullable: true })
  marcaFuego: string | null;

  @Column({ name: 'activo', type: 'boolean', default: true })
  activo: boolean;

  @Column({ name: 'motivo_cambio', type: 'varchar', length: 20, nullable: true })
  motivoCambio: string | null;

  @Column({ name: 'fecha_cambio', type: 'date', nullable: true })
  fechaCambio: Date | null;

  @Column({ name: 'km_cambio', type: 'numeric', nullable: true })
  kmCambio: number | null;

  @Column({ name: 'observaciones', type: 'varchar', length: 30, nullable: true })
  observaciones: string | null;

  @ManyToOne(() => Bus)
  @JoinColumn({ name: 'id_bus' })
  bus: Bus;

  @ManyToOne(() => EstadosNeumatico)
  @JoinColumn({ name: 'id_estado' })
  estado: EstadosNeumatico;

  @ManyToOne(() => MarcasNeumatico)
  @JoinColumn({ name: 'id_marca' })
  marca: MarcasNeumatico;

  @ManyToOne(() => ModelosNeumatico)
  @JoinColumn({ name: 'id_modelo' })
  modelo: ModelosNeumatico;
}
