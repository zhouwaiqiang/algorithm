package com.zhou.test1;

import com.zhou.prepare.In;
import com.zhou.prepare.StdOut;
import com.zhou.datastructure.Stack;

/**
 * Created by dell on 2017/11/6.
 */
public class Parentheses {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN) {
                stack.push(LEFT_PAREN);
            } else if (s.charAt(i) == LEFT_BRACKET) {
                stack.push(LEFT_BRACKET);
            } else if (s.charAt(i) == LEFT_BRACE) {
                stack.push(LEFT_BRACE);
            } else if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_PAREN) {
                    return false;
                }
            } else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_BRACKET) {
                    return false;
                } else if (s.charAt(i) == RIGHT_BRACE) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != LEFT_BRACE) {
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
        /*
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN)   stack.push(LEFT_PAREN);
            if (s.charAt(i) == LEFT_BRACE)   stack.push(LEFT_BRACE);
            if (s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_PAREN) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_BRACE) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty())             return false;
                if (stack.pop() != LEFT_BRACKET) return false;
            }
        }
        re0turn stack.isEmpty();*/
    }

    public static void main(String[] args) {
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
    }
}
