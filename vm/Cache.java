package vm;

import model.Variable;

import java.util.Stack;

/**
 * Created by shaong on 11/5/17.
 */

public class Cache {
    private Stack<Variable> stack = new Stack<>();

    public void push(Variable var) {
        stack.push(var);
    }

    public Variable pop() {
        if(stack.isEmpty()) throw new NullPointerException("Stack is empty");

        return stack.pop();
    }
}
