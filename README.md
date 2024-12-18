# Desafio API DB

## Descrição 🚀

Este repositório contém o código para o desafio de automação de testes em API. O objetivo do desafio é validar o comportamento de uma API Rest, utilizando práticas de **Clean Code**, **Design Patterns**, **Orientação a Objetos** e **Arquitetura de Automação de Testes**.

A API a ser testada é a [ViaCEP](https://viacep.com.br/), que retorna informações sobre um endereço a partir de um CEP. Os cenários de teste abordados são:

- **Cenário 1:** Cep Válido ✅
- **Cenário 2:** Cep Inválido ❌

---

## Índice 📑

- [Descrição](#descrição-)
- [Configuração de Repositório](#configuração-de-repositório-)
- [Caso de Uso](#caso-de-uso-)
- [Configuração de Aplicação](#configuração-de-aplicação-)
- [Testes Implementados](#testes-implementados-)
- [Gerar Relatório](#gerar-relatório-)
- [Bugs e Inconsistências](#bugs-e-inconsistências-)
- [Roadmap](#roadmap-)
- [Logs](#logs-)
- [Stack](#stack-)

---

## Configuração de Repositório 🛠️

1. Clone o repositório em sua máquina:
   ```bash
   git clone https://github.com/seu-usuario/desafio-api-rest.git
   ```
   
2. Acesse o diretório do projeto:
   ```bash
     cd Desafio_API_DB
   ```

3. Importe o projeto no seu IDE(recomendo o IntelliJ IDEA)
   
4. Certifique-se que o seu **Java** está configurado corretamente(versão 11 ou superior).

---

## Caso de Uso 📋

A API testada fornece os seguintes comportamentos:

* Cenário 1: Quando um **CEP válido** é passado na URL, a API retorna um JSON com os dados do endereço.
  
* Cenário 2:  Quando um **CEP inválido** é passado, a API retorna uma mensagem de erro ou não encontra o endereço.

Esses cenários são validados automaticamente pelos testes implementados. 

---

## Configuração de Aplicação ⚙️

Este projeto utiliza o seguinte:

* **Java**: Versão 11 ou superior
  
* **Frameworks e Bibliotecas**:
    * **RestAssured** (para realizar as requisições HTTP)
    * **JUnity 5** (para executar os testes)
    * **Maven** (para gerenciamento de dependências)

  Certifique-se de ter as dependências configuradas corretamente no arquivo **pom.xml**.

  ### Dependências Maven:

  ```xml
  <dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>4.5.1</version>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.1</version>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.7.1</version>
    <scope>test</scope>
  </dependency>
  ```

  ---

## Testes Implementados ✅

Foram implementados testes para validas os seguintes cenários:

1. Cenário 1: Validação de **CEP válido**
   
    - Realiza uma requisição para a API ViaCEP com um CEP válido.
    - Verifica se a resposta contém os dados corretos do endereço.

2. Cenário 2: Validação de **CEP inválido**
   
   - Realiza uma requisição para a API ViaCEP com um CEP inválido.
   - Verifica se a resposta retorna uma mensagem de erro ou um status de não encontrado.

Os testes estão localizados na pasta **src/test/java**, na classe *EnderecoServiceTest*.

## Exemplo de Teste:

```java
 @Test
    public void testCepValido() {
        String cepValido = "88010400";

        Optional<EnderecoDTO> enderecoDTOOptional = enderecoService.getCepAsDTO(cepValido);

        assertTrue(enderecoDTOOptional.isPresent(),"O EnderecoDTO deve estar presente" );
        EnderecoDTO enderecoDTO = enderecoDTOOptional.get();

        assertNotNull(enderecoDTO);
        assertEquals("88010-400", enderecoDTO.getCep());
        assertEquals("Praça Quinze de Novembro", enderecoDTO.getLogradouro());
        assertEquals("Centro", enderecoDTO.getBairro());
        assertEquals("Florianópolis", enderecoDTO.getLocalidade());
        assertEquals("SC", enderecoDTO.getUf());
    }
```

---

## Gerar Relatório 📊

Para gerar o relatório dos testes executados, utilize o plugin de relatórios do Maven ou a integração com o JUnit 5. Após a execução dos testes, o Maven cria um relatório no diretório target/surefire-reports.

### Executando os Testes
1. Abra o terminal e navegue até o diretório do projeto.
2. Execute os testes com o comando:
   ```bash
   mvn test
   ```
3. O relatório será gerado em **target/surefire-reports**.

---

## Bugs e Inconsistências 🐞

* **Problema 1**: A API ViaCEP retorna respostas diferentes para o mesmo CEP em algumas situações. Isso pode ser um comportamento inesperado.

* **Problema 2**: A API não fornece mensagens de erro claras para todos os cenários de CEP inválido.

Caso você encontre outros bugs ou inconsistências, por favor, registre-os na seção de issues do repositório.

---

## Roadmap 🗺️

---

## Logs 📝
Logs de execução podem ser visualizados na saída padrão (console) durante a execução dos testes. Certifique-se de que o nível de log esteja configurado para INFO ou DEBUG para maior detalhamento.

---

## Stack 💻

* **Linguagem**: Java

* **Frameworks**:
     * RestAssured
     * JUnit 5
     * Jackson Databind
     
* **Dependências**: Maven, RestAssured, JUnit

* **Estrutura do Projeto**:
```plaintext
src/main/java/com/example/viaceprestapi
      ├── dto
      │   └──  EnderecoDTO.java
      │  
      ├── model
      │   └── Endereco.java
      │
      ├── service
      │   └── EnderecoService.java
      │
      │  
      └── resources

src/test/java/com/example/viaceprestapi.tests
      │  
      └── EnderecoServiceTest

```
