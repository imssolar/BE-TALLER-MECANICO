import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ModelosNeumaticoService } from './modelos-neumatico.service';
import { CreateModelosNeumaticoDto } from './dto/create-modelos-neumatico.dto';
import { UpdateModelosNeumaticoDto } from './dto/update-modelos-neumatico.dto';

@Controller('modelos-neumatico')
export class ModelosNeumaticoController {
  constructor(private readonly modelosNeumaticoService: ModelosNeumaticoService) {}

  @Post()
  create(@Body() createModelosNeumaticoDto: CreateModelosNeumaticoDto) {
    return this.modelosNeumaticoService.create(createModelosNeumaticoDto);
  }

  @Get()
  findAll() {
    return this.modelosNeumaticoService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.modelosNeumaticoService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateModelosNeumaticoDto: UpdateModelosNeumaticoDto) {
    return this.modelosNeumaticoService.update(+id, updateModelosNeumaticoDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.modelosNeumaticoService.remove(+id);
  }
}
