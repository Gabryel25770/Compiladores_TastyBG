package Entities;

import java.text.CharacterIterator;

public class MenorIgual extends AFD{
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '=' || codigo.current() == '<') {
			String menorIgual = readMaiorIgual(codigo);
			if(endMaiorIgual(codigo)) {
				if(menorIgual.equals("<="))
					return new Token("MENORIGUAL", menorIgual);
				}
			}
		
		
		return null;
	}
	
	public String readMaiorIgual(CharacterIterator codigo) {
		String menorIgual = "";
		
		while(codigo.current() == '=' || codigo.current() == '<') {
			menorIgual += codigo.current();
			codigo.next();
		}
		return menorIgual;
	}
	
	public boolean endMaiorIgual(CharacterIterator codigo) {
		return codigo.current() == ' ' ||
				codigo.current() == '+' ||
				codigo.current() == '-' ||
				codigo.current() == '*' ||
				codigo.current() == '(' ||
				codigo.current() == ')' ||
				codigo.current() == '{' ||
				codigo.current() == '}' ||
				codigo.current() == '/' ||
				codigo.current() == '>' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() != '=' ||
				codigo.current() != '<' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
