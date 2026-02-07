import { Module } from '@nestjs/common';
import { EstadosNeumaticoService } from './estados-neumatico.service';
import { EstadosNeumaticoController } from './estados-neumatico.controller';

@Module({
  controllers: [EstadosNeumaticoController],
  providers: [EstadosNeumaticoService],
})
export class EstadosNeumaticoModule {}
