import { IsNotEmpty, IsString, MaxLength, MinLength } from "class-validator";

export class CreateRutaDto {

    @IsString()
    @IsNotEmpty()
    @MinLength(3)
    @MaxLength(50)
    ruta: string;

}
