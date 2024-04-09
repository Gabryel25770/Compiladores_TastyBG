package Entities;

import java.text.CharacterIterator;

public class Acrescimo extends AFD{
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '+') {
			String acrescimo = readAcresimo(codigo);
			if(endAcrescimo(codigo)) {
				if(acrescimo.equals("++"))
					return new Token("ACRESCIMO", acrescimo);
				}
			}
		
		
		return null;
	}
	
	public String readAcresimo(CharacterIterator codigo) {
		String acrescimo = "";
		
		while(codigo.current() == '+') {
			acrescimo += codigo.current();
			codigo.next();
		}
		return acrescimo;
	}
	
	public boolean endAcrescimo(CharacterIterator codigo) {
		return codigo.current() == ' ' ||
				codigo.current() != '+' ||
				codigo.current() == '-' ||
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
