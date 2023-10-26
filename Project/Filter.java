import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFilterWithRegex {

    // Метод для фильтрации данных с использованием регулярных выражений
    public static String filterData(String inputText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        StringBuilder filteredText = new StringBuilder();
        while (matcher.find()) {
            filteredText.append(matcher.group()).append("\n");
        }

        return filteredText.toString();
    }

    public static void main(String[] args) {
        // Пример использования
        String inputText = "This is some sample text with numbers: 123, 456, and 789.";
        String regex = "\\d+"; // Регулярное выражение для поиска чисел

        String filteredData = filterData(inputText, regex);
        System.out.println("Filtered Data:\n" + filteredData);
    }
}
