package spreadsheet;

import spreadsheet.Exceptions.InvalidCell;
import spreadsheet.Values.NoValue;

import java.util.HashMap;

public class Sheet {
    private final int SIZE;
    private static HashMap<String, Cell> CELLS;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public Sheet(int SIZE) {
        this.SIZE = SIZE;
        this.initSheet();
    }

    public final void initSheet() {
        CELLS = new HashMap<>();
        for (int x=0; x<SIZE; ++x) {
            for (int y=0; y<SIZE; ++y) {
                addNewCell(x,y);
            }
        }
    }

    public void clear() {
        this.initSheet();
    }

    public Cell getCell(String name) {
        return CELLS.get(name);
    }

    private void addNewCell(int x, int y) {
        String key = String.valueOf(alphabet.charAt(x))+y;
        Cell cell = new Cell(key, NoValue.getNoValue());
        CELLS.put(key, cell);
    }

    public void putExpression(String name, Expression expr) throws InvalidCell {
        CELLS.get(name).setExpr(expr);
    }
}