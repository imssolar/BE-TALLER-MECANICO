import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { NeumaticosService } from './neumaticos.service';
import { NeumaticosController } from './neumaticos.controller';
import { Neumatico } from './entities/neumatico.entity';
import { BusesModule } from '../buses/buses.module';
import { EstadosNeumaticoModule } from '../estados-neumatico/estados-neumatico.module';
import { MarcasNeumaticosModule } from '../marcas-neumaticos/marcas-neumaticos.module';
import { ModelosNeumaticoModule } from '../modelos-neumatico/modelos-neumatico.module';

@Module({
  imports: [
    TypeOrmModule.forFeature([Neumatico]),
    BusesModule,
    EstadosNeumaticoModule,
    MarcasNeumaticosModule,
    ModelosNeumaticoModule,
  ],
  controllers: [NeumaticosController],
  providers: [NeumaticosService],
  exports: [NeumaticosService],
})
export class NeumaticosModule {}
