import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { TerminalService } from './terminal.service';
import { TerminalController } from './terminal.controller';
import { Terminal } from './entities/terminal.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Terminal])],
  controllers: [TerminalController],
  providers: [TerminalService],
  exports: [TerminalService], // Para usar en otros módulos (ej: Buses)
})
export class TerminalModule {}
