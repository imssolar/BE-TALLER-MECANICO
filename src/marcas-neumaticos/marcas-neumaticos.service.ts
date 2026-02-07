import { Injectable } from '@nestjs/common';
import { CreateMarcasNeumaticoDto } from './dto/create-marcas-neumatico.dto';
import { UpdateMarcasNeumaticoDto } from './dto/update-marcas-neumatico.dto';

@Injectable()
export class MarcasNeumaticosService {
  create(createMarcasNeumaticoDto: CreateMarcasNeumaticoDto) {
    return 'This action adds a new marcasNeumatico';
  }

  findAll() {
    return `This action returns all marcasNeumaticos`;
  }

  findOne(id: number) {
    return `This action returns a #${id} marcasNeumatico`;
  }

  update(id: number, updateMarcasNeumaticoDto: UpdateMarcasNeumaticoDto) {
    return `This action updates a #${id} marcasNeumatico`;
  }

  remove(id: number) {
    return `This action removes a #${id} marcasNeumatico`;
  }
}
