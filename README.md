<<<<<<< HEAD
# CRUD com Spring Boot 3
## Objetivo
Praticar conceitos como API, API Rest, API Restful, integrando um código Java com o banco de dados PostgreSQL através do Spring Boot ao realizar um CRUD (Create, Read, Update, Delete).

## Tecnologias Utilizadas
- Spring Boot
- PostgreSQL
- Java
- SQL
- Postman
- VS Code
=======
# API Restfull with Spring Security

## Technologies Used

- Java,
- Spring Boot,
- Flyway Migrations,
- PostgresSQL, 
- Spring Security, 
- JWT for authentication control,
- Postman.

## commands to use in Postman
```markdown
GET /product/list - List of all products. (all users).

POST /product - Add product. (ADMIN access required).

PUT /product - Register a new product (ADMIN access required).

DELETE /product/{id} - Delete a product (ADMIN access required).

POST /auth/login - Login into the App

POST /auth/register - Register a new user into the App



```
## Examples

```markdown
Example Register Admin:
    {
        "login":"admin",
        "password":"admin123",
        "role":"ADMIN"
    }

Example Register User:
    {
        "login":"user",
        "password":"user123",
        "role":"USER"
    }
OBS: Both generate a diferent Bearer Token
```
>>>>>>> f4fb998d6911db58575c01a13260dd48ed96564d
