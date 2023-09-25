import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: FileProcessor <input_file> <output_file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            processFile(inputFile, outputFile);
            System.out.println("File processing completed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void processFile(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String processedLine = processLine(line);
            writer.write(processedLine);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    public static String processLine(String line) {
        // Разделяем строку на слова
        String[] words = line.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (containsArithmeticOperation(word)) {
                // Если слово содержит арифметическую операцию, вычисляем результат
                try {
                    double value = evaluateArithmeticExpression(word);
                    result.append(value);
                } catch (NumberFormatException e) {
                    // Обработка ошибок, если вычисление не удалось
                    result.append("Error: Invalid expression");
                }
            } else {
                result.append(word);
            }

            result.append(" ");
        }

        return result.toString().trim();
    }

    public static boolean containsArithmeticOperation(String word) {
        return word.contains("+") || word.contains("-") || word.contains("*") || word.contains("/");
    }

    public static double evaluateArithmeticExpression(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder operand = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand.append(expression.charAt(i));
                    i++;
                }
                i--; // Возвращаемся на один символ назад, чтобы не пропустить оператор

                operands.push(Double.parseDouble(operand.toString()));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                    double b = operands.pop();
                    double a = operands.pop();
                    char operator = operators.pop();
                    operands.push(applyOperator(a, b, operator));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            double b = operands.pop();
            double a = operands.pop();
            char operator = operators.pop();
            operands.push(applyOperator(a, b, operator));
        }

        return operands.pop();
    }

    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    public static double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
