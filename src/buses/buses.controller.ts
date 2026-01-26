import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
  ParseIntPipe,
} from '@nestjs/common';
import { BusesService } from './buses.service';
import { CreateBusDto } from './dto/create-bus.dto';
import { UpdateBusDto } from './dto/update-bus.dto';
import { UpdateEstadoDto } from './dto/update-estado.dto';
import { UpdateKilometrajeDto } from './dto/update-kilometraje.dto';
import { RegistrarEmergenciaDto } from './dto/registrar-emergencia.dto';

@Controller('buses')
export class BusesController {
  constructor(private readonly busesService: BusesService) {}

  @Post()
  create(@Body() createBusDto: CreateBusDto) {
    return this.busesService.create(createBusDto);
  }

  @Get()
  findAll() {
    return this.busesService.findAll();
  }

  @Get('estadisticas')
  getEstadisticas() {
    return this.busesService.getEstadisticas();
  }

  @Get('operativos')
  findOperativos() {
    return this.busesService.findOperativos();
  }

  @Get('inactivos')
  findInactivos() {
    return this.busesService.findInactivos();
  }

  @Get('en-mantencion')
  findEnMantencion() {
    return this.busesService.findEnMantencion();
  }

  @Get('terminal/:id')
  findByTerminal(@Param('id', ParseIntPipe) id: number) {
    return this.busesService.findByTerminal(id);
  }

  @Get('modelo/:id')
  findByModelo(@Param('id', ParseIntPipe) id: number) {
    return this.busesService.findByModelo(id);
  }

  @Get('patente/:patente')
  findByPatente(@Param('patente') patente: string) {
    return this.busesService.findByPatente(patente);
  }

  @Get(':id')
  findOne(@Param('id', ParseIntPipe) id: number) {
    return this.busesService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateBusDto: UpdateBusDto,
  ) {
    return this.busesService.update(id, updateBusDto);
  }

  @Patch(':id/estado')
  updateEstado(
    @Param('id', ParseIntPipe) id: number,
    @Body() dto: UpdateEstadoDto,
  ) {
    return this.busesService.updateEstado(id, dto);
  }

  @Patch(':id/kilometraje')
  updateKilometraje(
    @Param('id', ParseIntPipe) id: number,
    @Body() dto: UpdateKilometrajeDto,
  ) {
    return this.busesService.updateKilometraje(id, dto);
  }

  @Patch(':id/emergencia')
  registrarEmergencia(
    @Param('id', ParseIntPipe) id: number,
    @Body() dto: RegistrarEmergenciaDto,
  ) {
    return this.busesService.registrarEmergencia(id, dto);
  }

  @Delete(':id')
  remove(@Param('id', ParseIntPipe) id: number) {
    return this.busesService.remove(id);
  }
}
