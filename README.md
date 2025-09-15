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

## Como executar

1. Compile o projeto:
   ```sh
   mvn clean install
   ```
2. Rode a aplicação:
   ```sh
   mvn spring-boot:run
   ```

## Como acessar o Swagger UI
- Acesse: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

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

