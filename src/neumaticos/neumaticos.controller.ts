import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
  ParseIntPipe,
  HttpCode,
  HttpStatus,
} from '@nestjs/common';
import { NeumaticosService } from './neumaticos.service';
import { CreateNeumaticoDto } from './dto/create-neumatico.dto';
import { UpdateNeumaticoDto } from './dto/update-neumatico.dto';

@Controller('neumaticos')
export class NeumaticosController {
  constructor(private readonly neumaticosService: NeumaticosService) {}

  @Post()
  @HttpCode(HttpStatus.CREATED)
  create(@Body() createNeumaticoDto: CreateNeumaticoDto) {
    return this.neumaticosService.create(createNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.neumaticosService.findAll();
  }

  @Get('activos')
  findActivos() {
    return this.neumaticosService.findActivos();
  }

  @Get('inactivos')
  findInactivos() {
    return this.neumaticosService.findInactivos();
  }

  @Get('bus/:idBus')
  findByBus(@Param('idBus', ParseIntPipe) idBus: number) {
    return this.neumaticosService.findByBus(idBus);
  }

  @Get('estado/:idEstado')
  findByEstado(@Param('idEstado', ParseIntPipe) idEstado: number) {
    return this.neumaticosService.findByEstado(idEstado);
  }

  @Get('marca/:idMarca')
  findByMarca(@Param('idMarca', ParseIntPipe) idMarca: number) {
    return this.neumaticosService.findByMarca(idMarca);
  }

  @Get(':id')
  findOne(@Param('id', ParseIntPipe) id: number) {
    return this.neumaticosService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateNeumaticoDto: UpdateNeumaticoDto,
  ) {
    return this.neumaticosService.update(id, updateNeumaticoDto);
  }

  @Patch(':id/desactivar')
  desactivar(@Param('id', ParseIntPipe) id: number) {
    return this.neumaticosService.desactivar(id);
  }

  @Patch(':id/activar')
  activar(@Param('id', ParseIntPipe) id: number) {
    return this.neumaticosService.activar(id);
  }

  @Delete(':id')
  remove(@Param('id', ParseIntPipe) id: number) {
    return this.neumaticosService.remove(id);
  }
}
