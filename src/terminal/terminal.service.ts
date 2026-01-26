import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Terminal } from './entities/terminal.entity';
import { CreateTerminalDto } from './dto/create-terminal.dto';
import { UpdateTerminalDto } from './dto/update-terminal.dto';

@Injectable()
export class TerminalService {
  constructor(
    @InjectRepository(Terminal)
    private readonly terminalRepository: Repository<Terminal>,
  ) {}

  async create(createTerminalDto: CreateTerminalDto): Promise<Terminal> {
    const terminal = this.terminalRepository.create(createTerminalDto);
    return await this.terminalRepository.save(terminal);
  }

  async findAll(): Promise<Terminal[]> {
    return await this.terminalRepository.find();
  }

  async findOne(id: number): Promise<Terminal> {
    const terminal = await this.terminalRepository.findOne({
      where: { idTerminal: id },
    });
    if (!terminal) {
      throw new NotFoundException(`Terminal con ID ${id} no encontrado`);
    }
    return terminal;
  }

  async update(id: number, updateTerminalDto: UpdateTerminalDto): Promise<Terminal> {
    const terminal = await this.findOne(id);
    Object.assign(terminal, updateTerminalDto);
    return await this.terminalRepository.save(terminal);
  }

  async remove(id: number): Promise<void> {
    const terminal = await this.findOne(id);
    await this.terminalRepository.remove(terminal);
  }
}
