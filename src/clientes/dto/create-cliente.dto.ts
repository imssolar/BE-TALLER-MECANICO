import { IsEmail, IsNotEmpty, IsOptional, IsString, Length } from "class-validator"

export class CreateClienteDto {
    @IsString({ message: "el nombre debe ser texto" })
    @IsNotEmpty({ message: "El nombre es obligatorio" })
    @Length(2, 100, { message: "El nombre debe tener entre 2 y 100 caracteres" })
    nombre: string

    @IsString({ message: 'El teléfono debe ser texto' })
    @IsNotEmpty({ message: 'El teléfono es obligatorio' })
    @Length(8, 20, { message: 'El teléfono debe tener entre 8 y 20 caracteres' })
    telefono: string

    @IsOptional()
    @IsEmail({}, { message: "El email debe ser válido" })
    email?: string

    @IsString({ message: 'El RUT debe ser texto' })
    @IsNotEmpty({ message: 'El RUT es obligatorio' })
    @Length(8, 20, { message: 'El RUT debe tener entre 8 y 20 caracteres' })
    rut: string
}
