package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Cell;
import spreadsheet.Exceptions.InvalidCell;
import spreadsheet.Expression;
import spreadsheet.Operations.Mult;
import spreadsheet.Operations.Operation;
import spreadsheet.Operations.Plus;
import spreadsheet.Reference;
import spreadsheet.Values.NoValue;
import spreadsheet.Values.SomeValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionTest {
    Cell cell1;
    Expression expr1;
    Expression expr2;
    Expression expr3;
    Expression expr4;

    @BeforeEach
    public void initTest() throws InvalidCell {
        expr1 = new SomeValue(10);
        expr2 = new SomeValue(20);
        expr3 = NoValue.getNoValue();
        cell1 = new Cell("a1", expr1);
        expr4 = new Reference(cell1);
    }

    @Test
    public void check_cell1_has_correct_value() throws InvalidCell {
        assertEquals(new SomeValue(10), cell1.getValue());
    }

    @Test
    public void check_reference_works() throws InvalidCell {
        assertEquals(new SomeValue(10), expr4.evaluate());
    }

    @Test
    public void check_novalue_expression() throws InvalidCell {
        Cell cell = new Cell("b1", expr3);
        Expression expr = new Reference(cell);
        Operation operation = new Plus(expr1, expr);
        assertEquals(NoValue.getNoValue(), operation.evaluate());
    }

    @Test
    public void check_plus_with_expr() throws InvalidCell {
        Operation operation = new Plus(expr1, expr2);
        assertEquals(new SomeValue(30), operation.evaluate());
    }

    @Test
    public void check_mult_with_expr() throws InvalidCell {
        Operation operation = new Mult(expr1, expr2);
        assertEquals(new SomeValue(200), operation.evaluate());
    }
}
