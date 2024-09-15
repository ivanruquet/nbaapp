NBA App Deploy
Descripción
NBA App Deploy es una aplicación diseñada para gestionar datos relacionados con la NBA, utilizando Java, Spring Boot y MySQL. Este proyecto proporciona una interfaz para realizar operaciones CRUD sobre los jugadores y equipos de la NBA.

Características
Gestión de Jugadores: Agregar, actualizar y eliminar jugadores.
Gestión de Equipos: Agregar, actualizar y eliminar equipos.
Configuración y Despliegue: Incluye un Docker Compose para simplificar el despliegue con una base de datos MySQL.
Tecnologías Utilizadas
Java 17
Spring Boot
MySQL 8.0
Docker
Maven

Instalación
Clona el repositorio:
git clone https://github.com/tu_usuario/nba-app-deploy.git
cd nba-app-deploy

Construye el proyecto con Maven:
mvn clean install
Configura Docker:

Asegúrate de tener Docker y Docker Compose instalados.

Ejecuta el siguiente comando para iniciar los servicios:
docker-compose up --build

Esto iniciará tanto la aplicación como la base de datos MySQL. La base de datos se inicializará con los datos del script en init/init.sql.

Configuración
URL de la Base de Datos: jdbc:mysql://nba_app:3306/nba?createDatabaseIfNotExist=true&serverTimezone=UTC
Usuario: ivanr
Contraseña: ivanr

Uso
Accede a la aplicación: http://localhost:8080
Puedes interactuar con la API para gestionar jugadores y equipos de la NBA.
Scripts Iniciales
El script init/init.sql se usa para inicializar la base de datos con datos de ejemplo.
Contribuciones
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

Haz un fork del repositorio.
Crea una rama para tu característica o corrección.
Realiza tus cambios y confirma tus cambios.
Envía un pull request.

Contacto
Para cualquier duda o sugerencia, puedes contactarme en ivanruquet@gmail.com
