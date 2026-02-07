import { Controller, Get, Post, Body, Patch, Param, Delete, ParseIntPipe, HttpCode, HttpStatus } from '@nestjs/common';
import { EstadosNeumaticoService } from './estados-neumatico.service';
import { CreateEstadosNeumaticoDto } from './dto/create-estados-neumatico.dto';
import { UpdateEstadosNeumaticoDto } from './dto/update-estados-neumatico.dto';

@Controller('estados-neumatico')
export class EstadosNeumaticoController {
  constructor(private readonly estadosNeumaticoService: EstadosNeumaticoService) {}

  @Post()
  @HttpCode(HttpStatus.CREATED)
  create(@Body() createEstadosNeumaticoDto: CreateEstadosNeumaticoDto) {
    return this.estadosNeumaticoService.create(createEstadosNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.estadosNeumaticoService.findAll();
  }

  @Get(':id')
  findOne(@Param('id', ParseIntPipe) id: number) {
    return this.estadosNeumaticoService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateEstadosNeumaticoDto: UpdateEstadosNeumaticoDto
  ) {
    return this.estadosNeumaticoService.update(id, updateEstadosNeumaticoDto);
  }

  @Delete(':id')
  remove(@Param('id', ParseIntPipe) id: number) {
    return this.estadosNeumaticoService.remove(id);
  }
}
