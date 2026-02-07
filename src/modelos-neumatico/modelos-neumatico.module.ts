import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ModelosNeumaticoService } from './modelos-neumatico.service';
import { ModelosNeumaticoController } from './modelos-neumatico.controller';
import { ModelosNeumatico } from './entities/modelos-neumatico.entity';

@Module({
  imports: [TypeOrmModule.forFeature([ModelosNeumatico])],
  controllers: [ModelosNeumaticoController],
  providers: [ModelosNeumaticoService],
  exports: [ModelosNeumaticoService],
})
export class ModelosNeumaticoModule {}
