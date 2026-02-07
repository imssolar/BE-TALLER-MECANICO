import { EstadosNeumatico } from "@/estados-neumatico/entities/estados-neumatico.entity";
import { MarcasNeumatico } from "@/marcas-neumaticos/entities/marcas-neumatico.entity";
import { ModelosNeumatico } from "@/modelos-neumatico/entities/modelos-neumatico.entity";
import { Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn } from "typeorm";

@Entity('neumaticos')
export class Neumatico {
    @PrimaryGeneratedColumn()
    id: number;

    @Column({ name: 'fecha_instalacion', type: 'date', nullable: false })
    fechaInstalacion: Date;

    @Column({ name: 'kilometraje', type: 'numeric', nullable: false })
    kilometraje: number;

    @Column({ name: 'posicion', type: 'smallint', nullable: false })
    posicion: number;


    @Column({ name: 'profundidad', type: 'decimal' })
    profundidad: number;

    @Column({ name: 'presion', type: 'decimal', nullable: true })
    presion: number | null;

    @Column({ name: 'marca_fuego', type: 'varchar', length: 15, nullable: true })
    marcaFuego: string;

    @Column({ name: 'motivo_cambio', type: 'varchar', nullable: true })
    motivoCambio: string;

    @Column({ name: 'fecha_cambio', type: 'date', nullable: true })
    fechaCambio: Date | null;

    @Column({ name: 'km_cambio', type: 'numeric', nullable: true })
    kmCambio: number | null;

    @Column({ name: 'observaciones', type: 'varchar', length: 30, nullable: true })
    observaciones: string | null;

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
