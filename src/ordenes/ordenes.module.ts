import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { OrdenesService } from './ordenes.service';
import { OrdenesController } from './ordenes.controller';
import { Orden } from './entities/orden.entity';
import { Vehiculo } from '../vehiculos/entities/vehiculo.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Orden, Vehiculo])],
  controllers: [OrdenesController],
  providers: [OrdenesService],
})
export class OrdenesModule {}
