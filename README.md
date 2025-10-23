# CPF-Checker

Validador simples de CPF em Java.

Este repositório contém código em Java para validar números de CPF (Cadastro de Pessoas Físicas) brasileiros. O objetivo é permitir validação correta de formato e dígitos verificadores do CPF, servindo tanto como biblioteca quanto como utilitário de linha de comando.

## Índice

- [Funcionalidades](#funcionalidades)
- [Como funciona a validação](#como-funciona-a-validação)
- [Requisitos](#requisitos)
- [Instalação / Compilação](#instalação--compilação)
- [Uso](#uso)
  - [Linha de comando (exemplo)](#linha-de-comando-exemplo)
  - [Uso como biblioteca (exemplo Java)](#uso-como-biblioteca-exemplo-java)
- [Exemplos](#exemplos)
- [Testes](#testes)
- [Contribuição](#contribuição)
- [Melhorias sugeridas](#melhorias-sugeridas)
- [Licença](#licença)
- [Contato](#contato)

## Funcionalidades

- Remove caracteres não numéricos (pontos, traços, espaços).
- Verifica se o CPF tem 11 dígitos.
- Rejeita sequências inválidas como `00000000000`, `11111111111`, etc.
- Calcula os dígitos verificadores (os dois últimos dígitos) e verifica a consistência.

## Como funciona a validação

Resumo do algoritmo padrão para validar CPF:

1. Limpar a entrada removendo caracteres que não sejam dígitos.
2. Verificar se, após limpeza, existem exatamente 11 dígitos.
3. Rejeitar CPFs com todos os dígitos iguais (ex.: `00000000000`, `11111111111`), pois são inválidos.
4. Para calcular o 1º dígito verificador:
   - Multiplicar os 9 primeiros dígitos pelos pesos 10 a 2, somar os resultados.
   - Calcular o resto da divisão por 11.
   - Se resto < 2 -> dígito = 0; caso contrário dígito = 11 - resto.
5. Para o 2º dígito verificador:
   - Multiplicar os 10 primeiros dígitos (os 9 iniciais + 1º dígito calculado) pelos pesos 11 a 2 e repetir o mesmo cálculo.
6. Comparar os dígitos calculados com os dois últimos dígitos do CPF informado.

Este procedimento é o padrão usado pela Receita Federal e por validações comuns em sistemas brasileiros.

## Requisitos

- Java 8+ (ou versão superior compatível)
- Se você usa um gerenciador de build:
  - Maven ou Gradle (instruções abaixo se houver arquivos de build no repositório)

## Instalação / Compilação

Opções genéricas — ajuste conforme a estrutura do projeto.

1) Se o projeto usa Maven (há um `pom.xml`):
```bash
mvn -q -DskipTests package
```
O artefato ficará em `target/` (ex.: `target/cpf-checker.jar`).

2) Compilação manual (simples, sem build tool):
```bash
# supondo código em src/ e classe principal opcional
javac -d out $(find src -name "*.java")
# empacotar em jar executável (se houver uma classe Main)
jar cfe cpf-checker.jar com.exemplo.Main -C out .
```

Substitua `com.exemplo.Main` pela classe que contém o método `public static void main(String[] args)` caso exista.

## Uso

Linha de comando (exemplo genérico)
```bash
# se houver jar executável
java -jar cpf-checker.jar 123.456.789-09
# ou
java -jar cpf-checker.jar 12345678909
```

Saída esperada (exemplo):
```
CPF: 123.456.789-09 -> Inválido
```

Uso como biblioteca (exemplo em Java)
```java
// Exemplo hipotético — ajuste para o nome real da classe no repositório
public class Exemplo {
    public static void main(String[] args) {
        String cpf = "123.456.789-09";
        boolean valido = CPFValidator.isValid(cpf); // método de exemplo
        System.out.println(cpf + " -> " + (valido ? "Válido" : "Inválido"));
    }
}
```

Caso as classes no repositório tenham nomes diferentes, substitua `CPFValidator.isValid` pelo método correspondente.

## Exemplos

- Entrada: `111.444.777-35` -> Saída: `Válido`
- Entrada: `123.456.789-09` -> Saída: `Inválido`
- Entrada: `00000000000` -> Saída: `Inválido` (sequência repetida)

## Testes

Se houver suíte de testes (JUnit/TestNG), rode:
- Maven:
```bash
mvn test
```

Se não houver testes no repositório, é recomendado adicionar casos unitários cobrindo:
- CPFs válidos conhecidos
- CPFs inválidos (dígitos errados)
- Entradas com formatação (pontos/traços)
- Entradas com caracteres não numéricos
- Sequências repetidas

## Contribuição

Contribuições são bem-vindas! Sugestões:
- Adicionar suporte a formatos internacionais (CNPJ, CPF com máscara alternativa).
- Melhorar cobertura de testes.
- Fornecer mensagens de erro mais detalhadas (ex.: "tamanho incorreto", "dígito verificador inválido").

Fluxo sugerido:
1. Fork do repositório.
2. Criar branch com feature/bugfix.
3. Abrir Pull Request descrevendo a mudança e incluindo testes quando aplicável.

## Melhorias sugeridas

- Adicionar validação com mensagens de erro específicas.
- Criar módulo CLI com opções (--format, --batch-file).
- Expor validação como uma pequena API HTTP para integração rápida.

## Contato

Autor: Thiago4596
https://github.com/Thiago4596
