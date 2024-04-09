package Entities;

import java.text.CharacterIterator;

public class MaiorIgual extends AFD{
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '=' || codigo.current() == '>') {
			String maiorIgual = readMaiorIgual(codigo);
			if(endMaiorIgual(codigo)) {
				if(maiorIgual.equals(">="))
					return new Token("MAIORIGUAL", maiorIgual);
				}
			}
		
		
		return null;
	}
	
	public String readMaiorIgual(CharacterIterator codigo) {
		String maiorIgual = "";
		
		while(codigo.current() == '=' || codigo.current() == '>') {
			maiorIgual += codigo.current();
			codigo.next();
		}
		return maiorIgual;
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
				codigo.current() == '<' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() != '=' ||
				codigo.current() != '>' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
