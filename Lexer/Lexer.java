package Lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    
    private static final String digits = "0123456789";
    private static final String identifierPrefixes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
    
    private int index;
    private String input;
    
    private List<Token> tokens;
    
    public List<Token> lex(String input) {
        
        prepare(input);
        
        while (index < input.length()) {
            determineType();
        }
        
        return tokens;
        
    }
    
    private void determineType() {
        String substring = input.substring(index, index + 1);
        if (digits.contains(substring)) {
            lexInteger();
        } else if (identifierPrefixes.contains(substring)) {
            lexIdentifier();
        } else if (substring.equals(":")) {
            index += 1;
            tokens.add(new Token(":", ":"));
        } else if (substring.equals("-")) {
            lexArrow();
        } else if ("  \n\t".contains(substring)) {
            index += 1;
        } else {
            // TODO: Submit some sort of error
            return;
        }
    }
    
    private void lexInteger() {
        
        StringBuilder integer = new StringBuilder();
        
        while (index < input.length() && '0' <= input.charAt(index) && '9' <= input.charAt(index)) {
            integer.append(input.charAt(index));
            index += 1;
        }
        
        tokens.add(new Token("integer", integer.toString()));
        
    }
    
    private void lexIdentifier() {
        
        StringBuilder identifier = new StringBuilder();
        
        while (index < input.length() && '0' <= input.charAt(index) && '9' <= input.charAt(index)) {
            identifier.append(input.charAt(index));
            index += 1;
        }
        
        Token newToken = new Token("identifier", identifier.toString());
        
        if (input.matches("r[0-7]")) {
            newToken.setType("register");
        }
        
        tokens.add(newToken);
        
    }
    
    private void lexArrow() {
        
        if (index + 1 < input.length() && input.charAt(index) == '-' && input.charAt(index + 1) == '>') {
            tokens.add(new Token("->", "->"));
            index += 2;
        } else {
            // TODO: Submit an error.
        }
        
    }
    
    private void prepare(String input) {
        this.index = 0;
        this.input = input;
        this.tokens = new ArrayList<>();
    }
    
}
