package repl;

import model.Variable;
import vm.*;

import java.util.List;

/**
 * Created by shaong on 11/5/17.
 */

public class Process {
    private static Process process = null;

    public static Process getInstance() {
        if(process == null) {
            process = new Process();
        }

        return process;
    }

    private Process() {}

    public Variable processLine() {
        List<String> line = Evaluate.getInstance().getTokens();
        InstructionStack is = InstructionStack.getInstance();
        Reserved r = Reserved.getInstance();

        for(String s : line) {
            if(r.isKeyword(s)) {
                switch (s) {
                    case Reserved.OPS.LOAD: {
                        // Do nothing
                        // Do not support LOAD explicitly
                    }

                    case Reserved.OPS.ADD: {
                        is.addInstruction(new Add());
                        break;
                    }

                    case Reserved.OPS.SUB: {
                        is.addInstruction(new Subtract());
                        break;

                    }

                    case Reserved.OPS.GET: {
                        is.addInstruction(new Get());
                        break;

                    }
                }
            } else {
                // Evaluate typeof s
                Variable var = null;

                if(s.contains("\"")) {
                    var = new model.String(s);
                } else {
                    try {
                        double d = Double.parseDouble(s);
                        var = new model.Double(d);
                    } catch (NumberFormatException nfe) {
                        throw nfe;
                    }
                }

                is.addInstruction(new Load(var));
            }
        }

        Variable o = null;
        for(int i = 0; i < line.size(); i++) {
            o = is.executeTop();
        }

        return o;
    }
}
