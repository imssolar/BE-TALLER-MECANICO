import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Modelo } from './entities/modelo.entity';
import { CreateModeloDto } from './dto/create-modelo.dto';
import { UpdateModeloDto } from './dto/update-modelo.dto';

@Injectable()
export class ModelosService {
  constructor(
    @InjectRepository(Modelo)
    private readonly modeloRepository: Repository<Modelo>,
  ) {}

  async create(createModeloDto: CreateModeloDto): Promise<Modelo> {
    const modelo = this.modeloRepository.create(createModeloDto);
    return await this.modeloRepository.save(modelo);
  }

  async findAll(): Promise<Modelo[]> {
    return await this.modeloRepository.find();
  }

  async findOne(id: number): Promise<Modelo> {
    const modelo = await this.modeloRepository.findOne({
      where: { idModelo: id },
    });
    if (!modelo) {
      throw new NotFoundException(`Modelo con ID ${id} no encontrado`);
    }
    return modelo;
  }

  async update(id: number, updateModeloDto: UpdateModeloDto): Promise<Modelo> {
    const modelo = await this.findOne(id);
    Object.assign(modelo, updateModeloDto);
    return await this.modeloRepository.save(modelo);
  }

  async remove(id: number): Promise<void> {
    const modelo = await this.findOne(id);
    await this.modeloRepository.remove(modelo);
  }
}
