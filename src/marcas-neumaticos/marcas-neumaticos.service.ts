import { ConflictException, Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { CreateMarcasNeumaticoDto } from './dto/create-marcas-neumatico.dto';
import { UpdateMarcasNeumaticoDto } from './dto/update-marcas-neumatico.dto';
import { DeleteMarcasNeumaticoResponseDto } from './dto/delete-marcas-neumatico-response.dto';
import { MarcasNeumatico } from './entities/marcas-neumatico.entity';

@Injectable()
export class MarcasNeumaticosService {
  constructor(
    @InjectRepository(MarcasNeumatico)
    private readonly marcasNeumaticoRepository: Repository<MarcasNeumatico>,
  ) {}

  async create(createMarcasNeumaticoDto: CreateMarcasNeumaticoDto): Promise<MarcasNeumatico> {
    await this.validarMarcaUnica(createMarcasNeumaticoDto.marca);

    const nuevaMarca = this.marcasNeumaticoRepository.create(createMarcasNeumaticoDto);
    return await this.marcasNeumaticoRepository.save(nuevaMarca);
  }

  async findAll(): Promise<MarcasNeumatico[]> {
    return await this.marcasNeumaticoRepository.find({
      order: { id: 'ASC' }
    });
  }

  async findOne(id: number): Promise<MarcasNeumatico> {
    const marca = await this.marcasNeumaticoRepository.findOne({ where: { id } });

    if (!marca) {
      throw new NotFoundException(`Marca con ID ${id} no encontrada`);
    }

    return marca;
  }

  async update(id: number, updateMarcasNeumaticoDto: UpdateMarcasNeumaticoDto): Promise<MarcasNeumatico> {
    const marcaExistente = await this.findOne(id);

    if (updateMarcasNeumaticoDto.marca) {
      await this.validarMarcaUnica(updateMarcasNeumaticoDto.marca, id);
    }

    Object.assign(marcaExistente, updateMarcasNeumaticoDto);
    return await this.marcasNeumaticoRepository.save(marcaExistente);
  }

  async remove(id: number): Promise<DeleteMarcasNeumaticoResponseDto> {
    const marcaExistente = await this.findOne(id);

    // Guardar datos antes de eliminar
    const datosParaResponse = {
      id: marcaExistente.id,
      marca: marcaExistente.marca
    };

    await this.marcasNeumaticoRepository.remove(marcaExistente);

    return new DeleteMarcasNeumaticoResponseDto(
      datosParaResponse.id,
      datosParaResponse.marca
    );
  }

  private async validarMarcaUnica(marca: string, idExcluir?: number): Promise<void> {
    const existente = await this.marcasNeumaticoRepository.findOne({
      where: { marca },
    });

    if (existente && existente.id !== idExcluir) {
      throw new ConflictException(`La marca "${marca}" ya existe`);
    }
  }
}
