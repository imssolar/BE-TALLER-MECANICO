import { Injectable, NotFoundException } from '@nestjs/common';
import { CreateVehiculoDto } from './dto/create-vehiculo.dto';
import { UpdateVehiculoDto } from './dto/update-vehiculo.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { Vehiculo } from './entities/vehiculo.entity';
import { Repository } from 'typeorm';
import { Cliente } from 'src/clientes/entities/cliente.entity';

@Injectable()
export class VehiculosService {

  constructor(
    @InjectRepository(Vehiculo)
    private readonly vehiculoRepository: Repository<Vehiculo>,
    @InjectRepository(Cliente)
    private readonly clienteRepository: Repository<Cliente>
  ) { }

  async create(createVehiculoDto: CreateVehiculoDto) {
    const cliente = await this.clienteRepository.findOneBy({
      id: createVehiculoDto.clienteId
    })
    if (!cliente) {
      throw new NotFoundException(`Cliente con ID ${createVehiculoDto.clienteId} no encontrado`)
    }
    const vehiculo = this.vehiculoRepository.create({
      ...createVehiculoDto,
      cliente: cliente
    })
    return this.vehiculoRepository.save(vehiculo)
  }

  findAll() {
    return this.vehiculoRepository.find({
      relations: ['cliente']
    })
  }

  async findOne(id: number) {
    const vehiculo = await this.vehiculoRepository.findOne({
      where: { id },
      relations: ['cliente']
    })
    if (!vehiculo) {
      throw new NotFoundException(`Vehículo con ID ${id} no encontrado`)
    }
    return vehiculo
  }

  async update(id: number, updateVehiculoDto: UpdateVehiculoDto) {
    const vehiculo = await this.findOne(id)
    Object.assign(vehiculo, updateVehiculoDto)
    return this.vehiculoRepository.save(vehiculo)
  }

  async remove(id: number) {
    const vehiculo = await this.findOne(id)
    return this.vehiculoRepository.remove(vehiculo)
  }
}
