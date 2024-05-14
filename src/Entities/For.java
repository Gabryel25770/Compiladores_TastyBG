package Entities;

import java.text.CharacterIterator;

public class For extends AFD{
		@Override
		public Token evaluate(CharacterIterator codigo) {
			String res = "roof";
			
			for(char c : res.toCharArray()){
				if(codigo.current() == c){
					codigo.next();
				}else{
					return null;
				}
			}
			
			if(codigo.current()== ' ' || codigo.current() == '\n' || codigo.current() == '(' || codigo.current() == ')' || codigo.current() == ';' || codigo.current() == CharacterIterator.DONE){
				return new Token("RESERVADA_FOR", "roof");
			}
			
			return null;
		}
}
