import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { BusesService } from './buses.service';
import { BusesController } from './buses.controller';
import { Bus } from './entities/bus.entity';
import { TerminalModule } from '../terminal/terminal.module';
import { ModelosModule } from '../modelos/modelos.module';

@Module({
  imports: [
    TypeOrmModule.forFeature([Bus]),
    TerminalModule,
    ModelosModule,
  ],
  controllers: [BusesController],
  providers: [BusesService],
  exports: [BusesService],
})
export class BusesModule {}
