# Projeto Compiladores: TastyBG

## Descrição do Projeto
<p> Esse foi um projeto realizado por um grupo de quatro alunos, do sexto semestre de Ciências da Computação no Centro Universitário FEI, para a matéria de Compiladores.</p>
<p> A ideia foi ensinar os conceitos por meio de um projeto prático aonde serão aplicados os ensinamentos aprendidos em aula.</p>
<p> Essa linguagem foi desenvolvida em JAVA e traduzida também para JAVA, segue a documentação.</p>

<br/>

<p align="center">
 <a href="https://github.com/Gabryel25770/Compiladores_TastyBG?tab=readme-ov-file#execu%C3%A7%C3%A3o">Execução</a> •
 <a href="#roadmap">Instruções da linguagem</a> • 
 <a href="#tecnologias">Documentação</a> • 
 <a href="#contribuicao">Gramáticas</a> •
 <a href="#contribuicao">Exemplo de Código</a> •
 <a href="#licenc-a">Autores</a>  
</p>

<br/>
<br/>

## Execução
<p>Primeiro desse ser criado um arquivo .txt aonde será desenvolvido seu código em TastyBG, depois deverá ser inserido o path desse arquivo no MainLexer.java antes da execução do próprio, igualmente ao path do arquivo de saída.</p>
<p>Após a a execução do MainLexer.java, ele irá gerar um arquivo output.java que será compilado e executando com a execução do arquivo run.bat</p>

<br/>
<br/>

## Instruções da linguagem
<p>- Não é necessário nenhuma identação, apenas para fins de organização.</p>
<p>- Todo fim de comando deve conter ";" (ponto e vírgula), com exceção de estruturas de repetição ou condição.</p>
<p>- Ao realizar um comentário, seguido de um "//", deve haver uma string entre aspas. Exemplo: (//"comentário").</p>

<br/>
<br/>

## Documentação
### Tokens
#### Expressão

| Token |                     Significado                      |
|:-----------------:|:-------------------------------------------------------:|
|        =       |          Atribuição          |
|        +       |      Soma     |
|        -       | Subtração |
|         /        |       Divisão      |
|         *        |       Multiplicação      |

<p>- Exemplo de expressão:</p>

| Exemplo |
|:-----------------:|
|        varnum = (3+4)/7;       |

<br/>

#### Comparação

| Token |                     Significado                      |
|:-----------------:|:-------------------------------------------------------:|
|        ==       |          Igual          |
|        <>       |      Diferente     |
|        <       |      Menor     |
|        >       |      Maior     |
|        >=       | Maior Igual |
|         <=        |       Menor Igual      |
|         nenom        |       Comparação String      |

<p>- Exemplo de comparação:</p>

| Exemplo em uma estrutura If (que será ensinada em breve) |
|:-----------------|
|        oz(varnum < 3){<br>varboo = barca;<br>}       |
|        oz(varnum nenom "ola"){<br>varboo = real;<br>}       |

<br/>

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

<br/>

### Inputs e Prints
#### Input
<p>Deve ser composto primeiramente por um ID, podendo conter uma atribuição, um sinal de igua "=", depois pela palavra reservada "caption", seguido to tipo da variável que deseja recer, e pra finalizar um abre e fecha parênteses "()". </p>
<p>- Aqui vai dois exemplo:</p>

|           Exemplo apenas com atribuição          |          Exemplo com Declaração          |
|:------------------------------------------------:|:----------------------------------------:|
|            vartext = caption atoz ();            |       numz varnum = caption numz ();     |

<br/>

#### Print
<p>Deve ser composto pela palavra reservada "receba", parênteses aberto "(", um valor (numero, booleano, texto ou um ID), parênteses fechado ")", e finalizado com um ponto e vírgula ";".</p>

<p>- Aqui vai alguns exemplo:</p>

|           Exemplos          |
|:---------------------------:|
|          receba(2);         |
|     receba("Parabéns!");    |
|       receba(varboo);       |

<br/>

### If, Else If e Else
#### If
<p>Deve ser composta pela palavra reservada "oz", parênteses aberto "(", uma condição (ID ou valor, sinal de comparação, mais um ID ou valor), parêntes fechado ")", chaves aberta "{", estrutura de código, e finalizado por uma chaves fechada "}".</p>
<p>- Exemplo de implementação:</p>

|                    Exemplo                    	|
|:---------------------------------------------	|
| oz(varnum == 3){<br>//"Trecho de código"<br>} 	|

<br/>

#### Else If
<p>Semelhante a sintaxe do "If", porém a palavra reservada será "ozak" dessa vez. <br /> Deve haver ao menos um "If" antes de um "Else If", e pode haver outros "Else Ifs", um "Else" ou nada depois.</p>

<p>- Exemplos de implementações:</p>

|           Exemplo sem nada após          |          Exemplo com mais de um "Else If"          |
|:------------------------------------------------|:----------------------------------------|
|            oz(varnum == 3){<br>//"Trecho de código"<br>}ozak(varnum == 4){<br>//"Trecho de código"<br>}          |       oz(varnum == 3){<br>//"Trecho de código"<br>}ozak(varnum == 4){<br>//"Trecho de código"<br>}ozak(varnum == 5){<br>//"Trecho de código"<br>}     |

<br/>

#### Else
<p>Semelhante a sintaxe dos dois anteriores, a palavra reservada é "zak" e não é necessário condição.</p>
<p>Deve vir após um "If" ou um "Else If", podendo haver só uma repetição, simbolizando o fim da estrutura de repetição.</p>

<p>- Exemplo de implementação:</p>

|          Exemplo          |
|:----------------------------------------|
|       oz(varnum == 3){<br>//"Trecho de código"<br>}ozak(varnum == 4){<br>//"Trecho de código"<br>}zak{<br>//"Trecho de código<br>}     |

<br/>

### For
<p>Deve ser composto pela palavra reservada "roof", parênteses aberto "(", uma declaração como já foi ensinado (não podendo haver inputs nessa declaração), ponto e vírgula ";", uma condição, mais um ponto e vírgula, uma expressão matemática(geralmente um incremento ou decremento), parênteses fechado ")", chaves aberta "{", seu trecho de código, e finalizado com chaves fechada "}".</p>

<p>- Exemplo de implementação:</p>

|                    Exemplo                    	|
|:---------------------------------------------	|
| roof(numz i = 0; i < 10; i = i + 1){<br>//"Trecho de código"<br>} 	|

<br/>

### While
<p>Deve ser composto pela palavra reservada "tiziu", parênteses aberto "(", uma condição, parênteses fechado ")", chaves aberta "{", seu trecho de código, e finalizado com chaves fechada "}".</p>

<p>- Exemplo de implementação:</p>

|                    Exemplo                    	|
|:---------------------------------------------	|
| tiziu(i < 10){<br>//"Trecho de código"<br>} 	|

<br/>
<br/>

## Grámatica

<p>Nas grámaticas, tome nota que as funções estarão em <strong>negrito</strong> e os terminais estarão "entre aspas".</p>
<br/>
<p><Strong>Recurção</Strong> →	<Strong>If</Strong> | <Strong>Declaração</Strong> | <Strong>For</Strong> | <Strong>While</Strong> | <Strong>Print</Strong> | <Strong>Comentário</Strong> | $ | ε </p>
<p><Strong>If</Strong> → "oz" "(" <strong>Condição</strong> ")" "{" <strong>Recurção</strong> "}" <Strong>IfComplemento</Strong> </p>
<p> <Strong>IfComplemento</Strong> → <strong>ElseIf</strong> <Strong>IfComplemento</Strong> | <strong>Else</strong> <Strong>IfComplemento</Strong> | ε</p>
<p><strong>ElseIf</strong> → "ozak" "(" <strong>Condição</strong> ")" "{" <strong>Recurção</strong> "}"</p>
<p><strong>Else</strong> → "zak" "{" <strong>Recursção</strong> "}"</p>
<p><strong>Condição</strong> → "ID" (<strong>Operador</strong> <strong>Valor</strong> | <strong>OperadorString</strong>) </p>
<p><strong>OperadorString</strong> → "nenom" <strong>ValorOperadorString</strong></p>
<p><strong>ValorOperadorString</strong> → "ID" | "String"</p>
<p><strong>Operador</strong> → ">" | "<" | "==" | ">=" | "<=" | "<>"</p>
<p><strong>Valor</strong> → ("ID" | "Numero" | "Flutuante" | "String" | "Boolean" | "(" <strong>Valor</strong> ")") <strong>ValorComplemento</strong></p>
<p><strong>ValorComplemento</strong> → <strong>OperadorMatemático</strong> <Strong>Valor</Strong></p>
<p><strong>OperadorMatemático</strong> → "+" | "/" | "*" | "-"</p>
<p><strong>Declaração</strong> → <strong>Tipos</strong> <strong>Expressão</strong></p>
<p><strong>Tipos</strong> → "io" | "numz" | "floq" | "atoz"</p>
<p><strong>Expressão</strong> → "ID" <strong>ValorNaExpressão</strong> ";"</p> 
<p><strong>ValorNaExpressão</strong> → "=" (<strong>Valor</strong> | <strong>Input</strong>) | "++" | "--"</p>
<p><strong>Input</strong> → "caption" <strong>Tipos</strong> "()"</p>
<p><strong>For</strong> → "roof" "(" <strong>Declaração</strong> ";" <strong>Condição</strong> ";" <Strong>Expressão</Strong> ")" "{" <strong>Recursão</strong> "}"</p>
<p><strong>While</strong> → "tiziu" "(" <strong>Condição</strong> ")" "{" <strong>Recursão</strong> "}"</p>
<p><strong>Print</strong> → "receba" "(" <strong>Valor</strong> ")" ";" </p>
<p><strong>Comentário</strong> → "//" "String"</p>

<br/>
<br/>

##Exemplo de Código 

<p>//"Exemplo"<br/>
<br/>
atoz eba = caption atoz();<br/>
numz boo = 1;<br/>
<br/>
oz(eba nenom "oi"){<br/>
	&emsp; boo = 2;<br/>
}ozak(eba nenom "tchau"){<br/>
	&emsp; boo = 3;<br/>
}ozak(eba nenom "sla"){<br/>
	&emsp; boo = 4;<br/>
}zak{<br/>
	&emsp; boo = (5+11)/2;<br/>
}<br/>
<br/>
roof(numz i = 0; i < 10; i++){<br/>
	&emsp; boo++;<br/>
}<br/>
<br/>
io var = barca;<br/>
tiziu(var <> real){<br/>
	&emsp; boo = boo + 2 - 4;<br/>
	&emsp; var = real;<br/>
}<br/>
<br/>
receba(boo);<br/>
</p>

<br/>
<br/>

##Autores

| Nome |                     RA                      |
|:-----------------:|:-------------------------------------------------------:|
|        Gabryel Lourenço Maciel de Morais       |          22.221.021-3          |
|        Giovanna Borges Tamagnini       |      2.221.016-3     |
|        Flavio Eugenio de Oliveira Neto       | 22.221.027-0 |
|         Thiago Ayres Kimura        |       22.221.      |








