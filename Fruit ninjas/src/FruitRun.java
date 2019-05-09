    
import javafx.application.Application;
import javafx.stage.Stage;

public class FruitRun extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GuiMainMenu guiNinjaMainMenu = new GuiMainMenu(primaryStage);
        primaryStage.setScene(guiNinjaMainMenu.getScene());
        primaryStage.setTitle("Ninja Fruit");
        primaryStage.centerOnScreen();
        primaryStage.show();
        primaryStage.setResizable(false);

    }
}