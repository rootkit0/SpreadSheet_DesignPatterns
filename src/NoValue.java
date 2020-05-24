import java.util.HashSet;
import java.util.Set;

public class NoValue extends MaybeValue {
    private static NoValue noValue = new NoValue();

    public NoValue(){
        super(false);
    }

    public static NoValue getNoValue(){
        return noValue;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        return noValue;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }
}