export class DeleteEmpleadoResponseDto {
    message: string;
    id: number;
    nombreCompleto: string;
    rut: string;
  
    constructor(id: number, nombres: string, apellidoPaterno: string, apellidoMaterno: string, rut: string) {
      this.id = id;
      this.nombreCompleto = `${nombres} ${apellidoPaterno} ${apellidoMaterno}`.trim();
      this.rut = rut;
      this.message = `Empleado "${this.nombreCompleto}" (RUT: ${rut}) eliminado exitosamente`;
    }
  }