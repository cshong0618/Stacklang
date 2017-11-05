package model;

/**
 * Created by shaong on 11/5/17.
 */

public class String extends Variable {
    private java.lang.String value;

    private String(Datatype type) {
        super(type);
    }

    public String(java.lang.String value) {
        this(Datatype.STRING);
        this.value = value;
    }

    public java.lang.String getValue() {
        return value;
    }

    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return value;
    }
}
