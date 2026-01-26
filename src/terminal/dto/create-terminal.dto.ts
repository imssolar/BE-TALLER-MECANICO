import {
  IsNotEmpty,
  IsNumber,
  IsOptional,
  IsString,
  MaxLength,
} from 'class-validator';

export class CreateTerminalDto {
  @IsNumber()
  @IsNotEmpty({ message: 'El ID del terminal es requerido' })
  idTerminal: number;

  @IsString()
  @IsOptional()
  @MaxLength(15, { message: 'El nombre del terminal no puede exceder 15 caracteres' })
  terminal?: string;

  @IsString()
  @IsOptional()
  @MaxLength(3, { message: 'El prefijo no puede exceder 3 caracteres' })
  prefijo?: string;
}
