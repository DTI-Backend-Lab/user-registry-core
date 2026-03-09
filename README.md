# 📋 User Registry Core API

##  Descrição do Projeto

API RESTful de cadastro de usuários desenvolvida com fins de **prática e treinamento de conceitos de back-end**. O projeto segue uma arquitetura em camadas bem definida, com separação entre recursos da API, domínio, configuração e utilitários.

---

##  Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|---|---|---|
| ☕ Java | 17 | Linguagem principal |
| 🍃 Spring Boot | 4.0.3 | Framework principal |
| 🗄️ Spring Data JPA | - | Persistência de dados |
| ✅ Spring Validation | - | Validação de campos |
| 🌐 Spring Web MVC | - | Camada REST |
| 📦 H2 Database | - | Banco de dados em memória |
| 📄 SpringDoc OpenAPI (Swagger) | 3.0.2 | Documentação da API |
| 🔧 Lombok | - | Redução de boilerplate |
| 🔨 Maven | - | Gerenciador de dependências e build |
| 🔄 Spring DevTools | - | Hot reload em desenvolvimento |

---

##  Estrutura do Projeto

```
src/
└── main/
    ├── java/
    │   └── io/github/henriqueaguiiar/user_registry_core_api/
    │       ├── api/v1/
    │       │   ├── dto/
    │       │   │   ├── request/      # DTOs de entrada
    │       │   │   └── response/     # DTOs de saída
    │       │   ├── exception/        # Tratamento de erros da API
    │       │   └── resources/        # Controllers / Endpoints
    │       ├── config/               # Configurações da aplicação
    │       └── domain/
    │           ├── entity/           # Entidades JPA
    │           ├── exception/        # Exceções de domínio
    │           ├── mapper/           # Conversão entre objetos
    │           ├── repository/       # Repositórios JPA
    │           ├── service/          # Regras de negócio
    │           └── util/             # Utilitários
    └── resources/
        ├── application.properties
        └── application-dev.properties
```

---


##  Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.8+

### Rodando a aplicação

```bash
./mvnw spring-boot:run
```

Ou no Windows:

```bash
mvnw.cmd spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

A documentação Swagger estará em: `http://localhost:8080/swagger-ui.html`

---

##  Autor

**Henrique Aguiar**  
[github.com/henriqueaguiiar](https://github.com/henriqueaguiiar)

