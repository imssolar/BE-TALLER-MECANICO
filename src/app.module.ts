import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { UsersModule } from './users/users.module';
import { AuthModule } from './auth/auth.module';
import { TerminalModule } from './terminal/terminal.module';
import { ModelosModule } from './modelos/modelos.module';
import { BusesModule } from './buses/buses.module';

@Module({
  imports: [
    // ConfigModule - Lee el archivo .env
    ConfigModule.forRoot({
      isGlobal: true, // Disponible en toda la app sin reimportar
    }),

    // TypeOrmModule - Conexión a PostgreSQL
    TypeOrmModule.forRoot({
      type: 'postgres',
      host: process.env.DB_HOST,
      port: parseInt(process.env.DB_PORT || '5434', 10),
      username: process.env.DB_USERNAME,
      password: process.env.DB_PASSWORD,
      database: process.env.DB_NAME,
      autoLoadEntities: true, // Carga automáticamente las @Entity de cada módulo
      synchronize: true, // ⚠️ Solo en desarrollo - crea tablas automáticamente
    }),

    UsersModule,

    AuthModule,

    TerminalModule,

    ModelosModule,

    BusesModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
