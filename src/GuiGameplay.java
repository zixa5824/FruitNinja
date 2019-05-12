import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.Random;


public class GuiGamePlay {

    private Scene scene;
    private AnimationTimer timer;
    private double velocityY;
    private double velocityX;
    private Random random = new Random();
   //THIS IS ONLY FOR TRIAL SCORE LOOK
    private int score = 0;
    private Boolean scoreFlag = false;

    GuiGamePlay(Stage stage)
    {

        //-------
        Image image = new Image("file:backgroundClassic.jpg");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFocusTraversable(false);
        ivBackGround.setFitWidth(1220);
        ivBackGround.setFitHeight(820);
        //-------
        Label scoreLabel = new Label("Current Score:  " + score);
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
        // ------
        Image apple = new Image("file:apple.png");
        ImageView ivApple = new ImageView(apple);
        ivApple.setFitHeight(150);
        ivApple.setFitWidth(131);
        ivApple.setPreserveRatio(false);
        //STARTING LOCATION
        ivApple.setLayoutY(800);
        ivApple.setLayoutX(300);
        //------
        Image appleCut = new Image("file:appleCUT.png");
        ImageView ivAppleCut = new ImageView(appleCut);
        ivAppleCut.setFitHeight(150);
        ivAppleCut.setFitWidth(131);
        ivAppleCut.setPreserveRatio(false);
        ivAppleCut.setVisible(false);
        //------

        //STARTING LOCATION
        ivAppleCut.setLayoutY(800);
        ivAppleCut.setLayoutX(800);
        //------

        Path path = new Path();
        path.getElements().add (new MoveTo(1200, 800));

        velocityY = 10;
        RotateTransition appleRotate = new RotateTransition(Duration.millis(4500), ivApple);
        appleRotate.setCycleCount(3);
        appleRotate.setFromAngle(0);
        appleRotate.setToAngle(360);

        //ANIMATION TIMER , MAIN MOVEMENT

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                appleRotate.play();
                ivApple.setLayoutX(ivApple.getLayoutX() + velocityX);
                ivApple.setLayoutY(ivApple.getLayoutY() - (velocityY -= random.nextDouble() * 0.0775 + 0.075));
                if(ivApple.getImage() == appleCut && scoreFlag == false){  score+=30; scoreFlag = true;}
                scoreLabel.setText("Current Score: " + score);
                if(ivApple.getLayoutY() > 800)
                {
                    ivApple.setImage(apple);
                    ivApple.setLayoutX(random.nextDouble() * 750 + 310);
                    ivApple.setLayoutY(800);
                    velocityY = 10;
                    scoreFlag = false;
                    if(ivApple.getLayoutX() > 530)
                    {
                        velocityX = -(1.5);
                    }
                    else if(ivApple.getLayoutX() < 530)
                        velocityX = 1.5;
                }
            }
        };
        timer.start();
        ivApple.setOnMouseMoved(e-> {
            ivApple.setImage(appleCut);
        });

        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);
        pane.getChildren().addAll(ivBackGround, ivApple, ivAppleCut,ellipse,scoreLabel);
    }

    public Scene getScene() {
        return scene;
    }
}