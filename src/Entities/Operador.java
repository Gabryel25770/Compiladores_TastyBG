package Entities;

import java.text.CharacterIterator;

public class Operador extends AFD {
	
	@Override
	public Token evaluate(CharacterIterator codigo){
		switch(codigo.current()){
		case '+':
			codigo.next();
			return new Token("PLUS", "+");
		case '-':
			codigo.next();
			return new Token("MINUS", "-");
		case '*':
			codigo.next();
			return new Token("MULT", "*");
		case '/':
			codigo.next();
			return new Token("DIV", "/");
		case '(':
			codigo.next();
			return new Token("LPAREN", "(");
		case ')':
			codigo.next();
			return new Token("RPAREN", ")");
		case '=':
			codigo.next();
			return new Token("ATRIBUICAO", "=");
		case '{':
			codigo.next();
			return new Token("LCHAVE", "{");
		case '}':
			codigo.next();
			return new Token("RCHAVE", "}");
		case '>':
			codigo.next();
			return new Token("MAIOR", ">");
		case '<':
			codigo.next();
			return new Token("MENOR", "<");
		case ';':
			codigo.next();
			return new Token("FIM", ";");
		default:
			return null;
		}
	}

}
