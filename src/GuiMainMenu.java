import Game.GameController;
import GameModes.ClassicMode;
import GameModes.IGameModeStrategy;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class GuiMainMenu{

    private Scene scene;

    GuiMainMenu(Stage stage)
    {
        //-------
        Image image = new Image("file:oneto.jpg");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFocusTraversable(false);
        ivBackGround.setFitWidth(1220);
        ivBackGround.setFitHeight(820);

        //-------

        //-------
        Button classicBtn = new Button("Classic");
        Circle circle = new Circle(50);
        classicBtn.setPrefWidth(134);
        classicBtn.setPrefHeight(80);
        classicBtn.setLayoutX(533);
        classicBtn.setLayoutY(256);
        classicBtn.setOpacity(0.85);
        classicBtn.setShape(circle);
        classicBtn.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
        classicBtn.setTextFill(Paint.valueOf("White"));
        //--------
        Button arcadeBtn = new Button("Arcade");
        arcadeBtn.setPrefWidth(134);
        arcadeBtn.setPrefHeight(80);
        arcadeBtn.setLayoutX(533);
        arcadeBtn.setLayoutY(369);
        arcadeBtn.setOpacity(0.85);
        arcadeBtn.setShape(circle);
        arcadeBtn.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
        arcadeBtn.setTextFill(Paint.valueOf("White"));
        //-------
        //--------
        Button scoreBoard = new Button("Score Board");
        scoreBoard.setPrefWidth(134);
        scoreBoard.setPrefHeight(80);
        scoreBoard.setLayoutX(533);
        scoreBoard.setLayoutY(503);
        scoreBoard.setOpacity(0.85);
        scoreBoard.setShape(circle);
        scoreBoard.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreBoard.setTextFill(Paint.valueOf("White"));
        //-------

        //-----
        classicBtn.setOnAction(e->{
            GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
            IGameModeStrategy gameMode = new ClassicMode();
            GameController.getInstance().newGame(gameMode);
            stage.setScene(guiGameplayView.getScene());
            stage.centerOnScreen();
        });
        //-----

        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);
        pane.getChildren().addAll(ivBackGround, classicBtn, scoreBoard, arcadeBtn);
    }

    public Scene getScene() {
        return scene;
    }
}
		
		
		
		


	  
	
	

