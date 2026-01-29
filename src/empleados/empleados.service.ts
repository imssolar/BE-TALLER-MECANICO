import { ConflictException, Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Empleado } from './entities/empleado.entity';
import { CreateEmpleadoDto } from './dto/create-empleado.dto';
import { UpdateEmpleadoDto } from './dto/update-empleado.dto';
import { EmpleadoResponseDto } from './dto/empleado-response.dto';
import { DeleteEmpleadoResponseDto } from './dto/delete-empleado-response.dto';
import { CargoEmpleado } from './enums/cargo-empleado.enum';

@Injectable()
export class EmpleadosService {
  constructor(
    @InjectRepository(Empleado)
    private readonly empleadoRepository: Repository<Empleado>,
  ) { }

  // ==================== MÉTODOS PÚBLICOS (CRUD) ====================

  async create(createEmpleadoDto: CreateEmpleadoDto): Promise<EmpleadoResponseDto> {
    await this.validarRutUnico(createEmpleadoDto.rut);
    
    const empleado = this.empleadoRepository.create(createEmpleadoDto);
    const guardado = await this.empleadoRepository.save(empleado);
    
    return new EmpleadoResponseDto(guardado);
  }

  async findAll(): Promise<EmpleadoResponseDto[]> {
    const empleados = await this.empleadoRepository.find({
      order: { id: 'ASC' }
    });
    
    return empleados.map(empleado => new EmpleadoResponseDto(empleado));
  }

  async findOne(id: number): Promise<EmpleadoResponseDto> {
    const empleado = await this.empleadoRepository.findOne({
      where: { id },
    });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con ID ${id} no encontrado`);
    }
    
    return new EmpleadoResponseDto(empleado);
  }

  async findByRut(rut: string): Promise<EmpleadoResponseDto> {
    const empleado = await this.empleadoRepository.findOne({
      where: { rut },
    });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con RUT ${rut} no encontrado`);
    }
    
    return new EmpleadoResponseDto(empleado);
  }

  async update(id: number, updateEmpleadoDto: UpdateEmpleadoDto): Promise<EmpleadoResponseDto> {
    // 1. Buscar empleado actual
    const empleado = await this.empleadoRepository.findOneBy({ id });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con ID ${id} no encontrado`);
    }
    
    // 2. Validar RUT si está cambiando
    if (updateEmpleadoDto.rut && updateEmpleadoDto.rut !== empleado.rut) {
      await this.validarRutUnico(updateEmpleadoDto.rut);
    }
    
    // 3. Actualizar
    Object.assign(empleado, updateEmpleadoDto);
    const actualizado = await this.empleadoRepository.save(empleado);
    
    return new EmpleadoResponseDto(actualizado);
  }

  async remove(id: number): Promise<DeleteEmpleadoResponseDto> {
    // 1. Buscar empleado
    const empleado = await this.empleadoRepository.findOneBy({ id });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con ID ${id} no encontrado`);
    }
    
    // 2. Guardar datos antes de eliminar
    const datosParaResponse = {
      id: empleado.id,
      nombres: empleado.nombres,
      apellidoPaterno: empleado.apellidoPaterno,
      apellidoMaterno: empleado.apellidoMaterno,
      rut: empleado.rut
    };
    
    // 3. Eliminar
    await this.empleadoRepository.delete(id);
    
    // 4. Devolver información de la eliminación
    return new DeleteEmpleadoResponseDto(
      datosParaResponse.id,
      datosParaResponse.nombres,
      datosParaResponse.apellidoPaterno,
      datosParaResponse.apellidoMaterno,
      datosParaResponse.rut
    );
  }

  // ==================== MÉTODOS DE BÚSQUEDA ESPECÍFICOS ====================

  async findByCargo(cargo: CargoEmpleado): Promise<EmpleadoResponseDto[]> {
    const empleados = await this.empleadoRepository.find({
      where: { cargo, activo: true },
      order: { apellidoPaterno: 'ASC' }
    });
    
    return empleados.map(empleado => new EmpleadoResponseDto(empleado));
  }

  async findConductores(): Promise<EmpleadoResponseDto[]> {
    return await this.findByCargo(CargoEmpleado.CONDUCTOR);
  }

  async findMecanicos(): Promise<EmpleadoResponseDto[]> {
    return await this.findByCargo(CargoEmpleado.MECANICO);
  }

  async findActivos(): Promise<EmpleadoResponseDto[]> {
    const empleados = await this.empleadoRepository.find({
      where: { activo: true },
      order: { apellidoPaterno: 'ASC' }
    });
    
    return empleados.map(empleado => new EmpleadoResponseDto(empleado));
  }

  async findInactivos(): Promise<EmpleadoResponseDto[]> {
    const empleados = await this.empleadoRepository.find({
      where: { activo: false },
      order: { apellidoPaterno: 'ASC' }
    });
    
    return empleados.map(empleado => new EmpleadoResponseDto(empleado));
  }

  // ==================== MÉTODOS DE ACCIÓN ====================

  async desactivar(id: number): Promise<EmpleadoResponseDto> {
    const empleado = await this.empleadoRepository.findOneBy({ id });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con ID ${id} no encontrado`);
    }
    
    empleado.activo = false;
    const actualizado = await this.empleadoRepository.save(empleado);
    
    return new EmpleadoResponseDto(actualizado);
  }

  async activar(id: number): Promise<EmpleadoResponseDto> {
    const empleado = await this.empleadoRepository.findOneBy({ id });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con ID ${id} no encontrado`);
    }
    
    empleado.activo = true;
    const actualizado = await this.empleadoRepository.save(empleado);
    
    return new EmpleadoResponseDto(actualizado);
  }

  // ==================== MÉTODOS PRIVADOS (HELPERS) ====================

  /**
   * Valida que el RUT sea único en la base de datos
   * @param rut - RUT a validar
   * @throws ConflictException si el RUT ya existe
   * @private
   */
  private async validarRutUnico(rut: string): Promise<void> {
    const existente = await this.empleadoRepository.findOne({
      where: { rut }
    });
    
    if (existente) {
      throw new ConflictException(`Ya existe un empleado con RUT ${rut}`);
    }
  }
}