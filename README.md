# Autenticação Segura com Spring Security e JWT

 Este projeto demonstra a implementação de um sistema de autenticação seguro utilizando Spring Security e JWT em Java 17. O projeto segue os princípios SOLID e arquitetura limpa para garantir código modular, manutenível e escalável.  



 ## Tecnologias Utilizadas:
### 1. Ferramentas essenciais:
-  **Java 17**.
- **Spring Boot**.
- **Spring Security**.
- **JSON Web Token (JWT)**.
- **Spring Data JPA**.
- **Flyway**.
- **PostgreSQL**.

### 2. Principios e Arquiteturas:
- **SOLID**.
- **Clean Architecture**.

### 3. Dependências:
- **spring-boot-starter-web**.
- **spring-boot-starter-data-jpa**.
- **spring-boot-starter-security**.
- **spring-boot-starter-validation**.
- **spring-boot-starter-actuator**.
- **flyway-core**.
- **postgresql**.
- **lombok**.
- **java-jwt**.

### 4. Descrição das Funcionalidades:
- **Fluxo de Login Robusto**:
  - O usuário fornece suas credenciais (nome email e senha) em uma interface de login segura.
  - O sistema valida as credenciais contra um banco de dados seguro, utilizando criptografia para proteger as informações.
  - Em caso de login bem-sucedido, o sistema gera um token JWT assinado digitalmente e o retorna para o cliente.
- **Validação e Controle de Tokens**:
  - Cada token JWT contém informações sobre o usuário, como ID, nome e permissões de acesso.
  - O token é enviado com cada requisição subsequente, permitindo que o sistema identifique e autorize o usuário sem a necessidade de redigitar suas credenciais.
  - O sistema valida a assinatura e a integridade do token para garantir sua autenticidade e evitar ataques de falsificação.
  - O token expira após um período definido, obrigando o usuário a fazer login novamente para garantir a segurança contínua.
  - Usuários autenticados com token JWT válido podem consultar uma lista de usuários cadastrados no sistema através de uma requisição GET. A funcionalidade permite que usuários credenciados visualizem e gerenciem a base de usuários de forma eficiente. 
