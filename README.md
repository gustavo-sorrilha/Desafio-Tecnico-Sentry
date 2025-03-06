# Desafio Técnico - Gerenciamento de Documentos

Este é um sistema de gerenciamento de documentos desenvolvido com **Spring Boot**, **Maven** e **Swagger**. O sistema oferece uma API RESTful para realizar operações de CRUD (Criar, Ler, Atualizar, Apagar) em documentos.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para criação da aplicação.
- **Spring Data JPA**: Para persistência de dados utilizando banco de dados relacional.
- **Swagger**: Para documentação e teste da API.
- **Log4j2**: Para gerenciamento de logs.
- **Maven**: Gerenciador de dependências e build.

## Como Rodar a Aplicação

### Pré-requisitos

- **Java 21** ou superior instalado.
- **Maven** instalado para gerenciar dependências.
- **IDE** recomendada: IntelliJ IDEA ou Eclipse.

### Passos para rodar a aplicação

1. **Clone o repositório**:
   ```
   git clone https://github.com/gustavo-sorrilha/Desafio-Tecnico-Sentry.git
2. **Acesse o diretório do projeto**:
   ```
   cd desafio
3. **Baixe as dependências do Maven**:
   ```
   mvn clean install
4. **Rode a aplicação**:
   ```
   mvn spring-boot:run
5. **A aplicação estará rodando em ```http://localhost:8080```**

**Acessando a Documentação Swagger**

Acesse a documentação da API via Swagger:

URL: ```http://localhost:8080/swagger-ui.html```

A interface Swagger permitirá que você visualize todos os endpoints da API e até mesmo faça requisições diretamente pela interface.

**Logs**

Os logs da aplicação estão configurados com Log4j2. Eles são registrados em tempo real e podem ser visualizados no console. O Log4j2 está configurado para registrar informações sobre a execução da aplicação, erros e outros eventos importantes.

**Desenvolvido por Gustavo Sorrilha Sanches**
