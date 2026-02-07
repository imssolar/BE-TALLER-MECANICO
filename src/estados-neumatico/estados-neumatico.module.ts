import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { EstadosNeumaticoService } from './estados-neumatico.service';
import { EstadosNeumaticoController } from './estados-neumatico.controller';
import { EstadosNeumatico } from './entities/estados-neumatico.entity';

@Module({
  imports: [TypeOrmModule.forFeature([EstadosNeumatico])],
  controllers: [EstadosNeumaticoController],
  providers: [EstadosNeumaticoService],
  exports: [EstadosNeumaticoService],
})
export class EstadosNeumaticoModule {}
