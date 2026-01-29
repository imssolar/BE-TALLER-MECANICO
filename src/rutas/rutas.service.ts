import { ConflictException, Injectable, NotFoundException } from '@nestjs/common';
import { CreateRutaDto } from './dto/create-ruta.dto';
import { UpdateRutaDto } from './dto/update-ruta.dto';
import { ILike, Like, Repository } from 'typeorm';
import { Ruta } from './entities/ruta.entity';
import { normalizeText } from '@/common/helpers/text.helper';

@Injectable()
export class RutasService {

  constructor(private readonly rutaRepository: Repository<Ruta>,) { }

  async create(createRutaDto: CreateRutaDto) {
    await this.validarRutaUnica(createRutaDto.ruta)
    const rutaNormalizada = normalizeText(createRutaDto.ruta)
    const nuevaRuta = this.rutaRepository.create({
      ruta: rutaNormalizada
    });
    return await this.rutaRepository.save(nuevaRuta)
  }

  async findOne(id: number) {
    const ruta = await this.rutaRepository.findOneBy({ idRuta: id })
    if (!ruta) {
      throw new NotFoundException(`Ruta con ID ${id} no encontrada`)
    }
    return ruta
  }

  async findByNombre(nombre: string) {
    const rutas = await this.rutaRepository.find({
      where: {
        ruta: Like(`%${nombre}`)
      }
    });
    if (rutas.length === 0) {
      throw new NotFoundException(`No se encontraron rutas con el nombre ${nombre}`)
    }
    return rutas
  }

  async findAll() {
    return await this.rutaRepository.find()
  }

  update(id: number, updateRutaDto: UpdateRutaDto) {
    return `This action updates a #${id} ruta`;
  }

  remove(id: number) {
    return `This action removes a #${id} ruta`;
  }



  private async validarRutaUnica(nombreRuta: string): Promise<void> {
    const rutaNormalizada = normalizeText(nombreRuta)

    const existeRuta = await this.rutaRepository.findOne({
      where: {
        ruta: ILike(rutaNormalizada)
      }
    });
    if (existeRuta) {
      throw new ConflictException(`La ruta con nombre ${nombreRuta} ya existe `)
    }
  }
}
