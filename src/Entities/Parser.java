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
		if(recursao()) {
			if(token.lexema.equals("$")) {
				System.out.println("Sintaticamente correto");
			} else {
				erro("");
			}
		}
	}
	
	public boolean recursao() {
		if(token != null) {
			if(token.lexema.equals("oz")) {
				if(ifs()) {
					recursao();
					return true;
				}else {
					erro("ifs");
					return false;
				}	
			}else if(token.lexema.equals("ozak")) {
				if(ifelse()) {
					recursao();
					return true;
				}else {
					erro("ifelse");
					return false;
				}
			}else if(token.lexema.equals("zak")) {
				if(elses()) {
					recursao();
					return true;
				}else {
					erro("else");
					return false;
				}
			}else if(token.lexema.equals("floq") || token.lexema.equals("numz") ||token.lexema.equals("atoz") ||token.lexema.equals("io")) {
				if(declaracao()) {
					recursao();
					return true;
				}else {
					erro("declaracao");
					return false;
				}
			}else if(token.lexema.equals("roof")) {
				if(fors()) {
					recursao();
					return true;
				}else {
					erro("for");
					return false;
				}
			}else if(token.tipo.equals("ID")) {
				if(expressao()) {
					recursao();
					return true;
				}else {
					erro("expressao");
					return false;
				}
			}else if(token.lexema.equals("$")) {
				return true;
			}else {
				erro("recursao");
				return false;
			}
		}else {
			erro("recursao");
			return false;
		}
	}
	
	public boolean declaracao() {
		if(tipos() && matchT("ID", token.lexema) && matchL("=", token.lexema) && matchT("NUMERO", token.lexema) && matchL(";", token.lexema)){
			return true;
		}
		return false;
	}

	public boolean fors() {
		if(matchL("roof", "for") && matchL("(", token.lexema) && declaracao() && condicao() && matchL(";", token.lexema) && expressao() && matchL("{", token.lexema) && expressao() && matchL("}", token.lexema)){
			return true;
		}
		return false;
	}
	
	public boolean ifs() {
		if(matchL("oz", "if") && matchL("(", token.lexema) && condicao() && matchL(")", token.lexema) && matchL("{", token.lexema) && expressao() && matchL("}", token.lexema)){
			return true;
		}
		return false;
	}
	
	public boolean ifelse() {
		if(matchL("ozak", "if else") && matchL("(", token.lexema) && condicao() && matchL(")", token.lexema) && matchL("{", token.lexema) && expressao() && matchL("}", token.lexema)){
			return true;
		}
		erro("ifelse");
		return false;	
	}
	
	public boolean elses() {
		if(matchL("zak", "else") && matchL("{", token.lexema) && expressao() && matchL("}", token.lexema)){
			return true;
		}
		erro("elses");
		return false;
	}
	
	public boolean matchL(String lexema, String newcode) {
		if(token.lexema.equals(lexema)) {
			printa(newcode);
			token = nextToken();
			return true;
		}
		return false;
	}
	
	public boolean condicao() {
		if(matchT("ID", token.lexema) && operador() && matchT("NUMERO", token.lexema)) {
			return true;
		}
		erro("condicao");
		return false;
	}
	
	public boolean expressao() {
		if((matchT("ID", token.lexema) && matchL("=", token.lexema) && matchT("NUMERO", token.lexema) && (matchL(";", token.lexema) || matchL(")", token.lexema))) || (matchL("output", "return") && (matchT("ID", token.lexema) || matchT("NUMERO", token.lexema)) && matchL(";", token.lexema))) {
			return true;
		}
		erro("expressao2");
		return false;
	}
	
	public boolean matchT(String tipo, String newcode) {
		if(token.tipo.equals(tipo)) {
			printa(newcode);
			token = nextToken();
			return true;
		}
		return false;
	}
	
	public boolean operador() {
		if(matchL(">", token.lexema) || matchL("<", token.lexema) || matchL("==", token.lexema) || matchL(">=", token.lexema) || matchL("<=", token.lexema) || matchL("<>", "!=")) {
			return true;
		}
		return false;
	}
	
	public boolean operadorMat() {
		if(matchL("+", token.lexema) || matchL("/", token.lexema) || matchL("*", token.lexema) || matchL("-", token.lexema)) {
			return true;
		}
		return false;
	}
	
	public boolean tipos() {
		if(matchL("io", "boolean") || matchL("numz", "int") || matchL("floq", "float") || matchL("atoz", "String")) {
			return true;
		}
		return false;
	}
	
	public void printa(String palavra) {
		System.out.println(palavra);
	}
}
