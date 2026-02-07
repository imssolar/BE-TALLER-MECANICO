import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity('modelos_neumatico')
export class ModelosNeumatico {
    @PrimaryGeneratedColumn()
    id: number;

    @Column({ name: 'modelo', type: 'varchar', length: 15, nullable: true })
    modelo: string | null;
}
