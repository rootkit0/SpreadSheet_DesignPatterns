public class SpreadSheet {
    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static Expression plus(Expression expr1, Expression expr2) {
        return new Plus(expr1, expr2);
    }

    public static Expression plus(Expression expr1, int value2) {
        SomeValue expr2 = new SomeValue(value2);
        return new Plus(expr1, expr2);
    }

    public static Expression plus(Expression expr1, String ref2) {
        return new Plus(expr1, new Reference(SHEET.getCell(ref2)));
    }

    public static Expression plus(int value1, String ref2) {
        SomeValue val1 = new SomeValue(value1);
        Expression val2 = new Reference(SHEET.getCell(ref2));
        return new Plus(val1, val2);
    }

    public static Expression plus(String ref1, int value2) {
        Expression val1 = new Reference(SHEET.getCell(ref1));
        SomeValue val2 = new SomeValue(value2);
        return new Plus(val1, val2);
    }

    public static Expression plus(String ref1, String ref2) {
        Expression val1 = new Reference(SHEET.getCell(ref1));
        Expression val2 = new Reference(SHEET.getCell(ref2));
        return new Plus(val1, val2);
    }

    public static Expression mult(Expression expr1, Expression expr2) {
        return new Mult(expr1, expr2);
    }

    public static Expression mult(Expression expr1, int value2) {
        SomeValue expr2 = new SomeValue(value2);
        return new Mult(expr1, expr2);
    }

    public static Expression mult(Expression expr1, String ref2) {
        Expression val2 = new Reference(SHEET.getCell(ref2));
        return new Mult(expr1, val2);
    }

    public static Expression mult(int value1, String ref2) {
        SomeValue val1 = new SomeValue(value1);
        Expression val2 = new Reference(SHEET.getCell(ref2));
        return new Mult(val1, val2);
    }

    public static Expression mult(String ref1, int value2) {
        Expression val1 = new Reference(SHEET.getCell(ref1));
        SomeValue val2 = new SomeValue(value2);
        return new Mult(val1, val2);
    }

    public static Expression mult(String ref1, String ref2) {
        Expression val1 = new Reference(SHEET.getCell(ref1));
        Expression val2 = new Reference(SHEET.getCell(ref2));
        return new Mult(val1, val2);
    }

    public static MaybeValue get(String name) {
        Cell cell = SHEET.getCell(name);
        MaybeValue value = cell.getValue();
        return value;
    }

    public static void put(String name, Expression expr) throws NoValidCell {
        SHEET.putExpression(name, expr);
    }

    public static void put(String name, int value) throws NoValidCell {
        SHEET.putExpression(name, new SomeValue(value));
    }

    public static void put(String name, String refName) throws NoValidCell {
        Expression valor = new Reference(SHEET.getCell(refName));
        SHEET.putExpression(name, valor);
    }
}
