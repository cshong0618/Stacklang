package vm;

import model.Variable;

import java.util.Stack;

/**
 * Created by shaong on 11/5/17.
 */

public class InstructionStack {
    private static InstructionStack is = null;

    public static InstructionStack getInstance() {
        if(is == null) is = new InstructionStack();
        return is;
    }

    private Stack<Instruction> instructions;

    private InstructionStack() {
        instructions = new Stack<>();
    }

    public void addInstruction(Instruction inst) {
        instructions.push(inst);
    }

    public Variable executeTop() {
        Instruction top = instructions.pop();

        if(top instanceof Get) {
            return top.apply();
        }

        Variable temp = top.apply();

        if(temp != null) {
            CacheSingleton.getInstance().push(temp);
        }

        return null;
    }
}
