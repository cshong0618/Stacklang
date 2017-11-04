package vm;

import model.Variable;

/**
 * Created by shaong on 11/5/17.
 */

public class Get implements Instruction{
    public Get() {
    }

    @Override
    public Variable apply() {
        return CacheSingleton.getInstance().pop();
    }
}
