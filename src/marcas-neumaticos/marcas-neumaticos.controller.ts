import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { MarcasNeumaticosService } from './marcas-neumaticos.service';
import { CreateMarcasNeumaticoDto } from './dto/create-marcas-neumatico.dto';
import { UpdateMarcasNeumaticoDto } from './dto/update-marcas-neumatico.dto';

@Controller('marcas-neumaticos')
export class MarcasNeumaticosController {
  constructor(private readonly marcasNeumaticosService: MarcasNeumaticosService) {}

  @Post()
  create(@Body() createMarcasNeumaticoDto: CreateMarcasNeumaticoDto) {
    return this.marcasNeumaticosService.create(createMarcasNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.marcasNeumaticosService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.marcasNeumaticosService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateMarcasNeumaticoDto: UpdateMarcasNeumaticoDto) {
    return this.marcasNeumaticosService.update(+id, updateMarcasNeumaticoDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.marcasNeumaticosService.remove(+id);
  }
}
