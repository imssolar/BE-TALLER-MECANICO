import { Module } from '@nestjs/common';
import { ModelosNeumaticoService } from './modelos-neumatico.service';
import { ModelosNeumaticoController } from './modelos-neumatico.controller';

@Module({
  controllers: [ModelosNeumaticoController],
  providers: [ModelosNeumaticoService],
})
export class ModelosNeumaticoModule {}
