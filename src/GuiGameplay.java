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


public class GuiGamePlay {

    private Scene scene;
    private AnimationTimer timer;
    private Random random = new Random();
   //THIS IS ONLY FOR TRIAL SCORE LOOK
    //private int score = 0;
    private Boolean scoreFlag = false;
    private double velocityY,velocityX;
    private List<GameObject> currentObjects;

    GuiGamePlay(Stage stage)
    {

        //GAME CONTROLLER
        Controller controller = Controller.getInstance();
        //-------
        Image image = new Image("file:backgroundClassic.jpg");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFocusTraversable(false);
        ivBackGround.setFitWidth(1220);
        ivBackGround.setFitHeight(820);
        //-------
        Label scoreLabel = new Label("Current Score:  " + controller.getScore());
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

        currentObjects = controller.createGameObject(0);
        Image apple = currentObjects.get(0).getImages()[0];
        ImageView ivApple = new ImageView(apple);
        ivApple.setFitHeight(150);
        ivApple.setFitWidth(131);
        ivApple.setPreserveRatio(false);
        //STARTING LOCATION
        ivApple.setLayoutY(800);
        ivApple.setLayoutX(300);
        Image appleCut = currentObjects.get(0).getImages()[1];

        Path path = new Path();
        path.getElements().add (new MoveTo(1200, 800));

        velocityY = currentObjects.get(0).getYVelocity();
        velocityX = currentObjects.get(0).getXVelocity();
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
                ivApple.setLayoutY(ivApple.getLayoutY() - (velocityY -= random.nextDouble() * 0.0775 + 0.065));
                if(ivApple.getImage() == appleCut && scoreFlag == false){controller.scoreEdit(30); scoreFlag = true;}
                scoreLabel.setText("Current Score: " + controller.getScore());
                if(ivApple.getLayoutY() > 800)
                {
                    ivApple.setImage(apple);
                    ivApple.setLayoutX(random.nextDouble() * 725 + 310);
                    ivApple.setLayoutY(800);
                    velocityY = currentObjects.get(0).getYVelocity();
                    scoreFlag = false;
                    if(ivApple.getLayoutX() > 530)
                    {
                        velocityX = -velocityX;
                    }
                    else if(ivApple.getLayoutX() < 530)
                        if(velocityX < 0)   velocityX = -velocityX;
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
        pane.getChildren().addAll(ivBackGround, ivApple, ellipse, scoreLabel);
    }

    public Scene getScene() {
        return scene;
    }
}