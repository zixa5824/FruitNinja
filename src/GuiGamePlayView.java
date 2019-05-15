import GameModes.ClassicMode;
import SliceableObjects.ISliceableObject;
import SliceableObjects.NormalFruit;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GuiGamePlayView {

    private Scene scene;
    private AnimationTimer timer;
    private Random random = new Random();
   //THIS IS ONLY FOR TRIAL SCORE LOOK
    //private int score = 0;
    private Boolean scoreFlag = false;
    private double velocityY,velocityX;
    private List<ISliceableObject> currentObjects;

    GuiGamePlayView(Stage stage)
    {
            //GAME CONTROLLER
            GameController gameController = GameController.getInstance();
            ClassicMode gameMode = new ClassicMode();
            gameController.newGame(gameMode);
            currentObjects = gameController.createGameObject(0);
            ////////////////////////////////////////////////////
            //-------
            Image image = new Image("file:backgroundClassic.jpg");
            ImageView ivBackGround = new ImageView(image);
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
            //-------
            Ellipse ellipse = new Ellipse(120, 50);
            ellipse.setFill(Color.DARKRED);
            ellipse.setLayoutX(601);
            ellipse.setLayoutY(64);
            ellipse.setOpacity(0.5);
            //------
        //////////////////////////////////////////////////////////////////////






        currentObjects = gameController.createGameObject(0);
        ImageView ivApple = currentObjects.get(0).getImageView()[0];
        ivApple.setFitHeight(150);
        ivApple.setFitWidth(131);
        ivApple.setPreserveRatio(false);
        //STARTING LOCATION
        ivApple.setLayoutY(800);
        ivApple.setLayoutX(300);

        Path path = new Path();
        path.getElements().add (new MoveTo(1200, 800));

        RotateTransition appleRotate = new RotateTransition(Duration.millis(4500), ivApple);
        appleRotate.setCycleCount(3);
        appleRotate.setFromAngle(0);
        appleRotate.setToAngle(360);

        //ANIMATION TIMER , MAIN MOVEMENT

        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);

        ArrayList<ISliceableObject> myObjects = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToRemove = new ArrayList<>();

        pane.getChildren().addAll(ivBackGround, ellipse, scoreLabel);

        for (ISliceableObject object:myObjects
        ) {
            pane.getChildren().add(object.getImageView()[0]);
        }

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (myObjects.size() < 1) {
//                    ISliceableObject newFruit = new NormalFruit();
//                    myObjects.add(newFruit);
                    List<ISliceableObject> newMyObjects = gameController.createGameObject(1);
                    myObjects.addAll(newMyObjects);

                    for (ISliceableObject object:myObjects
                         ) {
                        pane.getChildren().add(object.getImageView()[0]);
                    }


                }
                for (ISliceableObject fruit:myObjects
                     ) {
                    fruit.move(3);
                    fruit.getImageView()[0].setLayoutY(fruit.getYlocation());
                    fruit.getImageView()[0].setLayoutX(fruit.getXlocation());
                }
                for (ISliceableObject fruit:myObjects
                     ) {
                    if(fruit.getYlocation() > 900)
                        objectsToRemove.add(fruit);
                }
                myObjects.removeAll(objectsToRemove);
            }
        };
        timer.start();

//
//        ivApple.setOnMouseMoved(e-> {
//            ivApple.setImage(appleCut);
//        });


    }

    public Scene getScene() {
        return scene;
    }
}