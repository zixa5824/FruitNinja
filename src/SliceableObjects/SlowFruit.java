package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.Random;

public class SlowFruit extends Fruit {

    public SlowFruit() {

        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
        this.associatedScore = 50;
        this.associatedFallLiveLoss =1;
        this.isSliced = false;
        this.ObjectType = "SlowFruit";
        this.initialVelocity = 20;
        this.fallingVelocity = 10;
        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity+i.nextInt(10);
        } else {
            this.currentXVelocity = -initialVelocity-i.nextInt(10);
        }
        this.currentYVelocity = initialVelocity/5;

        localPrefSize = standardPrefSize*1.5;
        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(xLocation);
        this.myImageView.setLayoutY(yLocation);
        this.myImageView.setFitWidth(localPrefSize);
        this.myImageView.setFitHeight(localPrefSize);

        slashClip = new AudioClip(Paths.get("slash.mp3").toUri().toString());
    }


    @Override
    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:resources/watermelon.png");
        view[1] = new Image("file:resources/cutWatermelon.png");
        return view;
    }

}
