import Game.GameController;
import GameModes.*;
import GameModes.IGameModeStrategy;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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

import java.util.Optional;


public class GuiMainMenu{

    private Scene scene;
   private  GameController c=GameController.getInstance();
	    GuiMainMenu(Stage stage)
    {       
	    	
	    	 GameController c=GameController.getInstance();
    		
        //-------
        Image image = new Image("file:oneto.jpg");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFitWidth(1220);
        ivBackGround.setFitHeight(820);

        //-------

        //-------
        Button classicBtn = new Button("CLASSIC");
        Circle circle = new Circle(50);
        classicBtn.setPrefWidth(134);
        classicBtn.setPrefHeight(80);
        classicBtn.setLayoutX(533);
        classicBtn.setLayoutY(150);
        classicBtn.setOpacity(0.85);
        classicBtn.setShape(circle);
        classicBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        classicBtn.setTextFill(Paint.valueOf("White"));
        //--------
        Button arcadeBtn = new Button("ARCADE");
        arcadeBtn.setPrefWidth(134);
        arcadeBtn.setPrefHeight(80);
        arcadeBtn.setLayoutX(533);
        arcadeBtn.setLayoutY(300);
        arcadeBtn.setOpacity(0.85);
        arcadeBtn.setShape(circle);
        arcadeBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        arcadeBtn.setTextFill(Paint.valueOf("White"));
        //-------
        //--------
        Button scoreBoardBtn = new Button("SCORE BOARD");
        scoreBoardBtn.setPrefWidth(134);
        scoreBoardBtn.setPrefHeight(80);
        scoreBoardBtn.setLayoutX(533);
        scoreBoardBtn.setLayoutY(450);
        scoreBoardBtn.setOpacity(0.85);
        scoreBoardBtn.setShape(circle);
        scoreBoardBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreBoardBtn.setTextFill(Paint.valueOf("White"));
        //-------
        //-----
        classicBtn.setOnAction(e->{
            IGameModeStrategy gameMode = new ClassicMode();
            chooseDifficulty(gameMode, stage);
        });
        //-----
        arcadeBtn.setOnAction(e->{
            IGameModeStrategy gameMode = new ArcadeMode();
            chooseDifficulty(gameMode, stage);
        });
        //-----
        
        
        scoreBoardBtn.setOnAction(e->{
            // bisho; when scoreboard scene is finished should be wired later
        	ScoreBoard s = new ScoreBoard(stage);
            stage.setScene(s.getScene());
        });
        
        

        
        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);
        pane.getChildren().addAll(ivBackGround, classicBtn, scoreBoardBtn, arcadeBtn);
    }

    public void chooseDifficulty(IGameModeStrategy gameMode, Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Difficulty Options");
        alert.setHeaderText("Please choose one difficulty from below");
        ButtonType buttonTypeOne = new ButtonType("Easy");
        ButtonType buttonTypeTwo = new ButtonType("Medium");
        ButtonType buttonTypeThree = new ButtonType("Hard");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
           c.newGame(new EasyDiff(gameMode));
            c.setDifficulty(1);
        } else if (result.get() == buttonTypeTwo) {
           c.newGame(gameMode);
            c.setDifficulty(2);
        } else if (result.get() == buttonTypeThree) {
           c.newGame(new HardDiff(gameMode));
            c.setDifficulty(3);
        }
        else
            return;

        GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
        stage.setScene(guiGameplayView.getScene());
        stage.centerOnScreen();

    }

    public Scene getScene() {
        return scene;
    }
}
		
		
		
		


	  
	
	

