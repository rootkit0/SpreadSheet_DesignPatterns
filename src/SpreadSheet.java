public class SpreadSheet {

    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static Expression plus(Expression expr1, Expression expr2) {
        return new Expression();
    }

    public static Expression plus(Expression expr1, int value2) {
        return new Expression();
    }

    public static Expression plus(Expression expr1, String ref2) {
        return new Expression();
    }

    public static Expression plus(int value1, String ref2) {
        return new Expression();
    }

    public static Expression plus(String ref1, int value2) {
        return new Expression();
    }

    public static Expression plus(String ref1, String ref2) {
        return new Expression();
    }

    public static MaybeValue get(String name) {
        return new MaybeValue();
    }

    public static void put(String name, Expression expr) {

    }

    public static void put(String name, int value) {

    }

    public static void put(String name, String refName) {

    }

    public static void clear() {

    }
}
