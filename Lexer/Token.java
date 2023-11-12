package Lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token {
    
    private static final List<String> legalTypes = new ArrayList<>(Arrays.asList(
        
    ));
    
    private String type;
    private String content;
    
    public Token(String type, String content) {
        
        if (!legalTypes.contains(type)) {
            throw new IllegalArgumentException("The type '" + type + "' is invalid.");
        }
        
        this.type = type;
        this.content = content;
        
    }
    
    public String getType() {
        return type;
    }
    
    public String getContent() {
        return content;
    }
    
}
