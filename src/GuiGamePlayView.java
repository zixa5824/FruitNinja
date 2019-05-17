import Game.GameController;
import SliceableObjects.ISliceableObject;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.text.FontWeight;
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
    private boolean flag=false;

    GuiGamePlayView(Stage stage)
    {
            //BISHO: KNOW PROBS FRUITS OVERLAY BUTTONS DURING PAUSE , FRUITS CUT NEEDS NEW IMAGES , TIMER IS SLIGHTLY TOO FAST AND NOT IN SYNC WITH ANIMATION TIMER
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
            scoreLabel.setFont(Font.font("Bradley Hand ITC", 22));
            scoreLabel.setTextFill(Color.GOLDENROD);
            scoreLabel.setPrefHeight(49);
            scoreLabel.setPrefWidth(200);
            scoreLabel.setLayoutX(523);
            scoreLabel.setLayoutY(40);
           
            //------
         
            Label livesLabel = new Label("LIVES:  " + gameController.getLives()); //bisho: new live counter
            livesLabel.setFont(Font.font("", 22));
            livesLabel.setTextFill(Color.RED);
            livesLabel.setPrefHeight(49);
            livesLabel.setPrefWidth(200);
            livesLabel.setLayoutX(900);
            livesLabel.setLayoutY(40);
            if(gameController.getLives()<0) {
            	livesLabel.setVisible(false);
            }
            
            
          
            Label timerLabel = new Label("LIVES:  " + gameController.getLives()); //bisho: new timer for arcade
            timerLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
            timerLabel.setTextFill(Color.YELLOW);
            timerLabel.setPrefHeight(49);
            timerLabel.setPrefWidth(200);
            timerLabel.setLayoutX(900);
            timerLabel.setLayoutY(40);
            if(gameController.getTime()<0) {
              	timerLabel.setVisible(false);
                }
            
            
            
            
            //-------
            Ellipse ellipse = new Ellipse(120, 50);
            ellipse.setMouseTransparent(true);
            ellipse.setFill(Color.DARKRED);
            ellipse.setLayoutX(601);
            ellipse.setLayoutY(64);
            ellipse.setOpacity(0.5);
            //-------
            Ellipse ellipse1 = new Ellipse(80, 30);
            ellipse1.setFill(Color.YELLOW);
            ellipse1.setLayoutX(940);
            ellipse1.setLayoutY(64);
            ellipse1.setOpacity(0.5);
            if(gameController.getLives()<0) {
              	ellipse1.setVisible(false);
                }
            //------
            Ellipse ellipse2 = new Ellipse(120, 30);
            ellipse2.setFill(Color.GREEN);
            ellipse2.setLayoutX(985);
            ellipse2.setLayoutY(64);
            ellipse2.setOpacity(0.5);
            if(gameController.getTime()<0) {
              	ellipse2.setVisible(false);
                }
            //-------
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

        pane.getChildren().addAll(ivBackGround, ellipse, scoreLabel,livesLabel,ellipse1,ellipse2,pauseBtn,contuineBtn,resetBtn,saveBtn,returntomainBtn,timerLabel);

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
                gameController.updateObjectsLocations(myObjects, objectsToRemove);


                slice(objectsToSlice);
                objectsToSlice.clear();
                myObjects.removeAll(objectsToRemove);
                moveOffScreen(objectsToRemove);
                objectsToRemove.clear();
                gameController.timeEdit((double)-1/30); //bisho: NOT IN SYNC WITH ANIMATION TIMER YET TO FIX LATER
                scoreLabel.setText("Current Score: "+ gameController.getScore());
                livesLabel.setText("LIVES: "+ gameController.getLives());
                timerLabel.setText("TIME LEFT: "+(int) gameController.getTime());
                if(gameController.checkGameOver()) {
                    endGame();
    			}
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

    public void endGame() {
        timer.stop();
        Alert Alert1 = new Alert(AlertType.INFORMATION);
        Alert1.setTitle("GAME OVER");
        Alert1.setContentText("YOUR SCORE  "+gameController.getScore());
        Alert1.setHeaderText(null);
        Alert1.show();
    }
  
  
    public void moveOffScreen(List<ISliceableObject> objectsToRemove) {//bisho: for when objects fall off screen
        gameController.throwOffScreen(objectsToRemove);
    }



    public void slice(List<ISliceableObject> objectsToSlice) {

        gameController.sliceObjects(objectsToSlice);

        for (ISliceableObject object:objectsToSlice
             ) {
            object.getImageView().setImage(object.getMyImage()[1]);
        }
    }

    public Scene getScene() {
        return scene;
    }
}