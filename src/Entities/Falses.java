package Entities;

import java.text.CharacterIterator;

	public class Falses extends AFD{
		
		@Override
		public Token evaluate(CharacterIterator codigo) {
			String res = "barca";
		
			for(char c : res.toCharArray()){
				if(codigo.current() == c){
					codigo.next();
				}else{
					return null;
				}
			}
			if(codigo.current()== ' ' || codigo.current() == '\n' || codigo.current() == ';' || codigo.current() == CharacterIterator.DONE){
				return new Token("BOOLEAN_FALSE", "barca");
			}
			
			return null;
		}
}