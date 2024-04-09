package Entities;

import java.text.CharacterIterator;

public class ID extends AFD{
	
	@Override
	public Token evaluate(CharacterIterator codigo) {
		if(Character.isLetter(codigo.current()) || Character.isDigit(codigo.current()) || codigo.current() == '_') {
			String id = readId(codigo);
				
			if(endId(codigo)) {
				return new Token("ID", id);
			}
		}
		return null;
	}
		
	private String readId(CharacterIterator codigo) {
		String id = "";
		while(Character.isLetter(codigo.current()) || Character.isDigit(codigo.current()) || codigo.current() == '_') {
			id += codigo.current();
			codigo.next();
		}
		return id;
	}
		
	private boolean endId(CharacterIterator codigo) {
		return  codigo.current() == ' ' ||
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
