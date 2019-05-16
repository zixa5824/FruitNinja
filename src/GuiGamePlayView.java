import Game.GameController;
import SliceableObjects.ISliceableObject;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class GuiGamePlayView {

    private Scene scene;
    private AnimationTimer timer;
    private Random random = new Random();
   //THIS IS ONLY FOR TRIAL SCORE LOOK
    //private int score = 0;
    private Boolean scoreFlag = false;
    private List<ISliceableObject> currentObjects;
    GameController gameController = GameController.getInstance();


    GuiGamePlayView(Stage stage)
    {
        //GAME CONTROLLER
//            ClassicMode gameMode = new ClassicMode();
//            gameController.newGame(gameMode);
            ////////////////////////////////////////////////////
            //-------
            Image image = new Image("file:background.jpg");
            ImageView ivBackGround = new ImageView(image);
            ivBackGround.setMouseTransparent(true);
            ivBackGround.setPreserveRatio(false);
            ivBackGround.setFocusTraversable(false);
            ivBackGround.setFitWidth(1220);
            ivBackGround.setFitHeight(820);
            //-------
            Label scoreLabel = new Label("Current Score:  " + gameController.getScore());
            scoreLabel.setFont(Font.font("Calibri (Body)", 22));
            scoreLabel.setTextFill(Color.GOLDENROD);
            scoreLabel.setPrefHeight(49);
            scoreLabel.setPrefWidth(200);
            scoreLabel.setLayoutX(523);
            scoreLabel.setLayoutY(40);
            //-------
           
            Ellipse ellipse = new Ellipse(120, 50);
            ellipse.setMouseTransparent(true);
            ellipse.setFill(Color.DARKRED);
            ellipse.setLayoutX(601);
            ellipse.setLayoutY(64);
            ellipse.setOpacity(0.5);
            //------
 Label livesLabel = new Label("LIVES:  " + gameController.getLives());
            livesLabel.setFont(Font.font("Calibri (Body)", 22));
            livesLabel.setTextFill(Color.RED);
            livesLabel.setPrefHeight(49);
            livesLabel.setPrefWidth(200);
            livesLabel.setLayoutX(900);
            livesLabel.setLayoutY(40);
            //-------
            Ellipse ellipse1 = new Ellipse(80, 30);
            ellipse1.setFill(Color.YELLOW);
            ellipse1.setLayoutX(940);
            ellipse1.setLayoutY(64);
            ellipse1.setOpacity(0.5);
            //------
            Circle circle = new Circle(50);
            Button pauseBtn = new Button("PAUSE");
            pauseBtn.setPrefWidth(90);
            pauseBtn.setPrefHeight(50);
            pauseBtn.setLayoutX(40);
            pauseBtn.setLayoutY(50);
            pauseBtn.setOpacity(0.75);
            pauseBtn.setShape(circle);
            pauseBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            pauseBtn.setTextFill(Paint.valueOf("White"));
            Button contuineBtn= new Button("CONTUINE");
            contuineBtn.setPrefWidth(134);
            contuineBtn.setPrefHeight(80);
            contuineBtn.setLayoutX(533);
            contuineBtn.setLayoutY(200);
            contuineBtn.setShape(circle);
            contuineBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            contuineBtn.setTextFill(Paint.valueOf("White"));
            Button resetBtn = new Button("RESET");
            resetBtn.setPrefWidth(134);
            resetBtn.setPrefHeight(80);
            resetBtn.setLayoutX(533);
            resetBtn.setLayoutY(350);
            resetBtn.setShape(circle);
            resetBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            resetBtn.setTextFill(Paint.valueOf("White"));
            Button saveBtn = new Button("SAVE");
            saveBtn.setPrefWidth(134);
            saveBtn.setPrefHeight(80);
            saveBtn.setLayoutX(533);
            saveBtn.setLayoutY(500);
            saveBtn.setShape(circle);
            saveBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            saveBtn.setTextFill(Paint.valueOf("White"));
            Button returntomainBtn= new Button("RETURN TO MAIN MENU");
            returntomainBtn.setPrefWidth(200);
            returntomainBtn.setPrefHeight(80);
            returntomainBtn.setLayoutX(500);
            returntomainBtn.setLayoutY(650);
            returntomainBtn.setShape(circle);
            returntomainBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
            returntomainBtn.setTextFill(Paint.valueOf("White"));
            //--------
            contuineBtn.setVisible(false);
            saveBtn.setVisible(false);
            resetBtn.setVisible(false);
            returntomainBtn.setVisible(false);
            //---------
            
           
          
            resetBtn.setOnAction(e->{
            	
            	gameController.resetGame();
            	  GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
                  stage.setScene(guiGameplayView.getScene());
                  stage.centerOnScreen();
            });
            saveBtn.setOnAction(e->{
            	//bisho; work in progress left untill all variables are determined 
            });
            returntomainBtn.setOnAction(e->{
            	 GuiMainMenu g = new GuiMainMenu (stage);
                 stage.setScene(g.getScene());
                 stage.centerOnScreen();
            });
          
          
        //////////////////////////////////////////////////////////////////////


        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);

        ArrayList<ISliceableObject> myObjects = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToRemove = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToSlice = new ArrayList<>();
        HashMap<ImageView, ISliceableObject> objectsOnScreen = new HashMap<>();

        pane.getChildren().addAll(ivBackGround, ellipse, scoreLabel,livesLabel,ellipse1,pauseBtn,contuineBtn,resetBtn,saveBtn,returntomainBtn);

        for (ISliceableObject object:myObjects
        ) {
            pane.getChildren().add(object.getImageView());
        }

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (myObjects.size() < 1) {
                    List<ISliceableObject> newMyObjects = gameController.createGameObject(1);
                    myObjects.addAll(newMyObjects);

                    for (ISliceableObject object:myObjects) {
                        objectsOnScreen.put(object.getImageView(), object);
                        object.getImageView().setOnMouseMoved(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (objectsOnScreen.get(event.getTarget()).isSliced() == false) {
                                    objectsToSlice.add(objectsOnScreen.get(event.getTarget()));
                                }
                            }
                        });
                        pane.getChildren().add(object.getImageView());
                    }
                }
                for (ISliceableObject fruit:myObjects) {
                    fruit.move(3);
                    fruit.getImageView().setLayoutY(fruit.getYlocation());
                    fruit.getImageView().setLayoutX(fruit.getXlocation());
                }
                for (ISliceableObject fruit:myObjects) {
                    if(fruit.getYlocation() > 900)
                        objectsToRemove.add(fruit);
                }
                slice(objectsToSlice);
                objectsToSlice.clear();
                myObjects.removeAll(objectsToRemove);
                moveOffScreen(objectsToRemove);
                objectsToRemove.clear();
                scoreLabel.setText("Current Score: "+ gameController.getScore());
                livesLabel.setText("LIVES: "+ gameController.getLives());
            ///////////////////////////////////////////////////////////////////////////////




            }
        };
        timer.start();

        pauseBtn.setOnAction(e->{
        	returntomainBtn.setVisible(true);
        	   contuineBtn.setVisible(true);
               saveBtn.setVisible(true);
               resetBtn.setVisible(true);
               pauseBtn.setVisible(false);
        	timer.stop();
        });
        
        
        contuineBtn.setOnAction(e->{
        	returntomainBtn.setVisible(false);
        	   contuineBtn.setVisible(false);
               saveBtn.setVisible(false);
               resetBtn.setVisible(false);
               pauseBtn.setVisible(true);
        	
        timer.start();
        }); 


    }

  
    public void moveOffScreen(List<ISliceableObject> objectsToRemove) {//bisho: for when objects fall off screen 
        for (ISliceableObject object:objectsToRemove) {
        	 gameController.throwOffScreen(objectsToRemove);
        }
    }

    public void prepareForSlice(ImageView imageView)
    {

    }

    public void slice(List<ISliceableObject> objectsToSlice) {

        gameController.sliceObjects(objectsToSlice);
        for (ISliceableObject object:objectsToSlice
             ) {
            object.getImageView().setImage(object.getMyImage()[1]);
        }
        objectsToSlice.clear();
    }

    public Scene getScene() {
        return scene;
    }
}
