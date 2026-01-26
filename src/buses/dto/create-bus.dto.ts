import {
  IsBoolean,
  IsDateString,
  IsNotEmpty,
  IsNumber,
  IsOptional,
  IsString,
  MaxLength,
  Min,
} from 'class-validator';

export class CreateBusDto {
  @IsNumber()
  @IsNotEmpty({ message: 'El ID del bus es requerido' })
  idBus: number;

  @IsString()
  @IsOptional()
  @MaxLength(8, { message: 'La patente no puede exceder 8 caracteres' })
  patenteB?: string;

  @IsString()
  @IsOptional()
  @MaxLength(50, { message: 'La marca no puede exceder 50 caracteres' })
  marcaB?: string;

  @IsString()
  @IsOptional()
  @MaxLength(50, { message: 'El motor no puede exceder 50 caracteres' })
  motorB?: string;

  @IsNumber()
  @IsOptional()
  @Min(1900, { message: 'El año de fabricación debe ser mayor a 1900' })
  anioFabB?: number;

  @IsString()
  @IsOptional()
  @MaxLength(15, { message: 'La transmisión no puede exceder 15 caracteres' })
  transmisionB?: string;

  @IsBoolean()
  @IsOptional()
  operativaB?: boolean;

  @IsNumber()
  @IsOptional()
  @Min(0, { message: 'El kilometraje no puede ser negativo' })
  kmB?: number;

  @IsString()
  @IsOptional()
  @MaxLength(2, { message: 'La zona no puede exceder 2 caracteres' })
  zonaB?: string;

  @IsNumber()
  @IsOptional()
  @Min(0)
  nroNeumaticosB?: number;

  @IsBoolean()
  @IsOptional()
  activoB?: boolean;

  @IsNumber()
  @IsOptional()
  @Min(0)
  nroBaterias?: number;

  @IsDateString({}, { message: 'La fecha de emergencia debe ser una fecha válida' })
  @IsOptional()
  fechaEmergencia?: string;

  @IsString()
  @IsOptional()
  @MaxLength(80, { message: 'Las observaciones de emergencia no pueden exceder 80 caracteres' })
  obsEmergenciaB?: string;

  @IsBoolean()
  @IsOptional()
  abastecimientoB?: boolean;

  @IsBoolean()
  @IsOptional()
  mantencionB?: boolean;

  @IsBoolean()
  @IsOptional()
  operacionB?: boolean;

  @IsBoolean()
  @IsOptional()
  noControladaB?: boolean;

  @IsBoolean()
  @IsOptional()
  operativaPatio?: boolean;

  @IsString()
  @IsOptional()
  @MaxLength(10, { message: 'El proyecto de reparación no puede exceder 10 caracteres' })
  proyRep?: string;

  // Foreign Keys
  @IsNumber()
  @IsNotEmpty({ message: 'El ID del terminal es requerido' })
  idTerminal: number;

  @IsNumber()
  @IsNotEmpty({ message: 'El ID del modelo es requerido' })
  idModelo: number;
}
