import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity('estados_neumatico')
export class EstadosNeumatico {
    @PrimaryGeneratedColumn()
    id: number;

    @Column({ name: 'estado', type: 'varchar', length: 15, nullable: false })
    estado: string;
}
