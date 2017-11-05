package vm;

import model.Double;
import model.Float;
import model.Integer;
import model.Long;
import model.Variable;

import static model.Datatype.*;

/**
 * Created by shaong on 11/5/17.
 */

public class ReturnCommon {
    public static double value(Variable arg1) {
        double _1 = 0;
        switch(arg1.type) {
            case INT: {
                _1 = ((Integer)arg1).getValue();
                break;
            }
            case LONG: {
                _1 = ((Long)arg1).getValue();
                break;
            }
            case FLOAT: {
                _1 = ((Float)arg1).getValue();
                break;
            }
            case DOUBLE: {
                _1 = ((Double)arg1).getValue();
                break;
            }
        }

        return _1;
    }
}
