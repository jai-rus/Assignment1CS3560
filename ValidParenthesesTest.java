package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
public class ValidParenthesesTest {
    @Test
    public void testIsValid() {
        ValidParentheses vp = new ValidParentheses();
        assertTrue(vp.isValid("()"));
        assertTrue(vp.isValid("()[]{}"));
        assertFalse(vp.isValid("(]"));
        assertFalse(vp.isValid("([)]"));
        assertTrue(vp.isValid("([{{[()]}}])()([[]]){}"));
        assertTrue(vp.isValid(""));
    }

}
