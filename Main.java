import model.Integer;
import model.String;
import model.Variable;
import vm.Add;
import vm.Get;
import vm.InstructionStack;
import vm.Load;

import java.util.stream.IntStream;

/**
 * Created by shaong on 11/5/17.
 */

class Main {
    public static void main(java.lang.String[] args) {
        InstructionStack is = new InstructionStack();

        Variable var1 = new Integer(10);
        Variable var2 = new Integer(20);

        Load load_1 = new Load(var1);
        Load load_2 = new Load(var2);
        Add add = new Add();
        Get get = new Get();

        is.addInstruction(get);
        is.addInstruction(add);
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
