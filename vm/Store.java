package vm;

import model.Datatype;
import model.Variable;

/**
 * Created by shaong on 11/5/17.
 */

public class Store implements Instruction {
    public Store(){}

    @Override
    public Variable apply() {
        Variable arg1 = CacheSingleton.getInstance().pop();
        Variable arg2 = CacheSingleton.getInstance().pop();

        if(arg1 instanceof model.String) {
            String name = ((model.String)arg1).getValue();
            Variables.getInstance().putVariable(name, arg2);
        } else {
            throw new IllegalArgumentException("First argument is not of type " + Datatype.STRING);
        }

        return null;
    }
}
