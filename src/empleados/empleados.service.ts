import { ConflictException, Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Empleado } from './entities/empleado.entity';
import { CreateEmpleadoDto } from './dto/create-empleado.dto';
import { UpdateEmpleadoDto } from './dto/update-empleado.dto';
import { CargoEmpleado } from './enums/cargo-empleado.enum';

@Injectable()
export class EmpleadosService {
  constructor(
    @InjectRepository(Empleado)
    private readonly empleadoRepository: Repository<Empleado>,
  ) { }

  // ==================== MÉTODOS PÚBLICOS (CRUD) ====================

  async create(createEmpleadoDto: CreateEmpleadoDto): Promise<Empleado> {
    await this.validarRutUnico(createEmpleadoDto.rut);
    
    const empleado = this.empleadoRepository.create(createEmpleadoDto);
    return await this.empleadoRepository.save(empleado);
  }

  async findAll(): Promise<Empleado[]> {
    return await this.empleadoRepository.find({
      order: { id: 'ASC' }
    });
  }

  async findOne(id: number): Promise<Empleado> {
    const empleado = await this.empleadoRepository.findOne({
      where: { id },
    });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con ID ${id} no encontrado`);
    }
    
    return empleado;
  }

  async findByRut(rut: string): Promise<Empleado> {
    const empleado = await this.empleadoRepository.findOne({
      where: { rut },
    });
    
    if (!empleado) {
      throw new NotFoundException(`Empleado con RUT ${rut} no encontrado`);
    }
    
    return empleado;
  }

  async update(id: number, updateEmpleadoDto: UpdateEmpleadoDto): Promise<Empleado> {
    const empleado = await this.findOne(id);
    
    if (updateEmpleadoDto.rut && updateEmpleadoDto.rut !== empleado.rut) {
      await this.validarRutUnico(updateEmpleadoDto.rut);
    }
    
    Object.assign(empleado, updateEmpleadoDto);
    return await this.empleadoRepository.save(empleado);
  }

  async remove(id: number): Promise<void> {
    const empleado = await this.findOne(id);
    await this.empleadoRepository.remove(empleado);
  }

  // ==================== MÉTODOS DE BÚSQUEDA ESPECÍFICOS ====================

  async findByCargo(cargo: CargoEmpleado): Promise<Empleado[]> {
    return await this.empleadoRepository.find({
      where: { cargo, activo: true },
      order: { apellidoPaterno: 'ASC' }
    });
  }

  async findConductores(): Promise<Empleado[]> {
    return await this.findByCargo(CargoEmpleado.CONDUCTOR);
  }

  async findMecanicos(): Promise<Empleado[]> {
    return await this.findByCargo(CargoEmpleado.MECANICO);
  }

  async findActivos(): Promise<Empleado[]> {
    return await this.empleadoRepository.find({
      where: { activo: true },
      order: { apellidoPaterno: 'ASC' }
    });
  }

  async findInactivos(): Promise<Empleado[]> {
    return await this.empleadoRepository.find({
      where: { activo: false },
      order: { apellidoPaterno: 'ASC' }
    });
  }

  // ==================== MÉTODOS DE ACCIÓN ====================

  async desactivar(id: number): Promise<Empleado> {
    const empleado = await this.findOne(id);
    empleado.activo = false;
    return await this.empleadoRepository.save(empleado);
  }

  async activar(id: number): Promise<Empleado> {
    const empleado = await this.findOne(id);
    empleado.activo = true;
    return await this.empleadoRepository.save(empleado);
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