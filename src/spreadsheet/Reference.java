package spreadsheet;

import spreadsheet.Values.MaybeValue;

import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression {
    private final Cell cell;

    public Reference(Cell cell){
        this.cell = cell;
    }

    public Cell getCell(){
        return this.cell;
    }

    @Override
    public MaybeValue evaluate() {
        return cell.getExpr().evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> refCell = new HashSet<>();
        refCell.add(cell);
        return refCell;
    }
}