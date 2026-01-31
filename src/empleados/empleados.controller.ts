import { 
  Controller, 
  Get, 
  Post, 
  Body, 
  Patch, 
  Param, 
  Delete,
  HttpCode,
  HttpStatus,
  ParseIntPipe
} from '@nestjs/common';
import { EmpleadosService } from './empleados.service';
import { CreateEmpleadoDto } from './dto/create-empleado.dto';
import { UpdateEmpleadoDto } from './dto/update-empleado.dto';
import { EmpleadoResponseDto } from './dto/empleado-response.dto';
import { DeleteEmpleadoResponseDto } from './dto/delete-empleado-response.dto';


@Controller('empleados')
export class EmpleadosController {
  constructor(private readonly empleadosService: EmpleadosService) {}

  @Post()
  @HttpCode(HttpStatus.CREATED)
  create(@Body() createEmpleadoDto: CreateEmpleadoDto): Promise<EmpleadoResponseDto> {
    return this.empleadosService.create(createEmpleadoDto);
  }

  @Get()
  findAll(): Promise<EmpleadoResponseDto[]> {
    return this.empleadosService.findAll();
  }

  @Get('activos')
  findActivos(): Promise<EmpleadoResponseDto[]> {
    return this.empleadosService.findActivos();
  }

  @Get('inactivos')
  findInactivos(): Promise<EmpleadoResponseDto[]> {
    return this.empleadosService.findInactivos();
  }

  @Get('conductores')
  findConductores(): Promise<EmpleadoResponseDto[]> {
    return this.empleadosService.findConductores();
  }

  @Get('mecanicos')
  findMecanicos(): Promise<EmpleadoResponseDto[]> {
    return this.empleadosService.findMecanicos();
  }

  @Get('rut/:rut')
  findByRut(@Param('rut') rut: string): Promise<EmpleadoResponseDto> {
    return this.empleadosService.findByRut(rut);
  }

  @Get(':id')
  findOne(@Param('id', ParseIntPipe) id: number): Promise<EmpleadoResponseDto> {
    return this.empleadosService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateEmpleadoDto: UpdateEmpleadoDto
  ): Promise<EmpleadoResponseDto> {
    return this.empleadosService.update(id, updateEmpleadoDto);
  }

  @Patch(':id/desactivar')
  desactivar(@Param('id', ParseIntPipe) id: number): Promise<EmpleadoResponseDto> {
    return this.empleadosService.desactivar(id);
  }

  @Patch(':id/activar')
  activar(@Param('id', ParseIntPipe) id: number): Promise<EmpleadoResponseDto> {
    return this.empleadosService.activar(id);
  }

  @Delete(':id')
  remove(@Param('id', ParseIntPipe) id: number): Promise<DeleteEmpleadoResponseDto> {
    return this.empleadosService.remove(id);
  }
}