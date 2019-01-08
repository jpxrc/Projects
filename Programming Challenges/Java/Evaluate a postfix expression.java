/*
Kata Name: Evaluate a postfix expression
Problem Task:
Imagine you are in a universe where you can just perform the following arithematic operations. Addition(+), Subtraction(-), Multiplication(*), Division(/). You are given given a postfix expression. Postfix expression is where operands come after operator. Each operator and operand are seperated by a space. You need to evaluate the expression.
For example: 25 45 + is equivalent of 25 + 45, hence the answer would be 70. Instead if you are given 20 40 + 60 *, it is equivalent of (20+40) * 60, hence the answer should be 3600. 20 40 60 + * is equivalent of 20 * (40 + 60) = 2000.
Create a method 'evaluate' that takes a string as input and returns a long resulted in the evaluation. Just concentrate on happy paths. Assume that expression is always valid and division is always an integer division.

Sample Tests:
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EvaluatorTest {
    @Test
    public void test1() throws Exception {
        Evaluator eval = new Evaluator();
        assertEquals(10, eval.evaluate("2 3 9 4 / + *"));
    }
} 

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Evaluator {

    private static final String OPERATORS = "+-*/";

    public long evaluate(String expression) {

        Deque<Long> numbers = new ArrayDeque<>();

        String[] strings = expression.split("\\s");
        for (String s : strings) {
            if (isOperator(s)) {
                Long last = numbers.pop();
                numbers.push(performOperation(numbers.pop(), last, s));
            } else {
                numbers.push(Long.valueOf(s));
            }
        }

        return numbers.pop();
    }

    private boolean isOperator(String s) {
        return OPERATORS.contains(s);
    }

    private long performOperation(long n1, long n2, String operation) {
        switch (operation) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                throw new UnsupportedOperationException(operation);
        }
    }
}