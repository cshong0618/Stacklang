package model;

import java.lang.String;

/**
 * Created by shaong on 11/5/17.
 */

public class Null extends Variable {
    public Null(Datatype type) {
        super(type);
    }

    @Override
    public String toString() {
        return "NULL";
    }

    public Null() {
        this(Datatype.NULL);
    }
}
