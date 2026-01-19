import { IsNotEmpty, IsNumber, IsOptional, IsPositive, IsString, Length, MaxLength } from "class-validator";

export class CreateOrdenDto {
  @IsString({ message: "La descripción debe ser texto" })
  @IsNotEmpty({ message: "La descripción es obligatoria" })
  @Length(10, 500, { message: "La descripción debe tener entre 10 y 500 caracteres" })
  descripcion: string;

  @IsNumber()
  @IsNotEmpty({ message: "El vehículo es obligatorio" })
  @IsPositive({ message: "El vehiculoId debe ser un número positivo" })
  vehiculoId: number;

  @IsOptional()
  @IsString({ message: "El diagnóstico debe ser texto" })
  @MaxLength(500, { message: "El diagnóstico debe tener máximo 500 caracteres" })
  diagnostico?: string;
}
