import Game.GameController;
import GameModes.*;
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
        Image image = new Image("file:fruit_ninja.gif");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFocusTraversable(false);
        ivBackGround.setFitWidth(1200);
        ivBackGround.setFitHeight(800);

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
        Button scoreBoard = new Button("SCORE BOARD");
        scoreBoard.setPrefWidth(134);
        scoreBoard.setPrefHeight(80);
        scoreBoard.setLayoutX(533);
        scoreBoard.setLayoutY(450);
        scoreBoard.setOpacity(0.85);
        scoreBoard.setShape(circle);
        scoreBoard.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreBoard.setTextFill(Paint.valueOf("White"));
        //-------
        Button contuine = new Button("CONTINUE");
        contuine.setPrefWidth(134);
        contuine.setPrefHeight(80);
        contuine.setLayoutX(533);
        contuine.setLayoutY(600);
        contuine.setOpacity(0.85);
        contuine.setShape(circle);
        contuine.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        contuine.setTextFill(Paint.valueOf("White"));
        //-------
        //-----
        classicBtn.setOnAction(e->{
            IGameModeStrategy gameMode = new ClassicMode();
            IGameModeStrategy hard = new EasyDiff(gameMode);
            GameController.getInstance().newGame(hard);
//            GameController.getInstance().newGame(gameMode);
            GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
            stage.setScene(guiGameplayView.getScene());
            stage.centerOnScreen();
        });
        //-----
        arcadeBtn.setOnAction(e->{
            IGameModeStrategy gameMode = new ArcadeMode();
            GameController.getInstance().newGame(gameMode);
            GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
            stage.setScene(guiGameplayView.getScene());
            stage.centerOnScreen();
        });
        //-----
        
        
        scoreBoard.setOnAction(e->{
            // bisho; when scoreboard scene is finished should be wired later
        });
        
        
        
        
        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);
        pane.getChildren().addAll(ivBackGround, classicBtn, scoreBoard, arcadeBtn,contuine);
    }

    public Scene getScene() {
        return scene;
    }
}
		
		
		
		


	  
	
	

