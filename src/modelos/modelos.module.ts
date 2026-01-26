import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ModelosService } from './modelos.service';
import { ModelosController } from './modelos.controller';
import { Modelo } from './entities/modelo.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Modelo])],
  controllers: [ModelosController],
  providers: [ModelosService],
  exports: [ModelosService], // Para usar en otros módulos (ej: Buses)
})
export class ModelosModule {}
