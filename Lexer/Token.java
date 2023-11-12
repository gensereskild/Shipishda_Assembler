package Lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A {@code Token} represents a lexical word, for example an identifier, a number, or a register.
 */
public class Token {
    
    /**
     * These are the legal token types. If a token is initialized with a type that isn't among these,
     * the constructor will throw an exception.
     */
    private static final List<String> legalTypes = new ArrayList<>(Arrays.asList(
        "register", "integer", "identifier", ":", "->", ","
    ));
    
    private String type;
    private String content;
    
    public Token(String type, String content) {
        setType(type);
        this.content = content;
    }
    
    public String getType() {
        return type;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setType(String newType) {
        
        if (!legalTypes.contains(newType)) {
            throw new IllegalArgumentException("The type '" + newType + "' is invalid.");
        }
        
        this.type = newType;
        
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(" + type + ")");
        int missing = 25 - builder.length();
        builder.append(" ".repeat(missing));
        builder.append(content);
        return builder.toString();
    }
    
}
