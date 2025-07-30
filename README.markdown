# Desafio de Concessão de Empréstimos

## Descrição
Este projeto resolve um desafio de programação que envolve a implementação de uma lógica para concessão de empréstimos com base em critérios de salário, idade e localização do cliente. A solução foi organizada em uma arquitetura modular com separação de responsabilidades, utilizando pastas para `controllers`, `services`, `exceptions` e `entities` (contendo `dto` e `enum`).

## Requisitos do Desafio
O desafio consistia em implementar uma lógica que atende às seguintes regras:
- **Empréstimo Pessoal**:
  - Concedido se o salário do cliente for ≤ R$ 3.000.
  - Concedido se o salário estiver entre R$ 3.000 e R$ 5.000, o cliente tiver menos de 30 anos e residir em São Paulo (SP).
- **Empréstimo Consignado**:
  - Concedido se o salário do cliente for ≥ R$ 5.000.
- **Empréstimo com Garantia**:
  - Concedido se o salário do cliente for ≤ R$ 3.000.
  - Concedido se o salário estiver entre R$ 3.000 e R$ 5.000, o cliente tiver menos de 30 anos e residir em São Paulo (SP).

Os dados de entrada são fornecidos em formato JSON, contendo informações do cliente e tipos de empréstimo com suas taxas de juros.

## Tecnologias Utilizadas
- **Linguagem**: Java
- **Ferramentas**: intellij

## Como Funciona
O programa processa os dados do cliente (salário, idade, localização) e aplica as regras de concessão de empréstimos. A lógica é dividida em:
- **Entities**: Define as estruturas de dados (`Customer`, `Loan`) e enums (`LoanType`).
- **DTO**: Objetos de transferência de dados para entrada e saída.
- **Services**: Contém a lógica de negócio para avaliar as condições de empréstimo.
- **Controllers**: Orquestra a entrada de dados e a chamada ao serviço.
- **Exceptions**: Trata erros específicos, como dados inválidos.

### Exemplo de Entrada
```json
{
  "customer": {
    "salary": 4000,
    "age": 25,
    "location": "SP"
  },
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    },
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}
```

### Exemplo de Saída
```json
[
  {
    "type": "PERSONAL",
    "interest_rate": 4
  },
  {
    "type": "GUARANTEED",
    "interest_rate": 3
  }
]
```

## Como Executar
1. Clone este repositório:
   ```bash
   git clone [URL do repositório]
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd loan-challenge
   ```

## Estrutura do Projeto
```
loan-challenge/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/danielnaiff/loans/
│   │   │   │   ├── controllers/
│   │   │   │   │   └── LoanController.java
│   │   │   │   ├── services/
│   │   │   │   │   └── LoanService.java
│   │   │   │   ├── exceptions/
│   │   │   │   │   └── LoanEligibilityException.java
│   │   │   │   ├── entities/
│   │   │   │   │   ├── dto/
│   │   │   │   │   │   ├── CustomerRequestDTO.java
│   │   │   │   │   │   └── CustomerLoansResponseDTO.java
│   │   │   │   │   ├── enum/
│   │   │   │   │   │   └── LoanType.java
│   │   │   │   │   ├── Customer.java
│   │   │   │   │   └── Loan.java
│   │   │   └── Main.java
│   └── test/
│       ├── java/
│       │   ├── com/danielnaiff/loans/
│       │   │   └── LoanervationsServiceTest.java
├── README.md
```

## Aprendizados
Ao resolver este desafio, pratiquei:
- Organização de código em uma arquitetura modular com separação de responsabilidades.
- Uso de DTOs e enums para tipagem forte e clareza no modelo de dados.
- Tratamento de erros com exceções personalizadas.
- Implementação de testes unitários com JUnit 5 para validar a lógica de negócio.
- Aplicação de lógica condicional em regras de negócio financeiras.

## Possíveis Melhorias
- Adicionar validação de entrada mais robusta (ex.: verificar se o JSON contém todos os campos obrigatórios).
- Criar uma interface CLI ou API REST para facilitar a interação com o sistema.

## Referências
- Desafio original: [backend-br/desafios - Concessão de Empréstimos](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md)
- Repositório do desafio: [backend-br/desafios](https://github.com/backend-br/desafios)

## Contato
Se você tiver sugestões ou quiser discutir sobre o desafio, sinta-se à vontade para me contatar pelo LinkedIn: www.linkedin.com/in/daniel-naiff-a89092283 ou por e-mail: danielnaiff344@gmail.com.