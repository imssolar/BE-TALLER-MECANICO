import { Column, Entity, OneToMany, PrimaryColumn } from 'typeorm';
import { Bus } from '../../buses/entities/bus.entity';

@Entity('modelos')
export class Modelo {
  @PrimaryColumn({ name: 'id_modelo' })
  idModelo: number;

  @Column({ type: 'varchar', length: 15, nullable: true })
  modelo: string;

  @Column({
    name: 'km_diario',
    type: 'numeric',
    precision: 18,
    scale: 0,
    nullable: true,
  })
  kmDiario: number;

  @Column({ type: 'varchar', length: 35, nullable: true })
  obs: string;

  @OneToMany(() => Bus, (bus) => bus.modelo)
  buses: Bus[];
}
