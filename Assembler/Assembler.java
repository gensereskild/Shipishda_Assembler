package Assembler;

import java.util.List;

import Lexer.Lexer;
import Lexer.Token;

public class Assembler {
    
    
    public static void main(String[] args) {
        
        Lexer lexer = new Lexer();
        
        String input = """
                __main:
                    addi r0, r1, 75
                    xor r4, r7, r5
                """;
           
        List<Token> tokens = lexer.lex(input);
        
        System.out.println("TOKENS:");
        for (Token token : tokens) {
            System.out.println("\t" + token);
        }
        
    }
    
    
}
