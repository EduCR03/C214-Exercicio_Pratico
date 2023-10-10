# Exercício Prático C214 - Testes Unitários

### Integrantes:

* Douglas Brandão de Souza - GEC - 1730
* Eduardo Costa Resende - GES - 200


## Visão Geral BuscaProfessor

O Sistema de Gerenciamento de Professores é um código simples em Java projetado para gerenciar informações sobre professores. Este sistema fornece funcionalidades básicas para armazenar e recuperar informações sobre professores, como seus nomes, horários de atendimento e locais de trabalho.

## Visão Geral JsonPage

O JsonPage é um código Java que gera páginas JSON com informações de professores. O JsonPage permite criar JSON com detalhes de professores, como nomes, horários, períodos e salas, além de salvar o JSON em arquivos para uso posterior. É uma ferramenta útil para desenvolvedores que precisam gerar JSON de forma eficiente e prática.

## Estrutura do Projeto

O projeto é composto pelos seguintes componentes:

Classe Professor: Representa um professor e armazena suas informações, incluindo ID, nome, horário de atendimento, local de trabalho e prédio(s) aos quais estão associados.

Interface BuscaService: Define o contrato para pesquisar e recuperar informações de professores. Inclui métodos para verificar se um professor existe, recuperar detalhes de um professor por ID e listar todos os professores.

Classe BuscaProfessor: Implementa a interface BuscaService e fornece funcionalidades para verificar a existência de um professor, buscar um professor por ID e listar todos os professores.

Classe JsonPge: Consiste em um conjunto de funcionalidades que permitem a criação e armazenamento de objetos JSON a partir de informações de um professor.

## Testes

Para a classe BuscaProfessor, o objetivo dos testes é verificar o comportamento do código que gerencia professores. Isso inclui a busca de informações, verificação de existência, e garantir que os dados retornados estejam corretos.

Para a classe JsonPage, o objetivo dos testes é verificar o comportamento do código que gera páginas JSON com informações de professores. Isso inclui criar o JSON, salvar em um arquivo e garantir que os dados gerados estejam corretos.

Os testes ajudam a confirmar se o sistema funciona corretamente em diferentes cenários.

### Para executar os testes, siga estas etapas:

Certifique-se de que você está na pasta "exercicio" onde os arquivos de teste estão localizados.

Abra um terminal ou prompt de comando.

Execute o seguinte comando Maven para limpar e executar os testes:

```bash
mvn clean test
```

## Bibliotecas Usadas

Este projeto de teste utiliza as seguintes bibliotecas:

JUnit: É uma estrutura de teste unitário para a linguagem Java. É amplamente utilizado para escrever e executar testes automatizados.

Mockito: É uma biblioteca de teste para Java que permite criar objetos fictícios (ou "mocks") de classes e interfaces. Isso é útil para isolar o código que está sendo testado de suas dependências externas.

