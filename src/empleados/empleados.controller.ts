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
import { EmpleadosService } from './empleados.service';
import { CreateEmpleadoDto } from './dto/create-empleado.dto';
import { UpdateEmpleadoDto } from './dto/update-empleado.dto';

@Controller('empleados')
export class EmpleadosController {
  constructor(private readonly empleadosService: EmpleadosService) {}

  @Post()
  @HttpCode(HttpStatus.CREATED)
  create(@Body() createEmpleadoDto: CreateEmpleadoDto) {
    return this.empleadosService.create(createEmpleadoDto);
  }

  @Get()
  findAll() {
    return this.empleadosService.findAll();
  }

  // ========== RUTAS ESPECÍFICAS (ANTES DE :id) ==========
  
  @Get('activos')
  findActivos() {
    return this.empleadosService.findActivos();
  }

  @Get('inactivos')
  findInactivos() {
    return this.empleadosService.findInactivos();
  }

  @Get('conductores')
  findConductores() {
    return this.empleadosService.findConductores();
  }

  @Get('mecanicos')
  findMecanicos() {
    return this.empleadosService.findMecanicos();
  }

  @Get('rut/:rut')
  findByRut(@Param('rut') rut: string) {
    return this.empleadosService.findByRut(rut);
  }

  // ========== RUTAS CON :id (AL FINAL) ==========

  @Get(':id')
  findOne(@Param('id', ParseIntPipe) id: number) {
    return this.empleadosService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateEmpleadoDto: UpdateEmpleadoDto,
  ) {
    return this.empleadosService.update(id, updateEmpleadoDto);
  }

  @Patch(':id/activar')
  @HttpCode(HttpStatus.OK)
  activar(@Param('id', ParseIntPipe) id: number) {
    return this.empleadosService.activar(id);
  }

  @Patch(':id/desactivar')
  @HttpCode(HttpStatus.OK)
  desactivar(@Param('id', ParseIntPipe) id: number) {
    return this.empleadosService.desactivar(id);
  }

  @Delete(':id')
  @HttpCode(HttpStatus.NO_CONTENT)
  remove(@Param('id', ParseIntPipe) id: number) {
    return this.empleadosService.remove(id);
  }
}