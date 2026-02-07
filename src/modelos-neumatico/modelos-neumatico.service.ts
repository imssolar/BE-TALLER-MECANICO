import { ConflictException, Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { CreateModelosNeumaticoDto } from './dto/create-modelos-neumatico.dto';
import { UpdateModelosNeumaticoDto } from './dto/update-modelos-neumatico.dto';
import { DeleteModelosNeumaticoResponseDto } from './dto/delete-modelos-neumatico-response.dto';
import { ModelosNeumatico } from './entities/modelos-neumatico.entity';

@Injectable()
export class ModelosNeumaticoService {
  constructor(
    @InjectRepository(ModelosNeumatico)
    private readonly modelosNeumaticoRepository: Repository<ModelosNeumatico>,
  ) {}

  async create(createModelosNeumaticoDto: CreateModelosNeumaticoDto): Promise<ModelosNeumatico> {
    await this.validarModeloUnico(createModelosNeumaticoDto.modelo);

    const nuevoModelo = this.modelosNeumaticoRepository.create(createModelosNeumaticoDto);
    return await this.modelosNeumaticoRepository.save(nuevoModelo);
  }

  async findAll(): Promise<ModelosNeumatico[]> {
    return await this.modelosNeumaticoRepository.find({
      order: { id: 'ASC' }
    });
  }

  async findOne(id: number): Promise<ModelosNeumatico> {
    const modelo = await this.modelosNeumaticoRepository.findOne({ where: { id } });

    if (!modelo) {
      throw new NotFoundException(`Modelo con ID ${id} no encontrado`);
    }

    return modelo;
  }

  async update(id: number, updateModelosNeumaticoDto: UpdateModelosNeumaticoDto): Promise<ModelosNeumatico> {
    const modeloExistente = await this.findOne(id);

    if (updateModelosNeumaticoDto.modelo) {
      await this.validarModeloUnico(updateModelosNeumaticoDto.modelo, id);
    }

    Object.assign(modeloExistente, updateModelosNeumaticoDto);
    return await this.modelosNeumaticoRepository.save(modeloExistente);
  }

  async remove(id: number): Promise<DeleteModelosNeumaticoResponseDto> {
    const modeloExistente = await this.findOne(id);

    // Guardar datos antes de eliminar
    const datosParaResponse = {
      id: modeloExistente.id,
      modelo: modeloExistente.modelo
    };

    await this.modelosNeumaticoRepository.remove(modeloExistente);

    return new DeleteModelosNeumaticoResponseDto(
      datosParaResponse.id,
      datosParaResponse.modelo
    );
  }

  private async validarModeloUnico(modelo: string, idExcluir?: number): Promise<void> {
    const existente = await this.modelosNeumaticoRepository.findOne({
      where: { modelo },
    });

    if (existente && existente.id !== idExcluir) {
      throw new ConflictException(`El modelo "${modelo}" ya existe`);
    }
  }
}
