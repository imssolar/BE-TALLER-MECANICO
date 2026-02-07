import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { MarcasNeumaticosService } from './marcas-neumaticos.service';
import { MarcasNeumaticosController } from './marcas-neumaticos.controller';
import { MarcasNeumatico } from './entities/marcas-neumatico.entity';

@Module({
  imports: [TypeOrmModule.forFeature([MarcasNeumatico])],
  controllers: [MarcasNeumaticosController],
  providers: [MarcasNeumaticosService],
  exports: [MarcasNeumaticosService],
})
export class MarcasNeumaticosModule {}
