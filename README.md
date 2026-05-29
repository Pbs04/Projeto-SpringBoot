# App Corporativa - Back-End

API REST desenvolvida com Java e Spring Boot para gerenciamento de usuários, categorias, produtos e pedidos, com autenticação via Google OAuth2 e persistência em MySQL.

## Tecnologias

- Java 21
- Spring Boot
- Spring Security
- OAuth2 / JWT
- Spring Data JPA
- MySQL
- Maven
- Lombok

## Funcionalidades

- Autenticação com Google OAuth2
- Proteção de rotas com JWT
- CRUD de usuários
- CRUD de categorias
- CRUD de produtos
- CRUD de pedidos
- Paginação de registros
- Integração com frontend web

## Como executar

Clone o repositório:

```bash
git clone https://github.com/Pbs04/Projeto-SpringBoot.git
```

Acesse a pasta do projeto:

```bash
cd Projeto-SpringBoot
```

Configure as variáveis de ambiente necessárias:

```powershell
$env:GOOGLE_CLIENT_ID="seu-client-id"
$env:GOOGLE_CLIENT_SECRET="seu-client-secret"
```

Execute a aplicação:

```powershell
.\mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

## Banco de dados

O projeto utiliza MySQL. Crie um banco chamado:

```sql
CREATE DATABASE appcorp;
```

As configurações de conexão ficam em:

```text
src/main/resources/application.properties
```

## Segurança

As credenciais do Google OAuth2 não são versionadas no repositório. A aplicação utiliza variáveis de ambiente para carregar informações sensíveis em tempo de execução.

## Estrutura principal

```text
src/main/java/br/cefetrj/springapp
├── controller
├── model
├── repository
├── service
├── security
└── config
```

## Front-End

Este backend foi desenvolvido para integração com o frontend disponível em:

```text
https://github.com/Pbs04/Projeto-SpringBoot-FrontEnd
```
