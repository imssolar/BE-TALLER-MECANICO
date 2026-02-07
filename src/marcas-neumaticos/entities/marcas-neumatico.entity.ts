import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity('marcas_neumatico')
export class MarcasNeumatico {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({ name: 'marca', type: 'varchar', length: 15, nullable: true })
    marca: string | null;
}
