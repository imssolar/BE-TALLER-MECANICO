export class DeleteMarcasNeumaticoResponseDto {
  id: number;
  marca: string;
  mensaje: string;

  constructor(id: number, marca: string) {
    this.id = id;
    this.marca = marca;
    this.mensaje = `Marca "${marca}" eliminada correctamente`;
  }
}
