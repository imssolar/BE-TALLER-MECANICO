import { Vehiculo } from "src/vehiculos/entities/vehiculo.entity";
import { Column, Entity, OneToMany, PrimaryGeneratedColumn } from "typeorm";

@Entity('clientes')
export class Cliente {

    @PrimaryGeneratedColumn()
    id: number

    @Column({ length: 20 })
    nombre: string

    @Column({ length: 20 })
    telefono: string

    @Column({ length: 100, nullable: false })
    email: string

    @Column({ length: 20, unique: true })
    rut: string

    @OneToMany(() => Vehiculo, (vehiculo) => vehiculo.cliente)
    vehiculos: Vehiculo[]
}
