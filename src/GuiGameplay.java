import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;


public class GuiGameplay{

    private Scene scene;
    private AnimationTimer timer;
    private double velocityY;
    GuiGameplay(Stage stage)
    {

        //-------
        Image image = new Image("file:backgroundClassic.jpg");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFocusTraversable(false);
        ivBackGround.setFitWidth(1220);
        ivBackGround.setFitHeight(820);
        //-------
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

        // path.getElements().add (new LineTo(200, 200));
        /*CubicCurveTo cubicTo = new CubicCurveTo();
        cubicTo.setControlX1(730f);
        cubicTo.setControlY1(107f);
        cubicTo.setControlX2(362f);
        cubicTo.setControlY2(107f);
        cubicTo.setX(53);
        cubicTo.setY(608);
        path.getElements().add(cubicTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(ivApple);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        RotateTransition appleRotate = new RotateTransition(Duration.millis(2000), ivApple);
        appleRotate.setCycleCount(3);
        appleRotate.setFromAngle(0);
        appleRotate.setToAngle(360);
        appleRotate.play();
        pathTransition.play();
        */

        /*QuadCurveTo quadTo = new QuadCurveTo();
        quadTo.setX(0);
        quadTo.setY(800);
        quadTo.setControlX(535);
        quadTo.setControlY(-650);
        path.getElements().add(quadTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setNode(ivApple);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        RotateTransition appleRotate = new RotateTransition(Duration.millis(2000), ivApple);
        appleRotate.setCycleCount(3);
        appleRotate.setFromAngle(0);
        appleRotate.setToAngle(360);
        appleRotate.play();
        pathTransition.play();

        ivApple.setOnMouseMoved(e-> {
            ivApple.setImage(appleCut);
        });
        */


        velocityY = 10;
        RotateTransition appleRotate = new RotateTransition(Duration.millis(4500), ivApple);
        appleRotate.setCycleCount(3);
        appleRotate.setFromAngle(0);
        appleRotate.setToAngle(360);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                appleRotate.play();
                ivApple.setLayoutX(ivApple.getLayoutX() + 1.5);
                ivApple.setLayoutY(ivApple.getLayoutY() - (velocityY -= 0.075));
                if(ivApple.getLayoutY() < 100)
                    timer.stop();
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
        pane.getChildren().addAll(ivBackGround, ivApple, ivAppleCut);
    }

    public Scene getScene() {
        return scene;
    }
}