package Entities;

import java.util.List;

public class Parser {
	List<Token> tokens;
	Token token;
	
	public Parser(List<Token> tokens) {
		this.tokens = tokens;
	}
	
	public Token nextToken() {
		if(tokens.size() > 0) {
			return tokens.remove(0);
		}
		return null;
	}
	
	public void erro(String regra) {
		System.out.println("Regra: " + regra);
		System.out.println("token inválido: " + token.lexema);
		System.exit(0); //encerra o programa
	}
	
	public void main() {
		token = nextToken();
		if(ifs()) {
			if(token.lexema.equals("$")) {
				System.out.println("Sintaticamente correto");
			} else {
				erro("");
			}
		}
	}
	
	public boolean ifs() {
		if(matchL("oz") && matchL("(") && condicao() && matchL(")") && matchL("{") && expressao() && matchL("}")){
			return true;
		}
		erro("ifs");
		return false;
		
		
	}
	
	public boolean ifelse() {
		if(matchL("ozak") && matchL("{") && expressao() && matchL("}")){
			return true;
		}
		erro("elses");
		return false;	
	}
	
	public boolean elses() {
		if(matchL("zak") && matchL("{") && expressao() && matchL("}")){
			return true;
		}
		erro("elses");
		return false;
	}
	
	public boolean matchL(String lexema) {
		if(token.lexema.equals(lexema)) {
			token = nextToken();
			return true;
		}
		return false;
	}
	
	public boolean condicao() {
		if(matchT("ID") && operador() && matchT("NUMERO")) {
			return true;
		}
		erro("condicao");
		return false;
	}
	
	public boolean expressao() {
		if((matchT("ID") && matchL("=") && matchT("NUMERO")) || (matchL("output") && (matchT("ID") || matchT("NUMERO")) && matchL(";"))) {
			return true;
		}
		erro("expressao");
		return false;
	}
	
	public boolean matchT(String tipo) {
		if(token.tipo.equals(tipo)) {
			token = nextToken();
			return true;
		}
		return false;
	}
	
	public boolean operador() {
		if(matchL(">") || matchL("<") || matchL("==") || matchL(">=") || matchL("<=")) {
			return true;
		}
		return false;
	}
	
	
	
}
