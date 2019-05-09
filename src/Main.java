import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainMenuController.class.getResource("MainMenu.fxml"));
        AnchorPane mainPane = loader.load();
        primaryStage.setScene(new Scene(mainPane, 1280, 720));
        primaryStage.setResizable(false);

        primaryStage.show();
        System.out.println("Scene should appear now");
    }
}
