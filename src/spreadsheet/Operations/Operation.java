package spreadsheet.Operations;

import spreadsheet.*;
import spreadsheet.Values.MaybeValue;
import spreadsheet.Values.NoValue;
import spreadsheet.Values.SomeValue;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression {
    private Expression expr1;
    private Expression expr2;

    public Operation(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public abstract int operate(int i1, int i2);

    public Expression getExp1(){
        return expr1;
    }
    public Expression getExp2(){
        return expr2;
    }

    public MaybeValue evaluate() {
        MaybeValue val1 = expr1.evaluate();
        MaybeValue val2 = expr2.evaluate();
        if (val1.hasValue() && val2.hasValue()) {
            SomeValue some1 = (SomeValue) val1;
            SomeValue some2 = (SomeValue) val2;
            return new SomeValue(operate(some1.getValue(), some2.getValue()));
        }
        else {
            return NoValue.getNoValue();
        }
    }

    public Set<Cell> references(){
        Set<Cell> references = new HashSet<>();
        references.addAll(expr1.references());
        references.addAll(expr2.references());
        return references;
    }
}