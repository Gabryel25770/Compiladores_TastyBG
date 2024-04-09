package Entities;

import java.text.CharacterIterator;

public class Str extends AFD{
	
	@Override
	public Token evaluate(CharacterIterator codigo) {
		String res = "atoz";
		char[] list = {'/', '+', '=', '-', '*', '(', ')', '{', '}'};
		
		
		
		for(char c : res.toCharArray()){
			if(codigo.current() == c){
				codigo.next();
			}else{
				return null;
			}
		}
		if(codigo.current()== ' ' || codigo.current() == '\n' || codigo.current() == ';' || func(list, codigo.current())){
			return new Token("RESERVADA_STRING", "atoz");
		}
		
		return null;
	}
	
	public static boolean func(char[] list, char x) {
		boolean bit = false;
		for(char c: list) {
			if(x == c) {
				bit = true;
			}
		}
		return bit;	
	}

}
