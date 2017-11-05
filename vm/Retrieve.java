package vm;

import model.Datatype;
import model.Variable;

/**
 * Created by shaong on 11/5/17.
 */

public class Retrieve implements Instruction{


    @Override
    public Variable apply() {
        Variable arg = CacheSingleton.getInstance().pop();

        if(arg instanceof model.String) {
            String name = ((model.String)arg).getValue();
            return Variables.getInstance().getVariable(name);
        } else {
            throw new IllegalArgumentException("Argument is not of type " + Datatype.STRING);
        }
    }
}
