package Entities;

import java.text.CharacterIterator;

//&& codigo.charAt(0).equals("/")

public class Comentarios extends AFD{
	
	@Override
	public Token evaluate(CharacterIterator codigo) {
		
		if(codigo.current() == '/') {
			String comentario = readComentario(codigo);
			if(endComentario(codigo)) {
				if(comentario.equals("//"))
					return new Token("COMENTARIO", comentario);
				}
			}
		
		
		return null;
	}
	
	public String readComentario(CharacterIterator codigo) {
		String comentario = "";
		
		while(codigo.current() == '/') {
			comentario += codigo.current();
			codigo.next();
		}
		return comentario;
	}
	
	public boolean endComentario(CharacterIterator codigo) {
		return codigo.current() == ' ' ||
				codigo.current() == '+' ||
				codigo.current() == '-' ||
				codigo.current() == '*' ||
				codigo.current() == '(' ||
				codigo.current() == ')' ||
				codigo.current() == '{' ||
				codigo.current() == '}' ||
				codigo.current() == '=' ||
				codigo.current() == '<' ||
				codigo.current() == '>' ||
				codigo.current() == ';' ||
				codigo.current() == '\n' ||
				codigo.current() != '/' ||
				codigo.current() == CharacterIterator.DONE;
	}
	
}
