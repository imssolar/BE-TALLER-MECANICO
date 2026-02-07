import {
  IsDateString,
  IsNotEmpty,
  IsNumber,
  IsOptional,
  IsString,
  Max,
  MaxLength,
  Min,
} from 'class-validator';

export class CreateNeumaticoDto {
  @IsNumber()
  @IsNotEmpty({ message: 'El ID del bus es requerido' })
  idBus: number;

  @IsNumber()
  @IsNotEmpty({ message: 'El ID del estado es requerido' })
  idEstado: number;

  @IsNumber()
  @IsNotEmpty({ message: 'El ID de la marca es requerida' })
  idMarca: number;

  @IsNumber()
  @IsNotEmpty({ message: 'El ID del modelo es requerido' })
  idModelo: number;

  @IsDateString({}, { message: 'La fecha de instalación debe ser válida' })
  @IsOptional()
  fechaInstalacion?: string;

  @IsNumber()
  @IsOptional()
  @Min(0, { message: 'El kilometraje no puede ser negativo' })
  kilometraje?: number;

  @IsNumber()
  @IsOptional()
  @Min(1, { message: 'La posición debe ser al menos 1' })
  @Max(6, { message: 'La posición no puede exceder 6' })
  posicion?: number;

  @IsNumber()
  @IsOptional()
  @Min(0, { message: 'La profundidad no puede ser negativa' })
  profundidad?: number;

  @IsNumber()
  @IsOptional()
  @Min(0, { message: 'La presión no puede ser negativa' })
  presion?: number;

  @IsString()
  @IsOptional()
  @MaxLength(15, { message: 'La marca de fuego no puede exceder 15 caracteres' })
  marcaFuego?: string;

  @IsString()
  @IsOptional()
  @MaxLength(30, { message: 'Las observaciones no pueden exceder 30 caracteres' })
  observaciones?: string;
}

