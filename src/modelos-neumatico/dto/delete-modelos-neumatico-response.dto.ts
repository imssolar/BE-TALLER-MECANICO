export class DeleteModelosNeumaticoResponseDto {
  id: number;
  modelo: string;
  mensaje: string;

  constructor(id: number, modelo: string) {
    this.id = id;
    this.modelo = modelo;
    this.mensaje = `Modelo "${modelo}" eliminado correctamente`;
  }
}
