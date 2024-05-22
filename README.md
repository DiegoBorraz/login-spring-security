# Autenticação Segura com Spring Security e JWT

 <p>Desenvolvi um sistema de autenticação utilizando Spring Security e JWT em Java 17. O projeto segue os princípios SOLID e Clean Architecture para garantir código modular, de facil manutenção e escalável.</p>
 <p>O sistema utiliza Refresh token, ele renova o token do usuário sem precisar logar novamente, com segurança e praticidade.</p>
 <p>Também utilizando a ferramenta Flyway para geração automática das tabelas.</p>
 
 ## Tecnologias Utilizadas:
### 1. Ferramentas essenciais:
- <img height="20" src="https://raw.githubusercontent.com/jmnote/z-icons/master/svg/java.svg">    [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- <img height="20" src="https://img.icons8.com/?size=48&id=90519&format=png">    [Spring Boot](https://spring.io/projects/spring-boot)
- <img height="20" src="https://img.icons8.com/?size=48&id=90519&format=png">    [Spring Security](https://spring.io/projects/spring-security)
- <img height="20" src="https://img.icons8.com/?size=48&id=90519&format=png">    [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- <img height="20" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReUAQvS7o185SN7VX495l3HdBlMaW0uNyN2w&s">    [Flyway](https://flywaydb.org/)
- <img height="20" src="https://jwt.io/img/pic_logo.svg">    [JSON Web Token (JWT)](https://jwt.io/)
- <img height="20" src="https://avatars.githubusercontent.com/u/113517144?s=280&v=4">    [PostgreSQL](https://www.pgadmin.org/)

### 2. Principios e Arquiteturas:
- **SOLID**.
- **Clean Architecture**.

### 3. Criação do banco PostgreSQL

* Utilize o PostgreSQL Shell ou PgAdmin para criar o banco de dados com o comando:
    ```sql
    CREATE DATABASE logindb;
    ```
### 4. Geração automatica das tabelas com Flyway

<p>Adicione as seguintes propriedades no arquivo `application.properties` em <i>src/main/resources</i>:</p>

```
spring.application.name=spring-security
spring.datasource.url=jdbc:postgresql://localhost:5432/logindb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

auth.jwt.token.secret=${JWT_SECRET:my-secret-key}
auth.jwt.token.Issuer=auth-api
auth.jwt.token.expiration=1
auth.jwt.refersh-token.expiration=8
```


### 5. Exemplos de Uso:
- **Cadastro do usuário**:
<div alingn="center">
 <img src="https://github.com/DiegoBorraz/login-spring-security/assets/20254303/c1eb947b-d7f1-4a7f-89f9-a13b5f031342" />
</div>

- **Login usuário gerando o token e o refresh-token**:
<div alingn="center">
 <img src="https://github.com/DiegoBorraz/login-spring-security/assets/20254303/4cbe6f0f-10f9-4d13-a110-74883906cffe" />
</div>

- **Consulta de usuários cadastrados exigindo token de autenticação**:
<div alingn="center">
 <img src="https://github.com/DiegoBorraz/login-spring-security/assets/20254303/963855d7-5af7-4071-b0c2-462ed8f50e85" />
</div>
