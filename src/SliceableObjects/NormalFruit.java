package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;
public class NormalFruit extends Fruit {

    public NormalFruit() {

        Random i = new Random();
        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
        this.associatedScore = 100;
        this.associatedFallLiveLoss =1;
        this.ObjectType = "NormalFruit";
        this.isSliced = false;
        this.initialVelocity = 29;
        this.fallingVelocity = 20;
        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity+i.nextInt(10);
        } else {
            this.currentXVelocity = -initialVelocity-i.nextInt(10);
        }
        this.currentYVelocity = initialVelocity/5;

        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(xLocation);
        this.myImageView.setLayoutY(yLocation);
        localPrefSize = standardPrefSize;
        this.myImageView.setFitWidth(localPrefSize);
        this.myImageView.setFitHeight(localPrefSize);
    }
    public Image[] getMyImage() {
        Image[] view= new Image[2];
        view[0] = new Image("file:resources/apple.png");
        view[1] = new Image("file:resources/cutApple.png");
        return view;
    }



}
