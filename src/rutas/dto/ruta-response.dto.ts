import { Ruta } from "../entities/ruta.entity";


export class RutaResponseDto {
    idRuta: number;
    ruta: string;

    constructor(entity: Ruta) {
        this.idRuta = entity.idRuta;
        this.ruta = entity.ruta
    }
}