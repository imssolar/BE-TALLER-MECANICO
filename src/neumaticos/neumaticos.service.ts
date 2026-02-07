import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Neumatico } from './entities/neumatico.entity';
import { CreateNeumaticoDto } from './dto/create-neumatico.dto';
import { UpdateNeumaticoDto } from './dto/update-neumatico.dto';
import { DeleteNeumaticoResponseDto } from './dto/delete-neumatico-response.dto';
import { BusesService } from '../buses/buses.service';
import { EstadosNeumaticoService } from '../estados-neumatico/estados-neumatico.service';
import { MarcasNeumaticosService } from '../marcas-neumaticos/marcas-neumaticos.service';
import { ModelosNeumaticoService } from '../modelos-neumatico/modelos-neumatico.service';

@Injectable()
export class NeumaticosService {
  constructor(
    @InjectRepository(Neumatico)
    private readonly neumaticoRepository: Repository<Neumatico>,
    private readonly busesService: BusesService,
    private readonly estadosNeumaticoService: EstadosNeumaticoService,
    private readonly marcasNeumaticosService: MarcasNeumaticosService,
    private readonly modelosNeumaticoService: ModelosNeumaticoService,
  ) {}

  async create(createNeumaticoDto: CreateNeumaticoDto): Promise<Neumatico> {
    const bus = await this.busesService.findOne(createNeumaticoDto.idBus);
    const estado = await this.estadosNeumaticoService.findOne(createNeumaticoDto.idEstado);
    const marca = await this.marcasNeumaticosService.findOne(createNeumaticoDto.idMarca);
    const modelo = await this.modelosNeumaticoService.findOne(createNeumaticoDto.idModelo);

    const nuevoNeumatico = this.neumaticoRepository.create({
      ...createNeumaticoDto,
      bus,
      estado,
      marca,
      modelo,
    });

    return await this.neumaticoRepository.save(nuevoNeumatico);
  }

  async findAll(): Promise<Neumatico[]> {
    return await this.neumaticoRepository.find({
      relations: ['bus', 'estado', 'marca', 'modelo'],
      order: { id: 'ASC' }
    });
  }

  async findOne(id: number): Promise<Neumatico> {
    const neumatico = await this.neumaticoRepository.findOne({
      where: { id },
      relations: ['bus', 'estado', 'marca', 'modelo'],
    });

    if (!neumatico) {
      throw new NotFoundException(`Neumático con ID ${id} no encontrado`);
    }

    return neumatico;
  }

  async update(id: number, updateNeumaticoDto: UpdateNeumaticoDto): Promise<Neumatico> {
    const neumaticoExistente = await this.findOne(id);

    if (updateNeumaticoDto.idBus) {
      neumaticoExistente.bus = await this.busesService.findOne(updateNeumaticoDto.idBus);
    }

    if (updateNeumaticoDto.idEstado) {
      neumaticoExistente.estado = await this.estadosNeumaticoService.findOne(updateNeumaticoDto.idEstado);
    }

    if (updateNeumaticoDto.idMarca) {
      neumaticoExistente.marca = await this.marcasNeumaticosService.findOne(updateNeumaticoDto.idMarca);
    }

    if (updateNeumaticoDto.idModelo) {
      neumaticoExistente.modelo = await this.modelosNeumaticoService.findOne(updateNeumaticoDto.idModelo);
    }

    Object.assign(neumaticoExistente, updateNeumaticoDto);
    return await this.neumaticoRepository.save(neumaticoExistente);
  }

  async remove(id: number): Promise<DeleteNeumaticoResponseDto> {
    const neumaticoExistente = await this.findOne(id);

    const datosParaResponse = {
      id: neumaticoExistente.id,
      idBus: neumaticoExistente.bus.idBus,
      posicion: neumaticoExistente.posicion
    };

    await this.neumaticoRepository.remove(neumaticoExistente);

    return new DeleteNeumaticoResponseDto(
      datosParaResponse.id,
      datosParaResponse.idBus,
      datosParaResponse.posicion
    );
  }

  async findByBus(idBus: number): Promise<Neumatico[]> {
    return await this.neumaticoRepository.find({
      where: { bus: { idBus } },
      relations: ['bus', 'estado', 'marca', 'modelo'],
      order: { posicion: 'ASC' }
    });
  }

  async findActivos(): Promise<Neumatico[]> {
    return await this.neumaticoRepository.find({
      where: { activo: true },
      relations: ['bus', 'estado', 'marca', 'modelo'],
      order: { id: 'ASC' }
    });
  }

  async findInactivos(): Promise<Neumatico[]> {
    return await this.neumaticoRepository.find({
      where: { activo: false },
      relations: ['bus', 'estado', 'marca', 'modelo'],
      order: { id: 'ASC' }
    });
  }

  async findByEstado(idEstado: number): Promise<Neumatico[]> {
    return await this.neumaticoRepository.find({
      where: { estado: { id: idEstado } },
      relations: ['bus', 'estado', 'marca', 'modelo'],
      order: { id: 'ASC' }
    });
  }

  async findByMarca(idMarca: number): Promise<Neumatico[]> {
    return await this.neumaticoRepository.find({
      where: { marca: { id: idMarca } },
      relations: ['bus', 'estado', 'marca', 'modelo'],
      order: { id: 'ASC' }
    });
  }

  async desactivar(id: number): Promise<Neumatico> {
    const neumaticoExistente = await this.findOne(id);
    neumaticoExistente.activo = false;
    return await this.neumaticoRepository.save(neumaticoExistente);
  }

  async activar(id: number): Promise<Neumatico> {
    const neumaticoExistente = await this.findOne(id);
    neumaticoExistente.activo = true;
    return await this.neumaticoRepository.save(neumaticoExistente);
  }
}
