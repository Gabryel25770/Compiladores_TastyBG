package Entities;

import java.text.CharacterIterator;

public class Comparacao extends AFD{
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '=') {
			String comparacao = readComparacao(codigo);
			if(endComparacao(codigo)) {
				if(comparacao.equals("=="))
					return new Token("COMPARACAO", comparacao);
				}
			}
		
		
		return null;
	}
	
	public String readComparacao(CharacterIterator codigo) {
		String comparacao = "";
		
		while(codigo.current() == '=') {
			comparacao += codigo.current();
			codigo.next();
		}
		return comparacao;
	}
	
	public boolean endComparacao(CharacterIterator codigo) {
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
				codigo.current() == '>' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() != '=' ||
				codigo.current() == CharacterIterator.DONE;
	}
}
