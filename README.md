# API: Obter valor sequencial com base no índice informado. Alticci-service

 Objetivos
  - Receber um índice;
  - Listar todos os números;
  - Buscar por ID;
  
### Stack utilizada

* Java 11
* Spring Boot Web; JPA; Data; Actuator
* Maven
* JUnit
* OpenApi (Swagger v3)
* H2 DataBase
* Lombok
* Docker

### Instalação

```
docker run -p 8001:8001 -d tiagopsilva/alticci-service:0.0.1-SNAPSHOT

```

### Spring Boot Version

```
Pode importar como projeto maven existente no Spring Tool Suite 4 que foi a versão usada para desenvolver
```

#### Swagger
Desenvolvimento:
```
http://localhost:8001/api/v1/alticci-service/v3/api-docs
```
### Arquivo de Collection Json - Usar no Postman

```
  - O arquivo de Collection Json está na pasta Docs. Pode copiar e importar no postman para testar os payloads da api
```


### Versionamento da API

```
O versionamento foi feito pela url, onde a api foi construida como api/v1.

```

###Observação:

```
Link para acessar o banco H2: 
http://localhost:8001/h2-console
User = sa
Password = ""
host = jdbc:h2:mem:testdb

```


