package com.incubyte.StringCalculator_Incubytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void testAddEmptyString() {
        assertEquals(0, calculator.add(""), "Empty string should return 0");
    }

    @Test
    void testAddSingleNumber() {
        assertEquals(5, calculator.add("5"), "Single number should return the number itself");
    }

    @Test
    void testAddTwoNumbers() {
        assertEquals(8, calculator.add("3,5"), "Two numbers should return their sum");
    }

    @Test
    void testAddWithWhitespace() {
        assertEquals(10, calculator.add(" 3 , 7 "), "Should handle whitespace around numbers");
    }

    @Test
    void testAddInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("5,a,3");
        });
        assertEquals("Invalid input: 'a' is not a valid integer.", exception.getMessage());
    }

    @Test
    void testAddMultipleNumbers() {
        assertEquals(15, calculator.add("1,2,3,4,5"), "Should return the sum of multiple numbers");
    }
    
    
    //3rd TEst case
    @Test
    void testAddNewLineBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"), "Should handle new lines between numbers");
    }
    
}
