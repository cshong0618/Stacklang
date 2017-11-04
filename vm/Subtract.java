package vm;

import model.Double;
import model.Float;
import model.Integer;
import model.Long;
import model.String;
import model.Variable;

/**
 * Created by shaong on 11/5/17.
 */

public class Subtract implements Instruction {
    public Subtract(){}

    @Override
    public Variable apply() {
        Variable arg1 = CacheSingleton.getInstance().pop();
        Variable arg2 = CacheSingleton.getInstance().pop();

        if(arg1.type == arg2.type) {
            switch (arg1.type) {
                case INT: return (new Integer(((Integer)arg1).getValue() - ((Integer)arg2).getValue()));
                case LONG: return (new Long(((Long)arg1).getValue() - ((Long)arg2).getValue()));
                case FLOAT: return (new Float(((Float)arg1).getValue() - ((Float)arg2).getValue()));
                case DOUBLE: return (new Double(((Double)arg1).getValue() - ((Double)arg2).getValue()));
                default: throw new UnsupportedOperationException("Invalid type");
            }
        } else {
            throw new IllegalArgumentException("arg1 and arg2 are of different types");
        }
    }
}
