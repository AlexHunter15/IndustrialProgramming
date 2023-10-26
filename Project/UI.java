import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример JavaFX UI");

        Label label = new Label("Выберите действие:");
        Button readButton = new Button("Чтение данных из файла");
        Button processButton = new Button("Обработка данных");
        Button writeButton = new Button("Запись данных в файл");
        Button exitButton = new Button("Выход");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, readButton, processButton, writeButton, exitButton);
        Scene scene = new Scene(layout, 300, 200);

        readButton.setOnAction(e -> {
            // Обработка нажатия кнопки "Чтение данных из файла"
            System.out.println("Выбрано: Чтение данных из файла");
        });

        processButton.setOnAction(e -> {
            // Обработка нажатия кнопки "Обработка данных"
            System.out.println("Выбрано: Обработка данных");
        });

        writeButton.setOnAction(e -> {
            // Обработка нажатия кнопки "Запись данных в файл"
            System.out.println("Выбрано: Запись данных в файл");
        });

        exitButton.setOnAction(e -> {
            // Обработка нажатия кнопки "Выход"
            System.out.println("Программа завершена.");
            System.exit(0);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
