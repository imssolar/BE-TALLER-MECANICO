import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { CreateOrdenDto } from './dto/create-orden.dto';
import { UpdateOrdenDto } from './dto/update-orden.dto';
import { Orden } from './entities/orden.entity';
import { Vehiculo } from '../vehiculos/entities/vehiculo.entity';

@Injectable()
export class OrdenesService {
  constructor(
    @InjectRepository(Orden)
    private readonly ordenRepository: Repository<Orden>,
    @InjectRepository(Vehiculo)
    private readonly vehiculoRepository: Repository<Vehiculo>,
  ) {}

  async create(createOrdenDto: CreateOrdenDto) {
    // Buscar el vehículo
    const vehiculo = await this.vehiculoRepository.findOneBy({
      id: createOrdenDto.vehiculoId,
    });

    if (!vehiculo) {
      throw new NotFoundException(
        `Vehículo con ID ${createOrdenDto.vehiculoId} no encontrado`,
      );
    }

    // Crear la orden con la relación
    const orden = this.ordenRepository.create({
      ...createOrdenDto,
      vehiculo: vehiculo,
    });

    return this.ordenRepository.save(orden);
  }

  findAll() {
    return this.ordenRepository.find({
      relations: ['vehiculo', 'vehiculo.cliente'],
    });
  }

  async findOne(id: number) {
    const orden = await this.ordenRepository.findOne({
      where: { id },
      relations: ['vehiculo', 'vehiculo.cliente'],
    });

    if (!orden) {
      throw new NotFoundException(`Orden con ID ${id} no encontrada`);
    }
    return orden;
  }

  async update(id: number, updateOrdenDto: UpdateOrdenDto) {
    const orden = await this.findOne(id);
    Object.assign(orden, updateOrdenDto);
    return this.ordenRepository.save(orden);
  }

  async remove(id: number) {
    const orden = await this.findOne(id);
    return this.ordenRepository.remove(orden);
  }
}
