package Program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Entities.Lexer;
import Entities.Parser;
import Entities.Token;

public class MainLexer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String codigo = "numz + - * / // floq io oz ozak zak roof output atoz thiago = () {} ; 4 5.6";
		
		String codigo = "C:/Workspace/Java JDK/Projeto Compiladores/arquivo.txt"; // Substitua "arquivo.txt" pelo caminho do seu arquivo

	    try ( BufferedReader br = new BufferedReader(new FileReader(codigo)); BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Workspace/Java JDK/Projeto Compiladores/output.java"))) {
	    	
	    	StringBuilder conteudo = new StringBuilder();
            String linha;

            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n"); // Adiciona cada linha ao StringBuilder
            }

            String codigo2 = conteudo.toString();

            Lexer lexer = new Lexer(codigo2);
			List<Token> tokens = lexer.getTokens();
			
			for(Token t: tokens){
				System.out.println(t);
			}
			Parser parser = new Parser(tokens);
			writer.write(parser.main());
            
	    } catch (IOException e) {
	    	System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	    }
	    
	    
	}

}
