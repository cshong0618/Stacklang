package model;

/**
 * Created by shaong on 11/5/17.
 */

public abstract class Variable {
    public final Datatype type;

    public Variable(Datatype type) {
        this.type = type;
    }

    public abstract java.lang.String toString();
}
