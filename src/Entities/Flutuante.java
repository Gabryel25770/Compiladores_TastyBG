package Entities;

import java.text.CharacterIterator;

public class Flutuante extends AFD{
	
	@Override
	public Token evaluate(CharacterIterator codigo) {
		if(Character.isDigit(codigo.current()) || codigo.current() == '.') {
			String number = readNumber(codigo);
			
			if(endNumber(codigo)) {
				return new Token("FLUTUANTE", number);
			}
		}
		return null;
	}
	
	private String readNumber(CharacterIterator codigo) {
		String number = "";
		int count = 0;
		while (Character.isDigit(codigo.current()) || codigo.current() == '.') {
			if(codigo.current() == '.') {
				count++;
			}
			number += codigo.current();
			codigo.next();
		}
		if(count == 1) {
			return number;
		}
		return null;
	}
	
	private boolean endNumber(CharacterIterator codigo) {
		return codigo.current() != '/' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
