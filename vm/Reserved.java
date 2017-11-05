package vm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaong on 11/5/17.
 */

public class Reserved {
    private static Reserved r = null;

    public static Reserved getInstance() {
        if(r == null) r = new Reserved();
        return r;
    }

    Map<String, Object> reserved = new HashMap<>();

    public static final class OPS {
        // Memory
        public static final String LOAD = "load";
        public static final String GET = "get";
        public static final String STORE = ":=";
        public static final String RETRIEVE = "<-";

        // Arithmetic
        public static final String ADD = "+";
        public static final String SUB = "-";
    }

    private Reserved() {
        String[] insts = {
                // Load unload ops
                OPS.LOAD,
                OPS.GET,
                OPS.STORE,
                OPS.RETRIEVE,

                // Math ops
                OPS.ADD,
                OPS.SUB,
        };

        Arrays.stream(insts).forEach((s)->{
            reserved.put(s, null);
        });
    }

    public boolean isKeyword(String k) {
        return reserved.containsKey(k);
    }
}
