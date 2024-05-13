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
		printa("import java.util.Scanner;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "public class Main {\r\n"
				+ "\r\n"
				+ "	public static void main(String[] args) {\r\n"
				+ "		Scanner sc = new Scanner(System.in);\r\n"
				+ "", true);
		token = nextToken();
		if(recursao()) {
			if(token.lexema.equals("$")) {
				printa("	sc.close();\r\n"
						+ "	}\r\n"
						+ "\r\n"
						+ "}", true);
				System.out.println("Sintaticamente correto");
			} else {
				erro("");
			}
		}
	}
	
	public boolean recursao() {
			if(token.lexema.equals("oz")) {
				if(ifs()) {
					recursao();
					return true;
				}else {
					erro("ifs");
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
			}else if(token.lexema.equals("tiziu")) {
				if(whiles()) {
					recursao();
					return true;
				}else {
					erro("while");
					return false;
				}
			}else if(token.lexema.equals("receba")) {
				if(print()) {
					recursao();
					return true;
				}else {
					erro("print");
					return false;
				}
			}else if(token.lexema.equals("//")) {
				if(comentario()) {
					recursao();
					return true;
				}else {
					erro("comentario");
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
			}else if(token.lexema.equals("}")) {
				return true;
			}else if(token.lexema.equals("$")) {
				return true;
			}
			else {
				erro("recursao");
				return false;
			}
	}
	
	public boolean comentario() {
		if(matchL("//", token.lexema, false) && matchT("TEXTO", token.lexema, true)) {
			return true;
		}
		return false;
	}
	
	
	public boolean print() {
		if(matchL("receba", "System.out.println", false) && matchL("(", token.lexema, false) && valor() && matchL(")", token.lexema, false) && matchL(";", token.lexema, true)) {
			return true;
		}
		return false;
	}
	
	public boolean inputs() {
		if(matchL("caption", " sc.next", false) && tipos2() && matchL("(", token.lexema, false) && matchL(")", token.lexema, false)) {
			return true;
		}
		return false;
	}
	
	public boolean declaracao() {
		if(tipos() && expressao()){
			return true;
		}
		return false;
	}
	
	public boolean declaracao2() {
		if(tipos() && matchT("ID", token.lexema, false) && matchL("=", " " + token.lexema, false) && valor()){
			return true;
		}
		return false;
	}

	public boolean fors() {
		if(matchL("roof", "for", false) && matchL("(", token.lexema, false) && declaracao2() && matchL(";", token.lexema, false) && condicao() && matchL(";", token.lexema, false) && expressao2() && matchL(")", token.lexema, false) && matchL("{", token.lexema, true) && recursao() && matchL("}", token.lexema, true)){
			return true;
		}
		return false;
	}
	
	public boolean whiles() {
		if(matchL("tiziu", "while", false) && matchL("(", token.lexema, false) && condicao() && matchL(")", token.lexema, false) && matchL("{", token.lexema, true) && recursao() && matchL("}", token.lexema, true)){
			return true;
		}
		return false;
	}
	
	public boolean ifs() {
		if(matchL("oz", "if", false) && matchL("(", token.lexema, false) && condicao() && matchL(")", token.lexema, false) && matchL("{", token.lexema, true) && recursao() && matchL("}", token.lexema, true) && ififelseelse()){
			return true;
		}
		return false;
	}
	
	public boolean ififelseelse() {
		if(token.lexema.equals("ozak")) {
			if(ifelse() && ififelseelse()) {
				return true;
			}
		}else if(token.lexema.equals("zak")){
			if(elses()) {
				return true;
			}
		}
		return true;
	}
	
	public boolean ifelse() {
		if(matchL("ozak", "if else", false) && matchL("(", token.lexema, false) && condicao() && matchL(")", token.lexema, false) && matchL("{", token.lexema, true) && expressao() && matchL("}", token.lexema, true)){
			return true;
		}
		erro("elseif");
		return false;	
	}
	
	public boolean elses() {
		if(matchL("zak", "else", false) && matchL("{", token.lexema, true) && expressao() && matchL("}", token.lexema, true)){
			return true;
		}
		erro("else");
		return false;
	}
	
	public boolean matchL(String lexema, String newcode, boolean quebra) {
		if(token.lexema.equals(lexema)) {
			if(quebra) {
				printa(newcode, true);
			}else {
				printa(newcode, false);
			}
			token = nextToken();
			return true;
		}
		return false;
	}
	
	public boolean condicao() {
		if(matchT("ID", token.lexema, false) && operador() && matchT("NUMERO", " " + token.lexema, false)) {
			return true;
		}
		erro("condicao");
		return false;
	}
	
	public boolean valorInExpressao() {
		if((matchL("=", " " + token.lexema + " ", false) && (valor() || inputs())) || (matchL("++", token.lexema, false) || matchL("--", token.lexema, false))){
			return true;
		}
		return false;
	}
	
	public boolean expressao() {
		if(matchT("ID", token.lexema, false) && valorInExpressao() && matchL(";", token.lexema, true)){
			return true;
		}
		return false;
	}
	
	public boolean expressao2() {
		if(matchT("ID", token.lexema, false) && valorInExpressao()) {
			return true;
		}
		erro("expressao2");
		return false;
	}
	
	public boolean matchT(String tipo, String newcode, boolean lns) {
		if(token.tipo.equals(tipo)) {
			printa(newcode, lns);
			token = nextToken();
			return true;
		}
		return false;
	}
	
	public boolean operador() {
		if(matchL(">", " " + token.lexema, false) || matchL("<", " " + token.lexema, false) || matchL("==", " " + token.lexema, false) || matchL(">=", " " + token.lexema, false) || matchL("<=", " " + token.lexema, false) || matchL("<>", " !=", false)) {
			return true;
		}
		return false;
	}
	
	public boolean operadorMat() {
		if(matchL("+", token.lexema, false) || matchL("/", token.lexema, false) || matchL("*", token.lexema, false) || matchL("-", token.lexema, false)) {
			return true;
		}
		return false;
	}
	
	public boolean tipos() {
		if(matchL("io", "boolean ", false) || matchL("numz", "int ", false) || matchL("floq", "double ", false) || matchL("atoz", "String ", false)) {
			return true;
		}
		return false;
	}
	
	public boolean tipos2() {
		if(matchL("io", "Boolean", false) || matchL("numz", "Int", false) || matchL("floq", "Double", false) || matchL("atoz", "Line", false)) {
			return true;
		}
		return false;
	}
	
	public boolean valor() {
		if((matchT("ID", token.lexema, false) || matchT("NUMERO", token.lexema, false) || matchT("FLUTUANTE", token.lexema, false) || matchT("TEXTO", token.lexema, false) || matchL("real", " true", false) || matchL("barca", " false", false)) && valorExt()) {
			return true;
		}
		return false;
	}
	
	public boolean valorExt() {
		if(operadorMat() && valor()) {
			return true;
		}
		return true;
	}
	
	public void printa(String palavra, boolean quebra) {
		if(quebra){
			System.out.println(palavra);
		}else {
			System.out.print(palavra);
		}		
	}
}
