package model;

/**
 * Created by shaong on 11/5/17.
 */

public class Double extends Variable {
    private double value;

    private Double(Datatype type) {
        super(type);
    }

    public Double(double value) {
        this(Datatype.DOUBLE);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
