package vm;

import model.Variable;

/**
 * Created by shaong on 11/5/17.
 */

public class Load implements Instruction {
    Variable arg;

    public Load(Variable arg) {
        this.arg = arg;
    }

    @Override
    public Variable apply() {
        CacheSingleton.getInstance().push(arg);
        return null;
    }
}
