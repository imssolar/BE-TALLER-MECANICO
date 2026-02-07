import { Injectable } from '@nestjs/common';
import { CreateEstadosNeumaticoDto } from './dto/create-estados-neumatico.dto';
import { UpdateEstadosNeumaticoDto } from './dto/update-estados-neumatico.dto';

@Injectable()
export class EstadosNeumaticoService {
  create(createEstadosNeumaticoDto: CreateEstadosNeumaticoDto) {
    return 'This action adds a new estadosNeumatico';
  }

  findAll() {
    return `This action returns all estadosNeumatico`;
  }

  findOne(id: number) {
    return `This action returns a #${id} estadosNeumatico`;
  }

  update(id: number, updateEstadosNeumaticoDto: UpdateEstadosNeumaticoDto) {
    return `This action updates a #${id} estadosNeumatico`;
  }

  remove(id: number) {
    return `This action removes a #${id} estadosNeumatico`;
  }
}
