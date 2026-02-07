import { Controller, Get, Post, Body, Patch, Param, Delete, ParseIntPipe, HttpCode, HttpStatus } from '@nestjs/common';
import { MarcasNeumaticosService } from './marcas-neumaticos.service';
import { CreateMarcasNeumaticoDto } from './dto/create-marcas-neumatico.dto';
import { UpdateMarcasNeumaticoDto } from './dto/update-marcas-neumatico.dto';

@Controller('marcas-neumaticos')
export class MarcasNeumaticosController {
  constructor(private readonly marcasNeumaticosService: MarcasNeumaticosService) {}

  @Post()
  @HttpCode(HttpStatus.CREATED)
  create(@Body() createMarcasNeumaticoDto: CreateMarcasNeumaticoDto) {
    return this.marcasNeumaticosService.create(createMarcasNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.marcasNeumaticosService.findAll();
  }

  @Get(':id')
  findOne(@Param('id', ParseIntPipe) id: number) {
    return this.marcasNeumaticosService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateMarcasNeumaticoDto: UpdateMarcasNeumaticoDto
  ) {
    return this.marcasNeumaticosService.update(id, updateMarcasNeumaticoDto);
  }

  @Delete(':id')
  remove(@Param('id', ParseIntPipe) id: number) {
    return this.marcasNeumaticosService.remove(id);
  }
}
