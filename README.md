# Projeto Compiladores: TastyBG

## Descrição do Projeto
<p> Esse foi um projeto realizado por um grupo de quatro alunos, do sexto semestre de Ciências da Computação no Centro Universitário FEI, para a matéria de Compiladores.</p>
<p> A ideia foi ensinar os conceitos por meio de um projeto prático aonde serão aplicados os ensinamentos aprendidos em aula.</p>
<p> Essa linguagem foi desenvolvida em JAVA e traduzida também para JAVA, segue a documentação.</p>

<p align="center">
 <a href="https://github.com/Gabryel25770/Compiladores_TastyBG?tab=readme-ov-file#execu%C3%A7%C3%A3o">Execução</a> •
 <a href="#roadmap">Instruções da linguagem</a> • 
 <a href="#tecnologias">Documentação</a> • 
 <a href="#contribuicao">Gramáticas</a> •
 <a href="#contribuicao">Exemplo de Código</a> •
 <a href="#licenc-a">Autores</a>  
</p>


## Execução
<p>Primeiro desse ser criado um arquivo .txt aonde será desenvolvido seu código em TastyBG, depois deverá ser inserido o path desse arquivo no MainLexer.java antes da execução do próprio, igualmente ao path do arquivo de saída.</p>
<p>Após a a execução do MainLexer.java, ele irá gerar um arquivo output.java que será compilado e executando com a execução do arquivo run.bat</p>


## Instruções da linguagem
<p>- Não é necessário nenhuma identação, apenas para fins de organização.</p>
<p>- Todo fim de comando deve conter ";" (ponto e vírgula), com exceção de estruturas de repetição ou condição.</p>
<p>- Ao realizar um comentário, seguido de um "//", deve haver uma string entre aspas. Exemplo: (//"comentário").</p>

## Documentação
### Declaração
<p>Deve ser composta por uma palavra reservada referente ao valor da váriavel, um nome identificado da variável, um sinal de igual "=", um valor referente a atribuição e encerrado por pontoe vírgula ";".</p>
<p>- As palavras disponíveis são:</p>

| Palavra Reservada |                      Tipo do valor                      |
|:-----------------:|:-------------------------------------------------------:|
|        numz       |          Números inteiros [..., -1, 0, 1, ...]          |
|        floq       |      Números flutuantes [..., -1.7, 0.0, 3.8, ...]      |
|        atoz       | Caracteres alfanuméricos ["olá", "senha123", "14", ...] |
|         io        |       Valores booleanos [real(true), barca(false)]      |

<p>- Aqui vai alguns exemplo:</p>

|           Exemplos          |
|:---------------------------:|
|       numz varnum = 2;      |
|      floq varflo = 6.9;     |
| atoz vartext = "Boa noite!" |
|      io varboo = real;      |

<p>* Há casos em que a declaração pode ser feita junto a um input, mas isso será explicado daqui a pouco.</p>

### Inputs e Prints
#### Input
<p>Deve ser composto primeiramente por um ID, podendo conter uma atribuição, um sinal de igua "=", depois pela palavra reservada "caption", seguido to tipo da variável que deseja recer, e pra finalizar um abre e fecha parênteses "()". </p>
<p>- Aqui vai dois exemplo:</p>

|           Exemplo apenas com atribuição          |          Exemplo com Declaração          |
|:------------------------------------------------:|:----------------------------------------:|
|            vartext = caption atoz ();            |       numz varnum = caption numz ();     |

#### Print
<p>Deve ser composto pela palavra reservada "receba", parênteses aberto "(", um valor (numero, booleano, texto ou um ID), parênteses fechado ")", e finalizado com um ponto e vírgula ";".</p>

<p>- Aqui vai alguns exemplo:</p>

|           Exemplos          |
|:---------------------------:|
|          receba(2);         |
|     receba("Parabéns!");    |
|       receba(varboo);       |

### If, Else If e Else
#### If
<p>Deve ser composta pela palavra reservada "oz", parênteses aberto "(", uma condição (ID ou valor, sinal de comparação, mais um ID ou valor), parêntes fechado ")", chaves aberta "{", estrutura de código, e finalizado por uma chaves fechada "}".</p>
<p>- Exemplo de implementação:</p>

|                    Exemplo                    	|
|:---------------------------------------------	|
| oz(varnum == 3){<br>//"Trecho de código"<br>} 	|

#### Else If
<p>Semelhante a sintaxe do "If", porém a palavra reservada será "ozak" dessa vez. <br /> Deve haver ao menos um "If" antes de um "Else If", e pode haver outros "Else Ifs", um "Else" ou nada depois.</p>

<p>- Exemplos de implementações:</p>

|           Exemplo sem nada após          |          Exemplo com mais de um "Else If"          |
|:------------------------------------------------|:----------------------------------------|
|            oz(varnum == 3){<br>//"Trecho de código"<br>}ozak(varnum == 4){<br>//"Trecho de código"<br>}          |       oz(varnum == 3){<br>//"Trecho de código"<br>}ozak(varnum == 4){<br>//"Trecho de código"<br>}ozak(varnum == 5){<br>//"Trecho de código"<br>}     |






