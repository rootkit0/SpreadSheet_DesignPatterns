public abstract class MaybeValue implements Expression {
    private boolean value;

    public MaybeValue(boolean value){
        this.value = value;
    }

    public boolean hasValue(){
        return this.value;
    }
}