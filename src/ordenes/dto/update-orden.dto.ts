import { PartialType } from '@nestjs/mapped-types';
import { IsDate, IsEnum, IsNumber, IsOptional, IsPositive, IsString, MaxLength } from 'class-validator';
import { Type } from 'class-transformer';
import { CreateOrdenDto } from './create-orden.dto';
import { EstadoOrden } from '../enums/estado-orden.enum';

export class UpdateOrdenDto extends PartialType(CreateOrdenDto) {
  @IsOptional()
  @IsEnum(EstadoOrden, { 
    message: 'Estado inválido. Valores permitidos: RECIBIDO, DIAGNOSTICO, EN_REPARACION, COMPLETADO, ENTREGADO, CANCELADO' 
  })
  estado?: EstadoOrden;

  @IsOptional()
  @IsString({ message: "El diagnóstico debe ser texto" })
  @MaxLength(500, { message: "El diagnóstico debe tener máximo 500 caracteres" })
  diagnostico?: string;

  @IsOptional()
  @IsNumber()
  @IsPositive({ message: "El costo total debe ser positivo" })
  costoTotal?: number;

  @IsOptional()
  @Type(() => Date)
  @IsDate({ message: "La fecha de salida debe ser una fecha válida" })
  fechaSalida?: Date;
}
