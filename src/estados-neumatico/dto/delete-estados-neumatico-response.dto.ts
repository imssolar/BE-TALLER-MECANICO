export class DeleteEstadosNeumaticoResponseDto {
  id: number;
  estado: string;
  mensaje: string;

  constructor(id: number, estado: string) {
    this.id = id;
    this.estado = estado;
    this.mensaje = `Estado "${estado}" eliminado correctamente`;
  }
}
