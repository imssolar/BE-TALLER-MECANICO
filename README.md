# Taller Mecánico - Backend

Sistema de gestión de taller mecánico desarrollado con Spring Boot.

## Tecnologías

- Java 21
- Spring Boot 3.3.6
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger/OpenAPI
- Bean Validation

## Requisitos

- JDK 21 o superior
- Maven 3.8+
- PostgreSQL 12+

## Configuración de Base de Datos

```properties
Host: localhost
Puerto: 5434
Base de datos: taller_mecanico
Usuario: tu_usuario
Password: tu_password
```

## Ejecutar el proyecto

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar en modo desarrollo
mvn spring-boot:run

# Ejecutar con perfil específico
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

La aplicación estará disponible en: **http://localhost:8080**

## Documentación API (Swagger)

Una vez iniciada la aplicación, acceder a:

- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs JSON:** http://localhost:8080/api-docs

## Módulos y Endpoints

### 🚌 Buses (`/buses`)
- `POST /buses` - Crear bus
- `GET /buses` - Listar todos
- `GET /buses/estadisticas` - Estadísticas generales
- `GET /buses/operativos` - Buses operativos
- `GET /buses/inactivos` - Buses inactivos
- `GET /buses/en-mantencion` - Buses en mantención
- `GET /buses/terminal/{id}` - Por terminal
- `GET /buses/modelo/{id}` - Por modelo
- `GET /buses/patente/{patente}` - Por patente
- `GET /buses/{id}` - Por ID
- `PATCH /buses/{id}` - Actualizar
- `PATCH /buses/{id}/estado` - Actualizar estado operativo
- `PATCH /buses/{id}/kilometraje` - Actualizar kilometraje
- `PATCH /buses/{id}/emergencia` - Registrar emergencia
- `DELETE /buses/{id}` - Eliminar

### 👨‍🔧 Empleados (`/empleados`)
- `POST /empleados` - Crear empleado
- `GET /empleados` - Listar todos
- `GET /empleados/activos` - Empleados activos
- `GET /empleados/inactivos` - Empleados inactivos
- `GET /empleados/conductores` - Solo conductores
- `GET /empleados/mecanicos` - Solo mecánicos
- `GET /empleados/rut/{rut}` - Buscar por RUT
- `GET /empleados/{id}` - Por ID
- `PATCH /empleados/{id}` - Actualizar
- `PATCH /empleados/{id}/desactivar` - Desactivar
- `PATCH /empleados/{id}/activar` - Activar
- `DELETE /empleados/{id}` - Eliminar

### 🔧 Neumáticos (`/neumaticos`)
- `POST /neumaticos` - Crear neumático
- `GET /neumaticos` - Listar todos
- `GET /neumaticos/activos` - Neumáticos activos
- `GET /neumaticos/inactivos` - Neumáticos inactivos
- `GET /neumaticos/bus/{idBus}` - Por bus
- `GET /neumaticos/estado/{idEstado}` - Por estado
- `GET /neumaticos/marca/{idMarca}` - Por marca
- `GET /neumaticos/{id}` - Por ID
- `PATCH /neumaticos/{id}` - Actualizar
- `PATCH /neumaticos/{id}/desactivar` - Desactivar
- `PATCH /neumaticos/{id}/activar` - Activar
- `DELETE /neumaticos/{id}` - Eliminar

### 📍 Terminales (`/terminal`)
- `POST /terminal` - Crear terminal
- `GET /terminal` - Listar todos
- `GET /terminal/{id}` - Por ID
- `PATCH /terminal/{id}` - Actualizar
- `DELETE /terminal/{id}` - Eliminar

### 🚍 Modelos (`/modelos`)
- `POST /modelos` - Crear modelo
- `GET /modelos` - Listar todos
- `GET /modelos/{id}` - Por ID
- `PATCH /modelos/{id}` - Actualizar
- `DELETE /modelos/{id}` - Eliminar

### 🛣️ Rutas (`/rutas`)
- `POST /rutas` - Crear ruta
- `GET /rutas` - Listar todas
- `GET /rutas/{id}` - Por ID
- `PATCH /rutas/{id}` - Actualizar
- `DELETE /rutas/{id}` - Eliminar

### 📊 Estados Neumático (`/estados-neumatico`)
- `POST /estados-neumatico` - Crear estado
- `GET /estados-neumatico` - Listar todos
- `GET /estados-neumatico/{id}` - Por ID
- `PATCH /estados-neumatico/{id}` - Actualizar
- `DELETE /estados-neumatico/{id}` - Eliminar

### 🏷️ Marcas Neumáticos (`/marcas-neumaticos`)
- `POST /marcas-neumaticos` - Crear marca
- `GET /marcas-neumaticos` - Listar todas
- `GET /marcas-neumaticos/{id}` - Por ID
- `PATCH /marcas-neumaticos/{id}` - Actualizar
- `DELETE /marcas-neumaticos/{id}` - Eliminar

### 📦 Modelos Neumático (`/modelos-neumatico`)
- `POST /modelos-neumatico` - Crear modelo
- `GET /modelos-neumatico` - Listar todos
- `GET /modelos-neumatico/{id}` - Por ID
- `PATCH /modelos-neumatico/{id}` - Actualizar
- `DELETE /modelos-neumatico/{id}` - Eliminar

### 🔋 Marcas Baterías (`/marcas-baterias`)
- `POST /marcas-baterias` - Crear marca
- `GET /marcas-baterias` - Listar todas
- `GET /marcas-baterias/{id}` - Por ID
- `PATCH /marcas-baterias/{id}` - Actualizar
- `DELETE /marcas-baterias/{id}` - Eliminar

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/tallermecanico/
│   │   ├── TallerMecanicoApplication.java  # Clase principal
│   │   ├── config/                          # Configuraciones (Swagger, CORS)
│   │   ├── entity/                          # Entidades JPA (11 entidades)
│   │   ├── dto/                             # DTOs Request/Response
│   │   │   ├── request/                     # DTOs de entrada
│   │   │   └── response/                    # DTOs de salida
│   │   ├── repository/                      # Repositorios JPA
│   │   ├── service/                         # Lógica de negocio
│   │   ├── controller/                      # REST Controllers
│   │   ├── exception/                       # Excepciones y manejo global
│   │   ├── util/                            # Utilidades (TextUtils)
│   │   └── enums/                           # Enumeraciones (CargoEmpleado)
│   └── resources/
│       ├── application.properties           # Configuración general
│       └── application-dev.properties       # Configuración desarrollo
└── test/
```

## Características Implementadas

✅ **11 Entidades JPA** con relaciones completas
✅ **81 Endpoints REST** totalmente funcionales
✅ **Validaciones completas** con Bean Validation
✅ **Manejo global de excepciones** personalizado
✅ **Documentación Swagger** automática
✅ **Configuración CORS** para desarrollo
✅ **Normalización de texto** (rutas)
✅ **DTOs de respuesta personalizados**
✅ **Estadísticas de buses** por terminal
✅ **Soft delete** en empleados y neumáticos

## Validaciones Implementadas

- **RUT chileno:** Formato `12345678-9`
- **Teléfono chileno:** Formato `+56912345678` o `912345678`
- **Año fabricación:** >= 1900
- **Posición neumático:** 1-6
- **Patente única**
- **RUT único**
- **Nombres únicos** (terminales, modelos, marcas, etc.)

## Manejo de Errores

La API retorna respuestas JSON estructuradas para todos los errores:

```json
{
  "timestamp": "2026-02-09T12:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Errores de validación en los campos",
  "path": "/api/empleados",
  "validationErrors": {
    "rut": "Formato de RUT inválido"
  }
}
```

## Migración desde NestJS

Este proyecto es una **migración completa** del sistema original desarrollado en **NestJS/TypeScript** a **Spring Boot/Java**.

### Equivalencias de tecnologías:

| NestJS | Spring Boot |
|--------|-------------|
| TypeORM | Spring Data JPA |
| class-validator | Bean Validation |
| @nestjs/swagger | SpringDoc OpenAPI |
| NotFoundException | ResourceNotFoundException |
| ConflictException | DuplicateResourceException |

## Próximos pasos

- [ ] Implementar autenticación JWT
- [ ] Agregar tests unitarios
- [ ] Agregar tests de integración
- [ ] Implementar paginación
- [ ] Agregar filtros avanzados
- [ ] Documentar ejemplos de uso en Swagger
