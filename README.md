# Projeto Compiladores: TastyBG

## Descrição do Projeto
<p>Esse foi um projeto realizado por um grupo de quatro alunos, do sexto semestre de Ciências da Computação no Centro Universitário FEI, para a matéria de Compiladores. <br />
A ideia foi ensinar os conceitos por meio de um projeto prático aonde serão aplicados os ensinamentos aprendidos em aula. <br />
Essa linguagem foi desenvolvida em JAVA e traduzida também para JAVA, segue a documentação.</p>

<p align="center">
 <a href="#objetivo">Execução</a> •
 <a href="#roadmap">Instruções da linguagem</a> • 
 <a href="#tecnologias">Documentação</a> • 
 <a href="#contribuicao">Gramáticas</a> •
 <a href="#contribuicao">Exemplo de Código</a> •
 <a href="#licenc-a">Autores</a>  
</p>


## Execução
<p align="center">Primeiro desse ser criado um arquivo .txt aonde será desenvolvido seu código em TastyBG, depois deverá ser inserido o path desse arquivo no MainLexer.java antes da execução do próprio, igualmente ao path do arquivo de saída.</p>
<p align="center">Após a a execução do MainLexer.java, ele irá gerar um arquivo output.java que será compilado e executando com a execução do arquivo run.bat</p>


## Instruções da linguagem
<p align="center">-Não é necessário nenhuma identação, apenas para fins de organização.</p>
<p align="center">-Todo fim de comando deve conter ";" (ponto e vírgula), com exceção de estruturas de repetição ou condição.</p>
<p align="center">-Ao realizar um comentário, seguido de um "//", deve haver uma string entre aspas. Exemplo: (//"comentário").</p>

## Documentação
### Atribuição
<p align="center">Deve ser composta por uma palavra reservada referente ao valor da váriavel, um nome identificado da variável, um sinal de igual "=", um valor referente a atribuição e encerrado por pontoe vírgula ";".</p>
<p align="center">-As palavras disponíveis são:</p>

| Palavra Reservada |                      Tipo do valor                      |
|:-----------------:|:-------------------------------------------------------:|
|        numz       |          Números inteiros [..., -1, 0, 1, ...]          |
|        floq       |      Números flutuantes [..., -1.7, 0.0, 3.8, ...]      |
|        atoz       | Caracteres alfanuméricos ["olá", "senha123", "14", ...] |
|         io        |       Valores booleanos [real(true), barca(false)]      |

