public class Plus extends Operation {
    public Plus(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public int operate(int i1, int i2) {
        return (i1 + i2);
    }
}