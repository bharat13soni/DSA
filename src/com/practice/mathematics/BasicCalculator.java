package com.practice.mathematics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 * <p>
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * <p>
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        int len = s.length();
        int sign = 1;
        int ans = 0;
        int currNo = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                currNo = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) { //handel multiple digits number
                    currNo = currNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                currNo = currNo * sign;
                ans += currNo;
                currNo = 0; //re-initialize
                sign = 1; //re-initialize
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1; //  -1 represents negative sign
            else if (s.charAt(i) == '(') {
                stack.push(ans); // store the result calculated so far
                stack.push(sign); // store the upcoming sign
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int prevAns = stack.pop();
                ans = ans + prevAns;
            }

        }
        return ans;
    }
}
