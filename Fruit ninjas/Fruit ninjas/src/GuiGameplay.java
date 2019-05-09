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
        //------
        Image appleCut = new Image("file:appleCUT.png");
        ImageView ivAppleCut = new ImageView(appleCut);
        ivAppleCut.setFitHeight(150);
        ivAppleCut.setFitWidth(131);
        ivAppleCut.setPreserveRatio(false);
        ivAppleCut.setVisible(false);
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
        */
        QuadCurveTo quadTo = new QuadCurveTo();
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

        path.getElements().add(quadTo);
        PathTransition pathTransition1 = new PathTransition();
        pathTransition1.setDuration(Duration.millis(4000));
        pathTransition1.setNode(ivAppleCut);
        pathTransition1.setPath(path);
        pathTransition1.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition1.setAutoReverse(true);
        RotateTransition appleRotate1 = new RotateTransition(Duration.millis(2000), ivAppleCut);
        appleRotate1.setCycleCount(3);
        appleRotate1.setFromAngle(0);
        appleRotate1.setToAngle(360);
        appleRotate1.play();
        pathTransition1.play();

        ivApple.setOnMouseMoved(e-> {
            ivAppleCut.setVisible(true);
            ivApple.setVisible(false);
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