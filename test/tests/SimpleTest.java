package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.Exceptions.InvalidCell;
import spreadsheet.SpreadSheet;
import spreadsheet.Values.SomeValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest extends SpreadSheet {

    @BeforeEach
    public void initSheet() throws InvalidCell {
        put("a1", 10);
        put("a2", "a1");
        //Operations
        put("b1", plus("a1", "a2"));
        put("b2", mult("a1", "a2"));
    }

    @Test
    public void cell_a1_has_value() throws InvalidCell {
        assertTrue(get("a1").hasValue());
    }

    @Test
    public void cell_a1_has_correct_value() throws InvalidCell {
        SomeValue val = (SomeValue)get("a1");
        assertEquals(10, val.getValue());
    }

    @Test
    public void cell_a2_has_value() throws InvalidCell {
        assertTrue(get("a2").hasValue());
    }

    @Test
    public void cell_a2_has_correct_value() throws InvalidCell {
        SomeValue val = (SomeValue)get("a2");
        assertEquals(10, val.getValue());
    }

    @Test
    public void cell_b1_has_value_depends_on_a1a2() {
        assertTrue(get("b1").hasValue());
    }

    @Test
    public void plus_operation_works() {
        SomeValue val = (SomeValue) get("b1");
        assertTrue(val.getValue() == 20);
    }

    @Test
    public void cell_b2_has_value_depends_on_a1a2() {
        assertTrue(get("b2").hasValue());
    }

    @Test
    public void mult_operation_works() {
        SomeValue val = (SomeValue) get("b2");
        assertTrue(val.getValue() == 100);
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }
}
