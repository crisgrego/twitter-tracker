### Configuración

Es necesario crear:
- Schema en mysql (el nombre no es relevante)

- **/src/main/resources/application.properties**:
```sh
spring.datasource.url = jdbc:mysql://localhost:3306/nombre_del_schema?useSSL=false
spring.datasource.username = user_admin
spring.datasource.password = password
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# (create, create-drop, validate, update) Cambiar a "update" una vez haya arrancado por primera vez.
spring.jpa.hibernate.ddl-auto = create

# Registrar la applicación para poder usar el API de Twiter
spring.social.twitter.appId=consumer
spring.social.twitter.appSecret=secret
```
### Ejecución
Colocarse en el root del proyecto y ejecutar:
```sh
mvn spring-boot:run
```
El servicio se inicia localhost:8080.

### Notas
La interface actual es limitada, orientada solo a cumplir con los requisitos minimos especificados:

- No hay señal de cargando (esperar hasta que aparezca algún resultado).
