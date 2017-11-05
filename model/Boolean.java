package model;

import java.lang.String;

/**
 * Created by shaong on 11/5/17.
 */

public class Boolean extends Variable{
    private boolean value;
    private Boolean(Datatype type) {
        super(type);
    }

    public Boolean(boolean value) {
        this(Datatype.BOOLEAN);
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
