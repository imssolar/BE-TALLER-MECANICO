import { Injectable } from '@nestjs/common';
import { CreateNeumaticoDto } from './dto/create-neumatico.dto';
import { UpdateNeumaticoDto } from './dto/update-neumatico.dto';

@Injectable()
export class NeumaticosService {
  create(createNeumaticoDto: CreateNeumaticoDto) {
    return 'This action adds a new neumatico';
  }

  findAll() {
    return `This action returns all neumaticos`;
  }

  findOne(id: number) {
    return `This action returns a #${id} neumatico`;
  }

  update(id: number, updateNeumaticoDto: UpdateNeumaticoDto) {
    return `This action updates a #${id} neumatico`;
  }

  remove(id: number) {
    return `This action removes a #${id} neumatico`;
  }
}
