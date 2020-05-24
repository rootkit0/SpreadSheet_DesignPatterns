import java.util.HashSet;
import java.util.Set;

public class SomeValue extends MaybeValue {
    private int value;

    public SomeValue(int value){
        super(true);
        this.value = value;
    }

    public int getSomeValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object value){
        if(value instanceof SomeValue) {
            SomeValue tmp = (SomeValue) value;
            return this.value == tmp.value;
        }
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }
}