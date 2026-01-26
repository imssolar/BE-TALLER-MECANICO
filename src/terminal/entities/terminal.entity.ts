import { Column, Entity, OneToMany, PrimaryColumn } from 'typeorm';
import { Bus } from '../../buses/entities/bus.entity';

@Entity('terminal')
export class Terminal {
  @PrimaryColumn({ name: 'id_terminal' })
  idTerminal: number;

  @Column({ type: 'varchar', length: 15, nullable: true })
  terminal: string;

  @Column({ type: 'varchar', length: 3, nullable: true })
  prefijo: string;

  @OneToMany(() => Bus, (bus) => bus.terminal)
  buses: Bus[];
}
