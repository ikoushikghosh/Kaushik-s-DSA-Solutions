package org.koushik.dsa.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class provides solutions for various problems related to stacks.
 * It includes methods for removing duplicate consecutive characters from a string,
 * converting infix expressions to postfix, and finding nearest smaller or larger
 * elements in an array.
 */
public class StacksSolutions {

    private static Map<Character, Integer> operatorPrecedenceMap;

    public static void main(String[] args) {
        operatorPrecedenceMap = new HashMap<>();
        operatorPrecedenceMap.put('+', 1);
        operatorPrecedenceMap.put('-', 1);
        operatorPrecedenceMap.put('*', 2);
        operatorPrecedenceMap.put('/', 3);
        operatorPrecedenceMap.put('^', 4);
        operatorPrecedenceMap.put('(', 5);

        removeDuplicateConsecutive("abbcbbcacx");

        infixToPostfix("3+10*(3-4/2)+3");
        infixToPostfix("(10+3)*2-(7-6)*(4+8)");

        getNearestSmallerElementsInGivenArray(new int[] {4, 5, 2, 1, 10, 18, 3, 2});
        getNearestSmallerElementIndicesInGivenArray(new int[] {4, 5, 2, 1, 10, 18, 3, 2});
        getNearestSmallerElementDistancesInGivenArray(new int[] {4, 5, 2, 1, 10, 18, 3, 2});
        getNearestLargerElementsInRightForGivenArray(new int[] {4, 5, 2, 1, 10, 18, 3, 2});
    }

    public static void removeDuplicateConsecutive(String s) {
        if(s == null || s.isEmpty()) return;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if(!stack.isEmpty()) {
                if(stack.peek().equals(current)) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            } else {
                stack.push(current);
            }
        }
        char[] result = new char[stack.size()];
        int index = result.length - 1;
        while(!stack.isEmpty()) {
            result[index--] = stack.pop();
        }

        System.out.printf("The string after removing duplicate consecutive is: %s%n", new String(result));

    } // TC: O(n) & SC: O(n)

    /**
     * This method takes an infix expression as a string and prints the corresponding
     * postfix expression. The infix expression can contain operators +, -, *, /, ^
     * and parentheses. The output is the postfix expression as a string.
     *
     * @param expression The infix expression to be converted to postfix.
     */
    public static void infixToPostfix(String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for(int i = 0; i < expression.length(); i++) {
            Character current = expression.charAt(i);
            handleExpression(current, operatorStack, sb);
        }

        while(!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop());
        }

        System.out.printf("The string after infix to postfix is: %s%n", sb);

    } // TC: O(n) & SC: O(n)

    private static void handleExpression(Character currentChar, Stack<Character> operatorStack, StringBuilder sb) {
        if(operatorStack == null || sb == null) return;
        if(operatorPrecedenceMap.containsKey(currentChar)) {
            if(operatorStack.isEmpty()) {
                operatorStack.push(currentChar);
            } else {
                handleOperatorPrecedence(currentChar, operatorStack, sb);
            }
        } else {
            if(currentChar.equals(')')) {
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    sb.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                sb.append(currentChar);
            }
        }
    }

    private static void handleOperatorPrecedence(Character currentChar, Stack<Character> operatorStack, StringBuilder sb) {
        if(operatorStack == null || operatorStack.isEmpty() || sb == null) return;

        if(operatorStack.peek().equals('(')) {
            operatorStack.push(currentChar);
        } else if(operatorPrecedenceMap.get(currentChar) <= operatorPrecedenceMap.get(operatorStack.peek())) {
            while(!operatorStack.isEmpty() && operatorPrecedenceMap.get(currentChar) <= operatorPrecedenceMap.get(operatorStack.peek())) {
                sb.append(operatorStack.pop());
            }
            operatorStack.push(currentChar);
        } else {
            operatorStack.push(currentChar);
        }
    }

    public static void getNearestSmallerElementsInGivenArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            while(!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(array[i]);
        }

        System.out.printf("The nearest smaller elements array is: %s%n", Arrays.toString(result));

    } // TC: O(n) & SC: O(n)


    public static void getNearestSmallerElementIndicesInGivenArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            while(!stack.isEmpty() && array[stack.peek()] >= array[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.printf("The nearest smaller element indices array is: %s%n", Arrays.toString(result));
    }

    public static void getNearestSmallerElementDistancesInGivenArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            while(!stack.isEmpty() && array[stack.peek()] >= array[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i);
        }

        System.out.printf("The nearest smaller element distances array is: %s%n", Arrays.toString(result));
    }


    public static void getNearestLargerElementsInRightForGivenArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];

        for(int i = array.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(array[i]);
        }

        System.out.printf("The nearest larger elements in right side array is: %s%n", Arrays.toString(result));
    }
}
