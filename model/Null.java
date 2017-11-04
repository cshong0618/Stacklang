package model;

/**
 * Created by shaong on 11/5/17.
 */

public class Null extends Variable {
    public Null(Datatype type) {
        super(type);
    }

    public Null() {
        this(Datatype.NULL);
    }
}
