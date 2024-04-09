package Entities;

import java.text.CharacterIterator;

public class If extends AFD{
		@Override
		public Token evaluate(CharacterIterator codigo) {
			String res = "oz";
			
			
			for(char c : res.toCharArray()){
				if(codigo.current() == c){
					codigo.next();
				}else{
					return null;
				}
			}
			if(codigo.current()== ' ' || codigo.current() == '\n' || codigo.current() == ';' || codigo.current() == CharacterIterator.DONE ){
				return new Token("RESERVADA_IF", "oz");
			}
			
			return null;
		}
}
