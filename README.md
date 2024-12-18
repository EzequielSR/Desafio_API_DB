# Desafio API DB

## Índice 📑

- [Descrição](#descrição)
- [Configuração de Repositório](#configuração-de-repositório)
- [Caso de Uso](#caso-de-uso)
- [Configuração da Aplicação](#configuração-da-aplicação)
- [Testes Implementados](#testes-implementados)
- [Gerar Relatório](#gerar-relatório)
- [Bugs e Inconsistências](#bugs-e-inconsistências)
- [Roadmap](#roadmap)
- [Logs](#logs)
- [Stack](#stack)

---

## Descrição 🚀

Este repositório contém o código para o desafio de automação de testes em API solicitado pela empresa. O objetivo do desafio é validar o comportamento de uma API Rest, utilizando práticas de **Clean Code**, **Design Patterns**, **Orientação a Objetos** e **Arquitetura de Automação de Testes**.

A API a ser testada é a [ViaCEP](https://viacep.com.br/), que retorna informações sobre um endereço a partir de um CEP. Os cenários de teste abordados são:

- **Cenário 1:** Cep Válido ✅
- **Cenário 2:** Cep Inválido ❌

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

