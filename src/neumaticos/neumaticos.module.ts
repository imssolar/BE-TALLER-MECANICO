import { Module } from '@nestjs/common';
import { NeumaticosService } from './neumaticos.service';
import { NeumaticosController } from './neumaticos.controller';

@Module({
  controllers: [NeumaticosController],
  providers: [NeumaticosService],
})
export class NeumaticosModule {}
