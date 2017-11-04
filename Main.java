import model.Integer;
import model.Variable;
import vm.*;

/**
 * Created by shaong on 11/5/17.
 */

class Main {
    public static void main(java.lang.String[] args) {
        InstructionStack is = new InstructionStack();

        Variable var1 = new Integer(10);
        Variable var2 = new Integer(20);

        Instruction load_1 = new Load(var1);
        Instruction load_2 = new Load(var2);
        Instruction ops    = new Subtract();
        Instruction get    = new Get();

        is.addInstruction(get);
        is.addInstruction(ops);
        is.addInstruction(load_1);
        is.addInstruction(load_2);

        for(int i = 0; i < 4; i++) {
            Variable o = is.executeTop();

            if(o != null) {
                System.out.println(((Integer)o).getValue());
            }
        }
    }

}
