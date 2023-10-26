import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticOperationHandler {

    // Метод для обработки текста и замены арифметических операций на результаты
    public static String processArithmeticOperations(String inputText) {
        // Паттерн для поиска арифметических выражений
        String regex = "(-?\\d+(\\.\\d+)?)([+\\-*/])(-?\\d+(\\.\\d+)?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        StringBuffer resultBuffer = new StringBuffer();

        // Поиск и замена арифметических операций
        while (matcher.find()) {
            double operand1 = Double.parseDouble(matcher.group(1));
            double operand2 = Double.parseDouble(matcher.group(4));
            String operator = matcher.group(3);

            double result = performOperation(operand1, operand2, operator);
            matcher.appendReplacement(resultBuffer, String.valueOf(result));
        }

        matcher.appendTail(resultBuffer);

        return resultBuffer.toString();
    }

    // Метод для выполнения арифметической операции
    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    // Обработка деления на ноль
                    throw new ArithmeticException("Division by zero");
                }
            default:
                // Неизвестный оператор
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        // Пример использования
        String inputText = "2 + 3.5 * 4 - 6 / 2";
        String result = processArithmeticOperations(inputText);
        System.out.println("Processed Text: " + result);
    }
}
