import { PartialType } from '@nestjs/mapped-types';
import { CreateMarcasNeumaticoDto } from './create-marcas-neumatico.dto';

export class UpdateMarcasNeumaticoDto extends PartialType(CreateMarcasNeumaticoDto) {}
