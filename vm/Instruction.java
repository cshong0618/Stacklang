package vm;

import model.Variable;

/**
 * Created by shaong on 11/5/17.
 */

public interface Instruction {
    public Variable apply();
}
