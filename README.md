# Projeto Spring Boot - Back-End

API REST desenvolvida com Java e Spring Boot para gerenciamento de usuários, categorias, produtos e pedidos. O projeto utiliza autenticação com Google OAuth2, validação de JWT e persistência em banco de dados MySQL.

## Tecnologias

- Java 21
- Spring Boot
- Spring Security
- OAuth2 Resource Server
- OAuth2 Client
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

## Funcionalidades

- Autenticação com Google OAuth2
- Troca do authorization code por token
- Proteção de rotas com JWT
- CRUD de usuários
- CRUD de categorias
- CRUD de produtos
- CRUD de pedidos
- Paginação nas listagens
- Integração com frontend web

## Pré-requisitos

- Java 21
- Maven
- MySQL
- Credenciais OAuth2 configuradas no Google Cloud Console

## Configuração do banco de dados

Crie o banco de dados MySQL:

```sql
CREATE DATABASE appcorp;
```

## Variáveis de ambiente

As credenciais do Google não devem ser colocadas diretamente no código.

Antes de executar o backend, configure as variáveis de ambiente:

```powershell
$env:GOOGLE_CLIENT_ID="seu-google-client-id"
$env:GOOGLE_CLIENT_SECRET="seu-google-client-secret"
```

## Executando o projeto

Na pasta raiz do backend, execute:

```powershell
mvn spring-boot:run
```

## Endpoints principais

| Recurso | Método | Endpoint |
|---|---|---|
| Autenticação Google | POST | `/auth/google` |
| Listar usuários | GET | `/usuarios/lista` |
| Buscar usuário por ID | GET | `/usuarios/{id}` |
| Cadastrar usuário | POST | `/usuarios` |
| Atualizar usuário | PUT | `/usuarios/{id}` |
| Remover usuário | DELETE | `/usuarios/{id}` |
| Categorias | GET/POST/PUT/DELETE | `/categorias` |
| Produtos | GET/POST/PUT/DELETE | `/produtos` |
| Pedidos | GET/POST/PUT/DELETE | `/pedidos` |

## Autor

Projeto desenvolvido para fins acadêmicos, utilizando Java Spring Boot, OAuth2, JWT e MySQL.
