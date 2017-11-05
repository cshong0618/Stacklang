package repl;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shaong on 11/5/17.
 */

public class Evaluate {
    private static Evaluate evaluate = null;

    public static Evaluate getInstance() {
        if(evaluate == null) {
            evaluate = new Evaluate();
        }

        return evaluate;
    }


    private List<String> tokens = new LinkedList<>();
    private Evaluate() {

    }

    public void evaluateLine() throws Exception{
        tokens = new LinkedList<>();
        String line = Read.getInstance().getCurrentLine();

        Stack<String> pairs = new Stack<>();

        StringBuilder sb = new StringBuilder();
        char[] chars = line.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c == ' ') {
                if(pairs.isEmpty()) {
                    tokens.add(sb.toString());
                    sb = new StringBuilder();
                    continue;
                }
            }

            // Process escape chars
            if(c == '\\') {
                if(pairs.isEmpty()) {
                    // Illegal char
                    throw new IllegalArgumentException("\\ found outside of string literal");
                }
            } else if (c == '"') {
                if(i > 0 && chars[i - 1] == '\\') {
                    if(!pairs.isEmpty() && pairs.peek() == "\\\"") {
                        pairs.pop();
                    } else {
                        pairs.push("\\\"");
                    }
                } else if(!pairs.isEmpty() && pairs.peek() == "\"") {
                    pairs.pop();
                } else {
                    pairs.push("\"");
                }
            }

            sb.append(c);
        }

        // Last stuck token
        if(sb.length() != 0) {
            tokens.add(sb.toString());
        }

        if(!pairs.isEmpty()) {
            throw new Exception("Unclosed quotes found");
        }
    }

    public List<String> getTokens () {
        return tokens;
    }
}
