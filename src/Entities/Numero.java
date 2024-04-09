package Entities;

import java.text.CharacterIterator;

public class Numero extends AFD{
	
	@Override
	public Token evaluate(CharacterIterator codigo) {
		if(Character.isDigit(codigo.current())) {
			String number = readNumber(codigo);
			
			if(endNumber(codigo)) {
				return new Token("NUMERO", number);
			}
		}
		return null;
	}
	
	private String readNumber(CharacterIterator codigo) {
		String number = "";
		while (Character.isDigit(codigo.current())) {
			number += codigo.current();
			codigo.next();
		}
		return number;
	}
	
	private boolean endNumber(CharacterIterator codigo) {
		return codigo.current() == ' ' ||
				codigo.current() == '+' ||
				codigo.current() == '-' ||
				codigo.current() == '*' ||
				codigo.current() == '/' ||
				codigo.current() == '(' ||
				codigo.current() == ')' ||
				codigo.current() == '{' ||
				codigo.current() == '}' ||
				codigo.current() == '=' ||
				codigo.current() == '<' ||
				codigo.current() == '>' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
