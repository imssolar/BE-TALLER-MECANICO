import { PartialType } from '@nestjs/mapped-types';
import { CreateEstadosNeumaticoDto } from './create-estados-neumatico.dto';

export class UpdateEstadosNeumaticoDto extends PartialType(CreateEstadosNeumaticoDto) {}
