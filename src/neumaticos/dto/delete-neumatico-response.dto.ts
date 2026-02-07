export class DeleteNeumaticoResponseDto {
  id: number;
  idBus: number;
  posicion: number | null;
  mensaje: string;

  constructor(id: number, idBus: number, posicion: number | null) {
    this.id = id;
    this.idBus = idBus;
    this.posicion = posicion;
    this.mensaje = `Neumático ID ${id} del bus ${idBus}${posicion ? ` (posición ${posicion})` : ''} eliminado correctamente`;
  }
}
