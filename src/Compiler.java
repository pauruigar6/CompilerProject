/*
 * Compiler Class
 *
 * This class represents a simple compiler for mathematical expressions.
 * It performs lexical analysis, syntax analysis, and expression evaluation.
 *
 * Class Fields:
 * - input: The input mathematical expression to be processed.
 * - stackString: A string used to store tokens during lexical analysis.
 * - keywords: A string containing supported mathematical operations.
 * - syntaxResult: A string to store the result of syntax analysis.
 * - currentState: An integer representing the current state during lexical analysis.
 * - stack1 and stack2: Deques used for syntax analysis and expression evaluation.
 *
 * Constructors:
 * - Compiler(String input): Initializes the Compiler with the given mathematical expression.
 *
 * Methods: 
 * - performLexicalAnalysis(): Performs lexical analysis on the input expression.
 * - performSyntaxAnalysis(): Performs syntax analysis on the tokenized expression.
 * - evaluateExpression(): Evaluates the expression based on syntax analysis.
 * - keyToChar(String token): Converts a keyword token to its corresponding mathematical operator.
 * - displayResult(): Orchestrates the entire compilation process and displays the result.
 */

package src;

import java.util.Deque;
import java.util.LinkedList;

public class Compiler {
    private String input;
    private String stackString = "";
    private String keywords = "add sub mul div mod pow";
    private String syntaxResult = "";
    private int currentState = 0;
    private Deque<String> stack1 = new LinkedList<>();
    private Deque<String> stack2 = new LinkedList<>();

    // Constructor
    public Compiler(String input) {
        this.input = input;
    }

    // Method for lexical analysis
    public void performLexicalAnalysis() {
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (currentState == 0) {
                if (Character.isLetter(character)) {
                    stackString = stackString + input.charAt(i);
                    currentState = 1;
                }
            } else if (currentState == 1) {
                if (Character.isLetter(character)) {
                    stackString = stackString + input.charAt(i);
                } else if (character == '(') {
                    if (keywords.contains(stackString)) {
                        stack1.push(stackString);
                        stack2.push(stackString);
                        stackString = "";
                    } else {
                        throw new IllegalArgumentException("No hay ninguna función existente para: " + stackString);
                    }
                    currentState = 2;
                }
            } else if (currentState == 2) {
                if (Character.isLetter(character)) {
                    stackString = stackString + input.charAt(i);
                    currentState = 1;
                } else if (Character.isDigit(character) || character == '+' || character == '-') {
                    stackString = stackString + input.charAt(i);
                    currentState = 3;
                }
            } else if (currentState == 3) {
                if (Character.isDigit(character) || character == 'e') {
                    stackString = stackString + input.charAt(i);
                } else if (character == ',' || character == ')') {
                    stack1.push(stackString);
                    stack2.push(stackString);
                    stackString = "";
                    currentState = 2;
                }
            }
        }
    }

    // Method for syntax analysis
    public String performSyntaxAnalysis() {
        String currentToken = stack1.getLast();
        String result = "";
        stack1.removeLast();

        if (keywords.contains(currentToken)) {
            String operator = keyToChar(currentToken);
            if (operator.equals("+") || operator.equals("-") || operator.equals("^")) {
                result = result + performSyntaxAnalysis() + operator + performSyntaxAnalysis();
            } else {
                result = result + performSyntaxAnalysis() + operator + "(" + performSyntaxAnalysis() + ")";
            }
        } else {
            result = currentToken;
        }

        return syntaxResult = result;
    }

    // Method for expression evaluation
    public Double evaluateExpression() {
        String currentToken = stack2.getLast();
        stack2.removeLast();
        Double result = 0.0;

        if (keywords.contains(currentToken)) {
            String operator = keyToChar(currentToken);
            switch (operator) {
                case "+":
                    result = evaluateExpression() + evaluateExpression();
                    break;
                case "*":
                    result = evaluateExpression() * evaluateExpression();
                    break;
                case "-":
                    result = evaluateExpression() - evaluateExpression();
                    break;
                case "%":
                    result = evaluateExpression() % evaluateExpression();
                    break;
                case "^":
                    result = Math.pow(evaluateExpression(), evaluateExpression());
                    break;
                default:
                    result = evaluateExpression() / evaluateExpression();
                    break;
            }
        } else {
            result = Double.parseDouble(currentToken);
        }

        return result;
    }

    // Utility method to convert keyword token to mathematical operator
    public String keyToChar(String token) {
        String result = "";
        if (token.equals("add")) {
            result = "+";
        } else if (token.replaceAll("\\s", "").equals("mul")) {
            result = "*";
        } else if (token.replaceAll("\\s", "").equals("sub")) {
            result = "-";
        } else if (token.replaceAll("\\s", "").equals("pow")) {
            result = "^";
        } else if (token.replaceAll("\\s", "").equals("div")) {
            result = "/";
        } else {
            result = "%";
        }
        return result;
    }

    // Method to display the result of the compilation process
    public void displayResult() {
        performLexicalAnalysis();
        System.out.println("\nInput: " + input);
        System.out.println("Ouput: " + performSyntaxAnalysis());
        System.out.println("Result: " + evaluateExpression());
    }
}
