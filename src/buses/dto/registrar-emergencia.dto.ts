import { IsDateString, IsOptional, IsString, MaxLength } from 'class-validator';

export class RegistrarEmergenciaDto {
  @IsDateString({}, { message: 'La fecha de emergencia debe ser una fecha válida' })
  fechaEmergencia: string;

  @IsString()
  @IsOptional()
  @MaxLength(80, { message: 'Las observaciones no pueden exceder 80 caracteres' })
  obsEmergenciaB?: string;
}
