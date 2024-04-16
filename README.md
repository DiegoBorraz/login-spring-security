# Autenticação Segura com Spring Security e JWT

 Este projeto demonstra a implementação de um sistema de autenticação seguro utilizando Spring Security e JWT em Java 17. O projeto segue os princípios SOLID e arquitetura limpa para garantir código modular, manutenível e escalável.  

 ## Tecnologias Utilizadas:
### 1. Ferramentas essenciais:
-  **Java 17**: Desenvolvimento com a última versão do Java, aproveitando seus novos recursos e performance aprimorada.
- **Spring Boot**: Framework poderoso para desenvolvimento rápido de APIs RESTful, facilitando a criação e o deploy da aplicação.
- **Spring Security**: Autenticação e autorização robustas para sua aplicação, protegendo seus dados e recursos com segurança de ponta.
- **JSON Web Token (JWT)**: Mecanismo moderno e leve para autenticação sem estado, ideal para APIs RESTful e microserviços.
- **Spring Data JPA**: Acesso simplificado a bancos de dados relacionais, como PostgreSQL, com foco em produtividade e legibilidade do código.
- **Flyway**: Gerenciamento eficiente de migrações de banco de dados, garantindo a consistência e a confiabilidade do seu sistema.
- **PostgreSQL**: Banco de dados relacional open-source, robusto e escalável, ideal para aplicações de alto desempenho e confiabilidade.

### 2. Principios de Design Sólido:
- **SOLID**: Implementação dos princípios SOLID (SRP, OCP, LSP, ISP e DIP) para garantir um código limpo, modular, fácil de manter e extender.
- **Arquitetura Limpa**: Separação de concerns em camadas bem definidas, promovendo organização, modularidade, testabilidade e reutilização do código.

### 3. Dependências:
- **Spring Boot**:
  - **Web**: Cria APIs RESTful com facilidade e integra recursos como validação de dados, tratamento de exceções e internacionalização.
  - **JPA**: Acesso simplificado a bancos de dados relacionais com ORM (Object-Relational Mapping), permitindo que você trabalhe com objetos Java em vez de SQL.
  - **Security**: Autenticação e autorização robustas com suporte a diversos mecanismos, como basic authentication, OAuth 2.0 e JWT.
  - **Validation**: Validação de dados de entrada e saída para garantir a integridade e confiabilidade dos dados.
  - **Actuator**: Monitoramento e gerenciamento da aplicação em tempo real, expondo endpoints para verificar o status da aplicação e realizar diversas operações.
  - Flyway: Gerenciamento de migrações de banco de dados, permitindo que você altere a estrutura do banco de dados de forma segura e controlada.
- **PostgreSQL Driver**: Permite que seu projeto se conecte a um banco de dados PostgreSQL para armazenar e recuperar dados.
- **Lombok**: Simplifica o código Java removendo código repetitivo e boilerplate, tornando-o mais conciso e legível.
- **java-jwt**: Biblioteca para trabalhar com JSON Web Tokens (JWT) para autenticação e autorização em APIs RESTful.
