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

    public Variable processLine() throws Exception{
        List<String> line = Evaluate.getInstance().getTokens();
        InstructionStack is = InstructionStack.getInstance();
        Reserved r = Reserved.getInstance();

        String prev = "";
        for(String s : line) {
            if(prev.equals(Reserved.OPS.STORE) || prev.equals(Reserved.OPS.RETRIEVE)) {
                s = "\"" + s + "\"";
            }
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

                    case Reserved.OPS.STORE: {
                        is.addInstruction(new Store());
                        break;
                    }

                    case Reserved.OPS.RETRIEVE: {
                        is.addInstruction(new Retrieve());
                        break;
                    }
                }
            } else {
                // Evaluate typeof s
                Variable var = null;

                if(s.contains("\"")) {
                    s = s.substring(1, s.length() - 1);
                    var = new model.String(s);
                } else {
                    try {
                        double d = Double.parseDouble(s);

                        if(Math.ceil(d) == d) {
                            if(s.contains(".")) {
                                var = new model.Double(d);
                            } else {
                                var = new model.Integer((int) d);
                            }
                        } else {
                            var = new model.Double(d);
                        }
                    } catch (NumberFormatException nfe) {
                        throw new Exception("Cannot parse");
                    }
                }

                is.addInstruction(new Load(var));
            }

            prev = s;
        }

        Variable o = null;
        for(int i = 0; i < line.size(); i++) {
            o = is.executeTop();
        }

        return o;
    }
}
