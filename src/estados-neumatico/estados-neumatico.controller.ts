import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { EstadosNeumaticoService } from './estados-neumatico.service';
import { CreateEstadosNeumaticoDto } from './dto/create-estados-neumatico.dto';
import { UpdateEstadosNeumaticoDto } from './dto/update-estados-neumatico.dto';

@Controller('estados-neumatico')
export class EstadosNeumaticoController {
  constructor(private readonly estadosNeumaticoService: EstadosNeumaticoService) {}

  @Post()
  create(@Body() createEstadosNeumaticoDto: CreateEstadosNeumaticoDto) {
    return this.estadosNeumaticoService.create(createEstadosNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.estadosNeumaticoService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.estadosNeumaticoService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateEstadosNeumaticoDto: UpdateEstadosNeumaticoDto) {
    return this.estadosNeumaticoService.update(+id, updateEstadosNeumaticoDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.estadosNeumaticoService.remove(+id);
  }
}
