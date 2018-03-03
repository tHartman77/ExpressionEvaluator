import java.text.DecimalFormat;

/**
 * This class shows example usage of the ExpressionEvaluator class
 * <p>
 * Example usage: java ExpressionEvauatorExample "+ 1 2"
 *
 * @author  Tim Hartman
 */
public class ExpressionEvaluatorExample {

    public static void main(String args[]){
        if (args.length != 1)
            throw new IllegalArgumentException("\nMust provide one expression to evaluate (Example: \"+ 1 2\")");

        DecimalFormat formatter = new DecimalFormat();
        formatter.setDecimalSeparatorAlwaysShown(false);
        double result = ExpressionEvaluator.evaluate(args[0]);
        System.out.println(args[0] + " = " + formatter.format(result));
    }
}
