package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class SlowFruit extends Fruit {

    public SlowFruit() {

        Random i = new Random();
        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
        this.associatedScore = 100;
        this.ObjectType = "SlowFruit";
        this.initialVelocity = 17;
        this.fallingVelocity = 6;
        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity;
        } else {
            this.currentXVelocity = -initialVelocity;
        }
        this.currentYVelocity = initialVelocity/5;

        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(xLocation);
        this.myImageView.setLayoutY(yLocation);
        this.myImageView.setFitWidth(standardPrefSize*1.5);
        this.myImageView.setFitHeight(standardPrefSize*1.5);
    }


    @Override
    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:resources/watermelon.png");
        view[1] = new Image("file:watermelonCUT.png");
        return view;
    }

}
