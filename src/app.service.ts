import { Injectable } from '@nestjs/common';
export interface IStatus {
  status: string
  service: string
  version: string
}

@Injectable()
export class AppService {
  getHello(): string {
    return 'Hello World!';
  }
  getStatus(): IStatus {
    return {
      status: 'online',
      service: 'Taller mecánico API',
      version: '1.0.0'
    }
  }
}
