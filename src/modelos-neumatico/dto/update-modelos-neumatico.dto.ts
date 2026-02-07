import { PartialType } from '@nestjs/mapped-types';
import { CreateModelosNeumaticoDto } from './create-modelos-neumatico.dto';

export class UpdateModelosNeumaticoDto extends PartialType(CreateModelosNeumaticoDto) {}
