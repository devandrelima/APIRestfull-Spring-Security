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

PUT /product - Update the product (ADMIN access required).

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
