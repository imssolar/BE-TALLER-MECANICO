import { Cliente } from "../../clientes/entities/cliente.entity";
import { Orden } from "../../ordenes/entities/orden.entity";
import { Column, Entity, ManyToOne, OneToMany, PrimaryGeneratedColumn } from "typeorm";

@Entity('vehiculos')
export class Vehiculo {
    @PrimaryGeneratedColumn()
    id: number;

    @Column({ length: 10, unique: true })
    patente: string;

    @Column({ length: 50 })
    marca: string;

    @Column({ length: 50 })
    modelo: string;

    @Column()
    anio: number;

    @Column()
    kilometraje: number;

    @ManyToOne(() => Cliente, (cliente) => cliente.vehiculos)
    cliente: Cliente;

    @OneToMany(() => Orden, (orden) => orden.vehiculo)
    ordenes: Orden[];
}
