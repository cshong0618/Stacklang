package model;

import java.lang.String;

/**
 * Created by shaong on 11/5/17.
 */

public class Integer extends Variable{
    private int value;

    private Integer(Datatype type) {
        super(type);
    }

    public Integer(int value) {
        this(Datatype.INT);
        this.value = value;
    }

    public int getValue(){return value;}
    public void setValue(int newVal) {value = newVal;}

    @Override
    public String toString() {
        return "" + value;
    }
}
