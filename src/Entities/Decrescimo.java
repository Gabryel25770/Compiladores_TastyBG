package Entities;

import java.text.CharacterIterator;

public class Decrescimo extends AFD{
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '-') {
			String decrescimo = readDecresimo(codigo);
			if(endDecrescimo(codigo)) {
				if(decrescimo.equals("--"))
					return new Token("DECRESCIMO", decrescimo);
				}
			}
		
		
		return null;
	}
	
	public String readDecresimo(CharacterIterator codigo) {
		String decrescimo = "";
		
		while(codigo.current() == '-') {
			decrescimo += codigo.current();
			codigo.next();
		}
		return decrescimo;
	}
	
	public boolean endDecrescimo(CharacterIterator codigo) {
		return codigo.current() == ' ' ||
				codigo.current() == '+' ||
				codigo.current() != '-' ||
				codigo.current() == '*' ||
				codigo.current() == '(' ||
				codigo.current() == ')' ||
				codigo.current() == '{' ||
				codigo.current() == '}' ||
				codigo.current() == '/' ||
				codigo.current() == '<' ||
				codigo.current() == '>' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() =='=' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
