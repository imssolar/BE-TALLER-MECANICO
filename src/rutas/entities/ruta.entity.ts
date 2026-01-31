import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity('rutas')
export class Ruta {
    @PrimaryGeneratedColumn({ name: 'id_ruta' })
    idRuta: number;

    @Column({ name: 'ruta', type: 'varchar', nullable: false, length: 50 })
    ruta: string;
}
