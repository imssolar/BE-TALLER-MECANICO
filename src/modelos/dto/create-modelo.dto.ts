import {
  IsNotEmpty,
  IsNumber,
  IsOptional,
  IsString,
  MaxLength,
  Min,
} from 'class-validator';

export class CreateModeloDto {
  @IsNumber()
  @IsNotEmpty({ message: 'El ID del modelo es requerido' })
  idModelo: number;

  @IsString()
  @IsOptional()
  @MaxLength(15, { message: 'El nombre del modelo no puede exceder 15 caracteres' })
  modelo?: string;

  @IsNumber()
  @IsOptional()
  @Min(0, { message: 'El kilometraje diario no puede ser negativo' })
  kmDiario?: number;

  @IsString()
  @IsOptional()
  @MaxLength(35, { message: 'Las observaciones no pueden exceder 35 caracteres' })
  obs?: string;
}
