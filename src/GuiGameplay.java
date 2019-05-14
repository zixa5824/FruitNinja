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
    private ImageView[][] ivRandomFruits = new ImageView[6][2];
    private RotateTransition[] fruitsRotation;
    private boolean allFruitsAreDown =false;
    private int size;

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

        for (int i = 0; i < currentObjects.size() ; i++) {
            for (int j = 0; j < 2 ; j++)
            {
                ivRandomFruits[i][j].setImage(currentObjects.get(i).getImages()[j]);
                ivRandomFruits[i][j].setFitHeight(150);
                ivRandomFruits[i][j].setFitWidth(131);
                ivRandomFruits[i][j].setPreserveRatio(false);
                ivRandomFruits[i][j].setLayoutY(800);
                ivRandomFruits[i][j].setLayoutX(random.nextInt() * 750 + 300);
            }
            fruitsRotation[i] = new RotateTransition(Duration.millis(4500), ivRandomFruits[i][0]);
            fruitsRotation[i].setCycleCount(3);
            fruitsRotation[i].setFromAngle(0);
            fruitsRotation[i].setToAngle(360);
        }

        velocityY = currentObjects.get(0).getYVelocity();
        velocityX = currentObjects.get(0).getXVelocity();

        //ANIMATION TIMER , MAIN MOVEMENT

        size = currentObjects.size();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {



                for (int i = 0; i < currentObjects.size(); i++)
                {
                    if(ivRandomFruits[i][0].getLayoutY() > 800)
                    {
                        size--;
                        ivRandomFruits[i][0].setLayoutX(random.nextDouble() * 725 + 310);
                        ivRandomFruits[i][0].setLayoutY(800);
                        scoreFlag = false;
                    }
                }

                if(size == 0)
                {
                    allFruitsAreDown = true;
                }

                if(allFruitsAreDown)
                {
                    allFruitsAreDown = false;
                    currentObjects = controller.createGameObject(0);

                    for (int j = 0; j < currentObjects.size(); j++)
                    {
                        for (int z = 0; z < 2; z++)
                        {
                            ivRandomFruits[j][z].setImage(currentObjects.get(j).getImages()[z]);
                            ivRandomFruits[j][z].setFitHeight(150);
                            ivRandomFruits[j][z].setFitWidth(131);
                            ivRandomFruits[j][z].setPreserveRatio(false);
                            ivRandomFruits[j][z].setLayoutY(800);
                            ivRandomFruits[j][z].setLayoutX(random.nextInt() * 750 + 300);
                        }

                    }
                    velocityY = currentObjects.get(0).getYVelocity();

                        /*if(ivRandomFruits.getLayoutX() > 530)
                        {
                            velocityX = -velocityX;
                        }
                        else if(ivRandomFruits.getLayoutX() < 530)
                            if(velocityX < 0)   velocityX = -velocityX;
                        */
                    size = currentObjects.size();
                }

                for (int i = 0; i < currentObjects.size(); i++) {
                    fruitsRotation[i].play();
                    ivRandomFruits[i][0].setLayoutX(ivRandomFruits[i][0].getLayoutX() + velocityX);
                    ivRandomFruits[i][0].setLayoutY(ivRandomFruits[i][0].getLayoutY() - (velocityY -= random.nextDouble() * 0.0775 + 0.065));
                    if(ivRandomFruits[i][0].getImage() == currentObjects.get(i).getImages()[1] && scoreFlag == false){controller.scoreEdit(30); scoreFlag = true;}
                }
                scoreLabel.setText("Current Score: " + controller.getScore());

            }
        };
        timer.start();


        ivRandomFruits.setOnMouseMoved(e-> {
            ivRandomFruits.setImage(appleCut);
        });


        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        Pane pane = new Pane();
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200,800);
        pane.getChildren().addAll(ivBackGround, ellipse, scoreLabel);
    }

    public Scene getScene() {
        return scene;
    }
}