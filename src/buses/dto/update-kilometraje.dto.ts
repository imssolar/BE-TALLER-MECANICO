import { IsNotEmpty, IsNumber, Min } from 'class-validator';

export class UpdateKilometrajeDto {
  @IsNumber()
  @IsNotEmpty({ message: 'El kilometraje es requerido' })
  @Min(0, { message: 'El kilometraje no puede ser negativo' })
  kmB: number;
}
