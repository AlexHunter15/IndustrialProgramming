import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader {

    // Чтение данных из plain text файла
    public static String readPlainText(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Чтение данных из XML файла
    public static String readXML(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    // Чтение данных из JSON файла
    public static JSONObject readJSON(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return new JSONObject(content.toString());
    }

    public static void main(String[] args) {
        try {
            // Пример чтения данных из разных файлов
            String plainTextData = readPlainText("plain_text_file.txt");
            System.out.println("Plain Text Data:\n" + plainTextData);

            String xmlData = readXML("xml_file.xml");
            System.out.println("XML Data:\n" + xmlData);

            JSONObject jsonData = readJSON("json_file.json");
            System.out.println("JSON Data:\n" + jsonData.toString(4)); // Отформатированный вывод JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
