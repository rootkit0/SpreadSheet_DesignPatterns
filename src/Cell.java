import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private String ref;
    private Expression expr;
    private MaybeValue value;

    public Cell(String ref, Expression expr) {
        this.ref = ref;
        this.expr = expr;
        this.value = expr.evaluate();
    }

    public String getRef(){
        return this.ref;
    }
    public Expression getExpr(){
        return this.expr;
    }
    public MaybeValue getValue(){
        return this.value;
    }

    @Override
    public void update(Observable o, Object arg) {
        value = expr.evaluate();
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
        observerCell(this, expr);
        setChanged();
        notifyObservers();
        value = expr.evaluate();
    }

    @Override
    public boolean equals(Object arg) {
        final Cell other = (Cell) arg;
        if(arg == null) {
            return false;
        }
        if(getClass() != arg.getClass()) {
            return false;
        }
        if(!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        if(!Objects.equals(this.value, other.value)) {
            return false;
        }
        return Objects.equals(this.expr, other.expr);
    }

    private void observerCell(Cell cell, Expression expression) {
        if(expression instanceof Operation) {
            Operation exprCell = (Operation) expression;
            observerCell(cell,exprCell.getExp1());
            observerCell(cell,exprCell.getExp2());
        }
        if(expression instanceof Reference) {
            Reference exprR = (Reference) expression;
            observerCell(exprR.getCell(),exprR.getCell().getExpr());
        }
        if(expression instanceof MaybeValue) {
            if (!cell.equals(this)) {
                cell.addObserver(this);
            }
        }
    }
}