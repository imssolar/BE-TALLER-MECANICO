import { Injectable } from '@nestjs/common';
import { CreateModelosNeumaticoDto } from './dto/create-modelos-neumatico.dto';
import { UpdateModelosNeumaticoDto } from './dto/update-modelos-neumatico.dto';

@Injectable()
export class ModelosNeumaticoService {
  create(createModelosNeumaticoDto: CreateModelosNeumaticoDto) {
    return 'This action adds a new modelosNeumatico';
  }

  findAll() {
    return `This action returns all modelosNeumatico`;
  }

  findOne(id: number) {
    return `This action returns a #${id} modelosNeumatico`;
  }

  update(id: number, updateModelosNeumaticoDto: UpdateModelosNeumaticoDto) {
    return `This action updates a #${id} modelosNeumatico`;
  }

  remove(id: number) {
    return `This action removes a #${id} modelosNeumatico`;
  }
}
