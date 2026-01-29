
export class DeleteResponseDto{
    message: string;
    idRuta: number;
    ruta: string;

    constructor(id: number, nombreRuta: string){
        this.message = `Ruta ${nombreRuta} eliminada exitosamente`
        this.idRuta = id;
        this.ruta = nombreRuta;
    }
}