## Sobre o projeto

- All store é um projeto para fins de aprendizado e é passado como plano de estudo para os meus estagiários

## Como rodar a aplicação

- Pode rodar dentro da pasta ruiz inicializando o print com o maven: mvn spring-boot:run
- Tambem pode rodar em qualquer direto dando o java -jar < caminho ate o arquivo.jar > all-store-0.0.1-SNAPSHOT.jar


## Funcionalidades

- [x] Cadastro/atualização de Clientes;
- [x] Cadastro/atualização de Livros
- [x] Adicionar saldo a carteira do cliente;
- [x] Fazer compras de livros;

---

## Layout

O projeto desse repositório é apenas a API Backend por enquanto
---

## Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[JUinit](https://maven.apache.org)**
- **[Mockito](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[JPA](https://flywaydb.org)**
- **[H2 Database](https://flywaydb.org)**

---

## Alterações

-  Utilizar o padrão DTO para representar os dados que chegam e saem na API;
-  Funcionalidades do padrão DTO e as suas vantagens;
-  Testar uma classe que possui dependências;
-  Declarar mocks com a anotação @Mock do Mockito;
-  Indicar atributos a serem instanciados e ter suas dependências substituídas pelos mocks, via anotação @InjectMocks;
-  Manipular comportamentos de objetos mocks com o Mockito, via método BDDMockito.given;
-  Testar uma classe Service, que coordena o fluxo de regras de negócio na aplicação;
