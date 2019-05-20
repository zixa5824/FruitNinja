import Game.GameController;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class FruitRun extends Application {

    private RemoteControl rem =new RemoteControl();
    private Command comm= new FileCommand();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GameController gameController = GameController.getInstance();
        rem.setCommand(comm);//bisho: comand design pattern
        rem.unactivateButton();//bisho: loads
        GuiMainMenu guiNinjaMainMenu = new GuiMainMenu(primaryStage);
        primaryStage.setScene(guiNinjaMainMenu.getScene());
        primaryStage.setTitle("Ninja SliceableObjects.Fruit");
        primaryStage.centerOnScreen();
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
