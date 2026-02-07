import { IsNotEmpty, IsString, MaxLength } from "class-validator";

export class CreateEstadosNeumaticoDto {

    @IsString()
    @IsNotEmpty({ message: 'El estado es requerido' })
    @MaxLength(15, { message: 'El estado no puede exceder 15 caracteres' })
    estado: string;
}
