import { Module } from '@nestjs/common';
import { MarcasNeumaticosService } from './marcas-neumaticos.service';
import { MarcasNeumaticosController } from './marcas-neumaticos.controller';

@Module({
  controllers: [MarcasNeumaticosController],
  providers: [MarcasNeumaticosService],
})
export class MarcasNeumaticosModule {}
