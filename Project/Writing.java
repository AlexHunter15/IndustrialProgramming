import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataWriter {

    // Запись данных в plain text файл
    public static void writePlainText(String filePath, String data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        }
    }

    // Запись данных в XML файл
    public static void writeXML(String filePath, String data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        }
    }

    // Запись данных в JSON файл
    public static void writeJSON(String filePath, JSONObject data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data.toString());
        }
    }

    public static void main(String[] args) {
        // Пример использования
        String plainTextData = "This is plain text data.";
        String xmlData = "<root><element>XML Data</element></root>";
        JSONObject jsonData = new JSONObject();
        jsonData.put("key1", "value1");
        jsonData.put("key2", "value2");

        try {
            writePlainText("plain_text_output.txt", plainTextData);
            System.out.println("Data written to plain text file.");

            writeXML("xml_output.xml", xmlData);
            System.out.println("Data written to XML file.");

            writeJSON("json_output.json", jsonData);
            System.out.println("Data written to JSON file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
