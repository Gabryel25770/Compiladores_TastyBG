package Entities;

import java.text.CharacterIterator;

public class Diferente extends AFD{
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '<' || codigo.current() == '>') {
			String diferente = readDiferente(codigo);
			if(endDiferente(codigo)) {
				if(diferente.equals("<>"))
					return new Token("DIFERENTE", diferente);
				}
			}
		
		
		return null;
	}
	
	public String readDiferente(CharacterIterator codigo) {
		String diferente = "";
		
		while(codigo.current() == '<' || codigo.current() == '>') {
			diferente += codigo.current();
			codigo.next();
		}
		return diferente;
	}
	
	public boolean endDiferente(CharacterIterator codigo) {
		return codigo.current() == ' ' ||
				codigo.current() == '+' ||
				codigo.current() == '-' ||
				codigo.current() == '*' ||
				codigo.current() == '(' ||
				codigo.current() == ')' ||
				codigo.current() == '{' ||
				codigo.current() == '}' ||
				codigo.current() == '/' ||
				codigo.current() != '<' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() == '=' ||
				codigo.current() != '>' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
