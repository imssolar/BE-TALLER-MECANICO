import { IsNotEmpty, IsString, MaxLength } from 'class-validator';

export class CreateModelosNeumaticoDto {
  @IsString()
  @IsNotEmpty({ message: 'El modelo es requerido' })
  @MaxLength(15, { message: 'El modelo no puede exceder 15 caracteres' })
  modelo: string;
}
