import java.util.Stack;
import java.util.Collections;
import java.util.Arrays;

/**
 * The ExpressionEvaluator class evaulates prefix mathematical expressions.
 * <p>
 * This class assumes that expressions are already in valid prefix notation.
 * Both integers and floating point numbers are valid. Only '+' and '-' are
 * valid operators.
 *
 * @author  Tim Hartman
 */
public final class ExpressionEvaluator {

    private ExpressionEvaluator() {}

    /**
     * Returns the mathematical result of a prefix expression.
     *
     * @param   expression  a mathematical expression in prefix notation
     * @return              result of calculting the expression
     */
    public static double evaluate(String expression) {
        String[] symbols = expression.split(" ");
        Stack<Double> calc = new Stack<Double>();

        //Goes through the expression backwards
        Collections.reverse(Arrays.asList(symbols));
        for(String symbol : symbols){

            //If current symbol is an operator, get last 2 numbers
            //and calculate intermediate result, then push to stack
            if(isOperator(symbol)){
                double operandA = calc.pop();
                double operandB = calc.pop();

                switch(symbol){
                    case "+":
                        calc.push(operandA + operandB);
                        break;
                    case "-":
                        calc.push(operandA - operandB);
                        break;
                }
            } else { //put number on stack
                calc.push(Double.parseDouble(symbol));
            }
        }
        //Only one number remains on the stack, the result
        return calc.peek();
    }

    /**
     * Checks if the given symbol is an operator.
     * <p>
     * Valid operators are '+' or '-'. Anything else is considered invalid
     *
     * @param   symbol  the String that is checked to be an operator
     * @return          a boolean indicating if the symbol is an operator
     */
    private static boolean isOperator(String symbol){
        return symbol.matches("[+-]");
    }
}
