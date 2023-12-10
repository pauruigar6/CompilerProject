/*
 * MainCompiler Class
 *
 * This class contains the main method for the mathematical expression compiler.
 * It takes user input for mathematical operations, processes them using the Compiler class,
 * and displays the results of lexical analysis, syntax analysis, and expression evaluation.
 *
 * Class Fields:
 * - None
 *
 * Main Method:
 * - main(String[] args): The entry point of the application. It prompts the user for mathematical operations
 *   until the user enters "END," processing each operation using the Compiler class.
 *   It then displays the results.
 *
 * Utility Method:
 * - procesarOperacion(String input): Takes a mathematical operation as input, creates an instance of the Compiler class,
 *   and calls the displayResult() method to showcase the lexical analysis, syntax analysis, and result of evaluation.
 */

package src;

import java.util.Scanner;

public class MainCompiler {

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("\nEnter a mathematical operation: ");
            input = scanner.nextLine();

            if (!input.equals("END")) {
                processOperation(input);
            }

        } while (!input.equals("END"));

        scanner.close();
    }

    // Utility method to process a mathematical operation
    private static void processOperation(String input) {
        Compiler compiler = new Compiler(input);
        compiler.displayResult();
    }
}
