
# Loja Online – API REST

## Integrantes

- Gabriel Mediotti Marques - RM 552632
- Jó Sales - RM 552679
- Miguel Garcez de Carvalho - RM 553768
- Vinicius Souza e Silva - RM 552781

## Requisitos

- Java 17 + Spring Boot 3.x
- Maven
- H2 Database (memória)

## Estrutura do Projeto

- `src/main/java`: Código-fonte da aplicação
- `src/main/resources`: Configurações e dados iniciais
- `src/test/java`: Testes automatizados
- `jars/`: Local onde o arquivo `.jar` é gerado após o build
- `Dockerfile`: Configuração para criar imagem Docker
- `docker-compose.yml`: Orquestração de containers

## Como executar localmente

1. Compile o projeto:

   ```sh
   mvn clean package
   ```

2. Rode a aplicação:

   ```sh
   mvn spring-boot:run
   ```

   ou

   ```sh
   java -jar jars/soa-checkpoint-1-1.0-SNAPSHOT.jar
   ```

## Como acessar o Swagger UI

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Exemplos de chamadas (curl)

### Criar cliente

```sh
curl -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d '{"nome":"Ana","email":"ana@email.com","documento":"123"}'
```

### Listar clientes

```sh
curl http://localhost:8080/clientes
```

### Criar produto

```sh
curl -X POST http://localhost:8080/produtos -H "Content-Type: application/json" -d '{"nome":"Mouse","preco":120.0,"categoria":"Acessórios","descricao":"USB"}'
```

### Listar produtos

```sh
curl http://localhost:8080/produtos
```

## Dados de teste

- Clientes: Ana Silva, Carlos Souza
- Produtos: Notebook, Mouse

## Observações

- Email do cliente deve ser único.
- Preço do produto deve ser maior que 0.
- Campo "ativo" do produto é true por padrão.
- Documentação completa disponível no Swagger UI.
