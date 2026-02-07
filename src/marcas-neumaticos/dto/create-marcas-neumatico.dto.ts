import { IsNotEmpty, IsString, MaxLength } from "class-validator";

export class CreateMarcasNeumaticoDto {

    @IsString()
    @IsNotEmpty({ message: 'La marca es requerida' })
    @MaxLength(15, { message: 'La marca no puede sobrepasar los 15 caracteres' })
    marca: string;
}
