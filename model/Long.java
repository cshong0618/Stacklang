package model;

/**
 * Created by shaong on 11/5/17.
 */

public class Long extends Variable{
    private long value;

    private Long(Datatype type) {
        super(type);
    }

    public Long(long value){
        this(Datatype.LONG);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
