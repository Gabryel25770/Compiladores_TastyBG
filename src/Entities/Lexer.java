package Entities;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
	private List<AFD> afds;
	private List<Token> tokens;
	private CharacterIterator codigo;
	
	public Lexer(String codigo){
		this.codigo = new StringCharacterIterator(codigo);
		tokens = new ArrayList<>();
		afds = new ArrayList<>();
		afds.add(new Int());
		afds.add(new Float());
		afds.add(new Str());
		afds.add(new Boolean());
		afds.add(new If());
		afds.add(new Ifelse());
		afds.add(new Else());
		afds.add(new For());
		afds.add(new Return());
		afds.add(new Comentarios());
		afds.add(new Acrescimo());
		afds.add(new Decrescimo());
		afds.add(new Comparacao());
		afds.add(new MaiorIgual());
		afds.add(new MenorIgual());
		afds.add(new Operador());
		afds.add(new Numero());
		afds.add(new Flutuante());
		afds.add(new ID());
		
	}
	
	public void skipWhiteSpace(){
		while(codigo.current() == ' ' || codigo.current() == '\n'){
			codigo.next();
		}
	}
	
	public List<Token> getTokens(){
		boolean accepted;
		while(codigo.current() != CharacterIterator.DONE){
			accepted = false;
			skipWhiteSpace();
			if(codigo.current() == CharacterIterator.DONE) break;
			for(AFD afd: afds){
				int pos = codigo.getIndex();
				Token t = afd.evaluate(codigo);
				if(t != null){
					accepted = true;
					tokens.add(t);
					break;
				}else{
					codigo.setIndex(pos);
				}
			}
			if(accepted)continue;
			throw new RuntimeException("token not regognized " + codigo.current());
		}
		tokens.add(new Token("EOF", "$"));
		return tokens;
	}
}
