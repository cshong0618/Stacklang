package vm;

import model.Null;
import model.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaong on 11/5/17.
 */

public class Variables {
    private static Variables _vars = null;

    public static Variables getInstance() {
        if(_vars == null) _vars = new Variables();
        return _vars;
    }

    private Map<String, Variable> varmap;

    private Variables() {
        varmap = new HashMap<>();
    }

    public Variable getVariable(String varname) {
        if(varmap.containsKey(varname)) {
            return varmap.get(varname);
        }

        return new Null();
    }

    public void putVariable(String varname, Variable var) {
        varmap.put(varname, var);
    }
}
