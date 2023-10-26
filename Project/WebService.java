import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestWebServiceApplication.class, args);
    }
}

@RestController
class DataController {

    @GetMapping("/readData")
    public String readData() {
        // Ваш код для чтения данных из файла или базы данных
        return "Прочитанные данные";
    }

    @GetMapping("/processData")
    public String processData() {
        // Ваш код для обработки данных
        return "Обработанные данные";
    }

    @GetMapping("/writeData")
    public String writeData() {
        // Ваш код для записи данных в файл или базу данных
        return "Данные записаны";
    }
}
