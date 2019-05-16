import Game.GameController;
import SliceableObjects.ISliceableObject;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
            scoreLabel.setFont(Font.font("Bradley Hand ITC", 22));
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
        //////////////////////////////////////////////////////////////////////


//        RotateTransition appleRotate = new RotateTransition(Duration.millis(4500), ivApple);
//        appleRotate.setCycleCount(3);
//        appleRotate.setFromAngle(0);
//        appleRotate.setToAngle(360);

        //ANIMATION TIMER , MAIN MOVEMENT

        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);

        ArrayList<ISliceableObject> myObjects = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToRemove = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToSlice = new ArrayList<>();
        HashMap<ImageView, ISliceableObject> objectsOnScreen = new HashMap<>();

        pane.getChildren().addAll(ivBackGround, ellipse, scoreLabel);

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

                    for (ISliceableObject object:myObjects
                         ) {
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
                for (ISliceableObject fruit:myObjects
                     ) {
                    fruit.move(3);
                    fruit.getImageView().setLayoutY(fruit.getYlocation());
                    fruit.getImageView().setLayoutX(fruit.getXlocation());
                }
                for (ISliceableObject fruit:myObjects
                     ) {
                    if(fruit.getYlocation() > 900)
                        objectsToRemove.add(fruit);
                }
                slice(objectsToSlice);
                objectsToSlice.clear();
                myObjects.removeAll(objectsToRemove);
                objectsToRemove.clear();
                scoreLabel.setText("Current Score: "+ gameController.getScore());
            ///////////////////////////////////////////////////////////////////////////////




            }
        };
        timer.start();





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
    }

    public Scene getScene() {
        return scene;
    }
}