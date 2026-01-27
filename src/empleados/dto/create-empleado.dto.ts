import {
  IsBoolean,
  IsDateString,
  IsEnum,
  IsNotEmpty,
  IsOptional,
  IsString,
  Matches,
  MaxLength,
} from 'class-validator';
import { CargoEmpleado } from '../enums/cargo-empleado.enum';

export class CreateEmpleadoDto {
  @IsString({ message: 'El RUT debe ser texto' })
  @IsNotEmpty({ message: 'El RUT es requerido' })
  @MaxLength(12, { message: 'El RUT no puede exceder 12 caracteres' })
  @Matches(/^[0-9]+-[0-9kK]$/, { 
    message: 'El RUT debe tener formato válido (ej: 12345678-9)' 
  })
  rut: string;

  @IsString({ message: 'Los nombres deben ser texto' })
  @IsNotEmpty({ message: 'Los nombres son requeridos' })
  @MaxLength(30, { message: 'Los nombres no pueden exceder 30 caracteres' })
  nombres: string;

  @IsString({ message: 'El apellido paterno debe ser texto' })
  @IsNotEmpty({ message: 'El apellido paterno es requerido' })
  @MaxLength(20, { message: 'El apellido paterno no puede exceder 20 caracteres' })
  apellidoPaterno: string;

  @IsString({ message: 'El apellido materno debe ser texto' })
  @IsNotEmpty({ message: 'El apellido materno es requerido' })
  @MaxLength(20, { message: 'El apellido materno no puede exceder 20 caracteres' })
  apellidoMaterno: string;

  @IsEnum(CargoEmpleado, { 
    message: `El cargo debe ser uno de: ${Object.values(CargoEmpleado).join(', ')}` 
  })
  @IsNotEmpty({ message: 'El cargo es requerido' })
  cargo: CargoEmpleado;

  @IsString({ message: 'El teléfono debe ser texto' })
  @IsOptional()
  @MaxLength(15, { message: 'El teléfono no puede exceder 15 caracteres' })
  @Matches(/^(\+?56)?[2-9]\d{8}$/, { 
    message: 'El teléfono debe ser válido (ej: +56912345678 o 912345678)' 
  })
  telefono?: string;

  @IsDateString({}, { message: 'La fecha de ingreso debe ser válida (formato ISO)' })
  @IsNotEmpty({ message: 'La fecha de ingreso es requerida' })
  fechaIngreso: string;

  @IsBoolean({ message: 'Activo debe ser verdadero o falso' })
  @IsOptional()
  activo?: boolean = true; // Valor por defecto
}