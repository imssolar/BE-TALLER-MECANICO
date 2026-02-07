import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { NeumaticosService } from './neumaticos.service';
import { CreateNeumaticoDto } from './dto/create-neumatico.dto';
import { UpdateNeumaticoDto } from './dto/update-neumatico.dto';

@Controller('neumaticos')
export class NeumaticosController {
  constructor(private readonly neumaticosService: NeumaticosService) {}

  @Post()
  create(@Body() createNeumaticoDto: CreateNeumaticoDto) {
    return this.neumaticosService.create(createNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.neumaticosService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.neumaticosService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateNeumaticoDto: UpdateNeumaticoDto) {
    return this.neumaticosService.update(+id, updateNeumaticoDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.neumaticosService.remove(+id);
  }
}
