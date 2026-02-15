import { IsInt, IsNotEmpty, IsNumber, IsString, Length, Max, Min } from "class-validator";

export class CreateVehiculoDto {
    @IsString({ message: "La patente debe ser texto" })
    @IsNotEmpty({ message: "La patente es obligatoria" })
    @Length(6, 10, { message: "La patente debe tener entre 6 a 10 caracteres" })
    patente: string;

    @IsString({ message: "La marca debe ser texto" })
    @IsNotEmpty({ message: "La marca es obligatoria" })
    @Length(1, 50, { message: "La marca debe tener máximo 50 caracteres" })
    marca: string;

    @IsString({ message: "El modelo debe ser texto" })
    @IsNotEmpty({ message: "El modelo es obligatorio" })
    @Length(1, 50, { message: "El modelo debe tener máximo 50 caracteres" })
    modelo: string;

    @IsNumber()
    @IsNotEmpty({ message: "El año del vehículo es obligatorio" })
    @Min(1990, { message: "El año mínimo debe ser 1990" }) 
    @Max(2030, { message: "El año máximo debe ser 2030" })
    anio: number;

    @IsNumber()
    @IsNotEmpty({ message: "El kilometraje del vehículo es obligatorio" })
    @Min(0, { message: "El kilometraje no puede ser negativo" })  // ✅
    kilometraje: number;

    @IsNumber()
    @IsNotEmpty({ message: "El vehículo debe estar relacionado a un Cliente" })
    @IsInt()
    clienteId: number;
}
