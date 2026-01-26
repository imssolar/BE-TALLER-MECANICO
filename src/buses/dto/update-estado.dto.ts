import { IsBoolean, IsNotEmpty } from 'class-validator';

export class UpdateEstadoDto {
  @IsBoolean()
  @IsNotEmpty({ message: 'El estado operativo es requerido' })
  operativaB: boolean;
}
