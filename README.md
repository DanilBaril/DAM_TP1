# Trabalho 1 — DAM_TP1

Curso: Licenciatura em Engenharia Informática e Multimédia (LEIM)
Aluno: a51812
Data: Março 2026
URL do Repositório: https://github.com/DanilBaril/DAM_TP1

---

## 1. Introdução

Este trabalho corresponde às secções 2 e 6 do Tutorial 1 de Desenvolvimento de
Aplicações Móveis. O objetivo é aprender os fundamentos da linguagem Kotlin,
nomeadamente tipos básicos, controlo de fluxo, classes e objetos, através da
resolução de exercícios práticos em IntelliJ IDEA.

## 2. Visão Geral do Sistema

O projeto é composto por dois grupos de exercícios:

**Secção 2 — Getting Started with Kotlin:** três exercícios de consola que
exploram arrays, expressões when, exceções, templates de strings e sequências.

**Secção 6 — Virtual Library:** implementação de um sistema de gestão de biblioteca
virtual com programação orientada a objetos, incluindo herança, polimorfismo,
getters e setters customizados, métodos abstratos e companion objects.

## 3. Arquitetura e Design

O projeto foi criado em IntelliJ IDEA com Maven e está organizado em pacotes:
```
src/main/kotlin/
└── org/example/dam/
    ├── exer_1/
    │   └── exer_1.kt
    ├── exer_2/
    │   └── exer_2.kt
    ├── exer_3/
    │   └── exer_3.kt
    └── virtual_library/
        ├── Book.kt
        ├── DigitalBook.kt
        ├── PhysicalBook.kt
        ├── Library.kt
        ├── LibraryMember.kt
        └── Main.kt
```

## 4. Implementação

### Exercício 1 — Primeiros 50 quadrados perfeitos
Implementado de três formas diferentes:
- `ex1a()` — usando `IntArray` com lambda no construtor
- `ex1b()` — usando range `(1..50)` e `map()`
- `ex1c()` — usando `Array` com lambda no construtor

### Exercício 2 — Calculadora em consola
Calculadora que lê dois inteiros e uma operação do utilizador. Utiliza ciclos
`do-while` para validar os inputs, garantindo que apenas valores válidos são
aceites. A expressão `when` trata cada operação e as exceções tratam casos de
erro como divisão por zero. O resultado é apresentado em decimal, hexadecimal
e booleano.

Operações suportadas: `+`, `-`, `*`, `/`, `and`, `or`, `not`, `shl`, `shr`

### Exercício 3 — Simulação de saltos de bola
Usa `generateSequence` para modelar as alturas dos saltos a partir de 100 metros,
com cada salto a atingir 60% da altura anterior. A sequência filtra valores
abaixo de 1 metro com `takeWhile` e está limitada a 15 saltos com `take`.

### Virtual Library — Classe Book
Classe abstrata base com as propriedades `title`, `author`, `publicationYear`
e `availableCopies`. O getter de `publicationYear` classifica os livros em
"Classic" (antes de 1980), "Modern" (1980-2010) ou "Contemporary" (após 2010).
O setter de `availableCopies` impede valores negativos. O bloco `init` imprime
uma mensagem ao criar cada livro.

### Virtual Library — DigitalBook e PhysicalBook
Subclasses de `Book` que implementam o método abstrato `getStorageInfo()`:
- `DigitalBook` inclui `fileSize` e `format`
- `PhysicalBook` inclui `weight` e `hasHardcover`

Ambas fazem override de `toString()` para incluir a informação de armazenamento.

### Virtual Library — Library
Gere uma coleção de livros com os métodos `addBook()`, `borrowBook()`,
`returnBook()`, `showBooks()` e `searchByAuthor()`. Inclui um companion object
que conta o total de livros criados em todas as instâncias. O `borrowBook()`
imprime um aviso quando o último exemplar é emprestado.

### Virtual Library — LibraryMember
Data class com `name`, `membershipId` e uma lista mutável de títulos emprestados.

## 5. Testes e Validação

Testes manuais realizados executando o `main()` de cada exercício:

**Exercício 1:**
- As três implementações produzem o mesmo resultado ✓
- O array começa em 1 e termina em 2500 ✓

**Exercício 2:**
- Operações aritméticas básicas funcionam corretamente ✓
- Divisão por zero lança exceção tratada ✓
- Input inválido é rejeitado pelo ciclo de validação ✓
- Resultado apresentado em decimal, hexadecimal e booleano ✓

**Exercício 3:**
- A sequência começa em 60.0 (primeiro salto após os 100m iniciais) ✓
- A sequência termina antes de atingir valores abaixo de 1 metro ✓
- Nunca ultrapassa 15 valores ✓

**Virtual Library:**
- Output corresponde ao esperado no documento ✓
- Aviso de fora de stock aparece na posição correta ✓
- Companion object conta corretamente o total de livros ✓

Limitações conhecidas:
- O exercício 3 usa `takeWhile` em vez de `filter`, o que pode diferir
  ligeiramente do enunciado mas produz o resultado correto
- A calculadora não suporta números decimais

## 6. Instruções de Utilização

Requisitos:
- IntelliJ IDEA com suporte a Kotlin e Maven
- JDK 17 ou superior
- Kotlin 1.9 ou superior

Passos para executar:
1. Clonar o repositório: `git clone https://github.com/DanilBaril/DAM_TP1`
2. Abrir o projeto no IntelliJ IDEA
3. Para cada exercício, abrir o ficheiro correspondente e executar a função `main()`
4. Para a Virtual Library, executar o `Main.kt` na pasta `virtual_library`

---

# Processo de Desenvolvimento

## 12. Controlo de Versão e Histórico de Commits

O projeto foi desenvolvido de forma incremental com commits em cada etapa:
- Inicialização do projeto com estrutura Maven
- Criação da estrutura de pacotes
- Implementação do exercício 1
- Implementação do exercício 2
- Implementação do exercício 3
- Adição da classe Book com propriedades base
- Adição do getter e setter customizados à classe Book
- Adição das subclasses DigitalBook e PhysicalBook
- Adição da classe Library com métodos base
- Adição do companion object à Library
- Adição da data class LibraryMember
- Adição do Main com o exemplo completo

## 13. Dificuldades e Lições Aprendidas

No exercício 2, a maior dificuldade foi garantir que os inputs inválidos fossem
rejeitados de forma limpa sem o programa crashar, o que foi resolvido com ciclos
`do-while` e `toIntOrNull()`.

No exercício 3, foi necessário perceber bem a diferença entre `filter` e
`takeWhile` — o `takeWhile` para na primeira vez que a condição falha, enquanto
o `filter` continua a percorrer toda a sequência.

Na Virtual Library, o maior desafio foi perceber a ordem correta das operações
no `borrowBook()` para que o aviso de fora de stock aparecesse após a mensagem
de sucesso e não antes, já que o setter era acionado ao decrementar o valor.
Isso foi resolvido movendo o aviso para o `borrowBook()` em vez de o ter no setter.

## 14. Melhorias Futuras

- Adicionar testes unitários para a Virtual Library
- Suportar números decimais na calculadora
- Adicionar persistência de dados na Library (guardar/carregar de ficheiro)
- Adicionar interface de consola interativa para a Library

---

## 15. Declaração de Utilização de IA

Ferramentas de IA utilizadas: Claude (claude.ai)
Utilização: a IA foi utilizada exclusivamente como ferramenta de aprendizagem,
para esclarecer dúvidas sobre conceitos como `generateSequence`, `takeWhile`,
getters e setters em Kotlin, classes abstratas e companion objects.
Nenhum código foi gerado ou copiado diretamente de ferramentas de IA.
Todo o código foi escrito pelo aluno.