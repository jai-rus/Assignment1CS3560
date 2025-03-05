package org.example;
import java.util.*;
public class ValidParentheses {
    public boolean isValid(String s) {
        /*
        This code works by utilizing a stack and whenever a opening bracket is pushed in,
        it also pushes in a closing bracket. If we ever encounter something that is not a opening
        bracket, it pops the top element from the stack and if it doesn't match it returns false.
        At the end we return whether the stack is empty or not.
         */
        if (s.length() <= 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }}

