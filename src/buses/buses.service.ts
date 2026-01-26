import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Bus } from './entities/bus.entity';
import { CreateBusDto } from './dto/create-bus.dto';
import { UpdateBusDto } from './dto/update-bus.dto';
import { UpdateEstadoDto } from './dto/update-estado.dto';
import { UpdateKilometrajeDto } from './dto/update-kilometraje.dto';
import { RegistrarEmergenciaDto } from './dto/registrar-emergencia.dto';
import { TerminalService } from '../terminal/terminal.service';
import { ModelosService } from '../modelos/modelos.service';

@Injectable()
export class BusesService {
  constructor(
    @InjectRepository(Bus)
    private readonly busRepository: Repository<Bus>,
    private readonly terminalService: TerminalService,
    private readonly modelosService: ModelosService,
  ) {}

  async create(createBusDto: CreateBusDto): Promise<Bus> {
    const terminal = await this.terminalService.findOne(createBusDto.idTerminal);
    const modelo = await this.modelosService.findOne(createBusDto.idModelo);

    const bus = this.busRepository.create({
      ...createBusDto,
      terminal,
      modelo,
    });

    return await this.busRepository.save(bus);
  }

  async findAll(): Promise<Bus[]> {
    return await this.busRepository.find({
      relations: ['terminal', 'modelo'],
    });
  }

  async findOne(id: number): Promise<Bus> {
    const bus = await this.busRepository.findOne({
      where: { idBus: id },
      relations: ['terminal', 'modelo'],
    });
    if (!bus) {
      throw new NotFoundException(`Bus con ID ${id} no encontrado`);
    }
    return bus;
  }

  async update(id: number, updateBusDto: UpdateBusDto): Promise<Bus> {
    const bus = await this.findOne(id);

    if (updateBusDto.idTerminal) {
      bus.terminal = await this.terminalService.findOne(updateBusDto.idTerminal);
    }

    if (updateBusDto.idModelo) {
      bus.modelo = await this.modelosService.findOne(updateBusDto.idModelo);
    }

    Object.assign(bus, updateBusDto);
    return await this.busRepository.save(bus);
  }

  async remove(id: number): Promise<void> {
    const bus = await this.findOne(id);
    await this.busRepository.remove(bus);
  }

  async findOperativos(): Promise<Bus[]> {
    return await this.busRepository.find({
      where: { operativaB: true, activoB: true },
      relations: ['terminal', 'modelo'],
    });
  }

  async findInactivos(): Promise<Bus[]> {
    return await this.busRepository.find({
      where: { activoB: false },
      relations: ['terminal', 'modelo'],
    });
  }

  async findEnMantencion(): Promise<Bus[]> {
    return await this.busRepository.find({
      where: { mantencionB: true },
      relations: ['terminal', 'modelo'],
    });
  }

  async findByTerminal(idTerminal: number): Promise<Bus[]> {
    await this.terminalService.findOne(idTerminal);

    return await this.busRepository.find({
      where: { terminal: { idTerminal } },
      relations: ['terminal', 'modelo'],
    });
  }

  async findByModelo(idModelo: number): Promise<Bus[]> {
    await this.modelosService.findOne(idModelo);

    return await this.busRepository.find({
      where: { modelo: { idModelo } },
      relations: ['terminal', 'modelo'],
    });
  }

  async findByPatente(patente: string): Promise<Bus> {
    const bus = await this.busRepository.findOne({
      where: { patenteB: patente },
      relations: ['terminal', 'modelo'],
    });
    if (!bus) {
      throw new NotFoundException(`Bus con patente ${patente} no encontrado`);
    }
    return bus;
  }

  async updateEstado(id: number, dto: UpdateEstadoDto): Promise<Bus> {
    const bus = await this.findOne(id);
    bus.operativaB = dto.operativaB;
    return await this.busRepository.save(bus);
  }

  async updateKilometraje(id: number, dto: UpdateKilometrajeDto): Promise<Bus> {
    const bus = await this.findOne(id);
    bus.kmB = dto.kmB;
    return await this.busRepository.save(bus);
  }

  async registrarEmergencia(id: number, dto: RegistrarEmergenciaDto): Promise<Bus> {
    const bus = await this.findOne(id);
    bus.fechaEmergencia = new Date(dto.fechaEmergencia);
    bus.obsEmergenciaB = dto.obsEmergenciaB || null;
    return await this.busRepository.save(bus);
  }

  async getEstadisticas(): Promise<{
    total: number;
    operativos: number;
    inactivos: number;
    enMantencion: number;
    porTerminal: { terminal: string; cantidad: number }[];
  }> {
    const total = await this.busRepository.count();
    const operativos = await this.busRepository.count({
      where: { operativaB: true, activoB: true },
    });
    const inactivos = await this.busRepository.count({
      where: { activoB: false },
    });
    const enMantencion = await this.busRepository.count({
      where: { mantencionB: true },
    });

    const porTerminal = await this.busRepository
      .createQueryBuilder('bus')
      .leftJoin('bus.terminal', 'terminal')
      .select('terminal.terminal', 'terminal')
      .addSelect('COUNT(bus.idBus)', 'cantidad')
      .groupBy('terminal.terminal')
      .getRawMany();

    return {
      total,
      operativos,
      inactivos,
      enMantencion,
      porTerminal,
    };
  }
}
