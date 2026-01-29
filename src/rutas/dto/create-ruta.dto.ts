import { IsNotEmpty, IsString, MaxLength } from "class-validator";

export class CreateRutaDto {

    @IsString()
    @IsNotEmpty()
    @MaxLength(50)
    ruta: string;

}
