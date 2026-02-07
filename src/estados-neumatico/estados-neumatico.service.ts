import { ConflictException, Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { CreateEstadosNeumaticoDto } from './dto/create-estados-neumatico.dto';
import { UpdateEstadosNeumaticoDto } from './dto/update-estados-neumatico.dto';
import { DeleteEstadosNeumaticoResponseDto } from './dto/delete-estados-neumatico-response.dto';
import { EstadosNeumatico } from './entities/estados-neumatico.entity';

@Injectable()
export class EstadosNeumaticoService {
  constructor(
    @InjectRepository(EstadosNeumatico)
    private readonly estadosNeumaticoRepository: Repository<EstadosNeumatico>,
  ) {}

  async create(createEstadosNeumaticoDto: CreateEstadosNeumaticoDto): Promise<EstadosNeumatico> {
    await this.validarEstadoUnico(createEstadosNeumaticoDto.estado);

    const nuevoEstado = this.estadosNeumaticoRepository.create(createEstadosNeumaticoDto);
    return await this.estadosNeumaticoRepository.save(nuevoEstado);
  }

  async findAll(): Promise<EstadosNeumatico[]> {
    return await this.estadosNeumaticoRepository.find({
      order: { id: 'ASC' }
    });
  }

  async findOne(id: number): Promise<EstadosNeumatico> {
    const estado = await this.estadosNeumaticoRepository.findOne({ where: { id } });

    if (!estado) {
      throw new NotFoundException(`Estado con ID ${id} no encontrado`);
    }

    return estado;
  }

  async update(id: number, updateEstadosNeumaticoDto: UpdateEstadosNeumaticoDto): Promise<EstadosNeumatico> {
    const estadoExistente = await this.findOne(id);

    if (updateEstadosNeumaticoDto.estado) {
      await this.validarEstadoUnico(updateEstadosNeumaticoDto.estado, id);
    }

    Object.assign(estadoExistente, updateEstadosNeumaticoDto);
    return await this.estadosNeumaticoRepository.save(estadoExistente);
  }

  async remove(id: number): Promise<DeleteEstadosNeumaticoResponseDto> {
    const estadoExistente = await this.findOne(id);

    // Guardar datos antes de eliminar
    const datosParaResponse = {
      id: estadoExistente.id,
      estado: estadoExistente.estado
    };

    await this.estadosNeumaticoRepository.remove(estadoExistente);

    return new DeleteEstadosNeumaticoResponseDto(
      datosParaResponse.id,
      datosParaResponse.estado
    );
  }

  private async validarEstadoUnico(estado: string, idExcluir?: number): Promise<void> {
    const existente = await this.estadosNeumaticoRepository.findOne({
      where: { estado },
    });

    if (existente && existente.id !== idExcluir) {
      throw new ConflictException(`El estado "${estado}" ya existe`);
    }
  }
}
