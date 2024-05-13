package Entities;

import java.text.CharacterIterator;

public class Texto extends AFD{
	
	@Override
	public Token evaluate(CharacterIterator codigo) {
		if(Character.isLetter(codigo.current()) || Character.isDigit(codigo.current()) || codigo.current() == '"') {
			String texto = readTexto(codigo);
				
			if(endTexto(codigo)) {
				return new Token("TEXTO", texto);
			}
		}
		return null;
	}
		
	private String readTexto(CharacterIterator codigo) {
		String texto = "";
		if(codigo.current() == '"') {
			texto += codigo.current();
			codigo.next();
			while(codigo.current() != '"') {
				texto += codigo.current();
				codigo.next();
			}
			texto += codigo.current();
			codigo.next();
		}
		
		return texto;
	}
		
	private boolean endTexto(CharacterIterator codigo) {
		return  codigo.current() == ' ' ||
				codigo.current() == '-' ||
				codigo.current() == '+' ||
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

