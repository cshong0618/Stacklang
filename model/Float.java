package model;

/**
 * Created by shaong on 11/5/17.
 */

public class Float extends Variable {
    private float value;

    private Float(Datatype type) {
        super(type);
    }

    public Float(float value) {
        this(Datatype.FLOAT);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
