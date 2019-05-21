package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.Random;

public class FastFruit extends Fruit {

    public FastFruit() {

        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
        this.associatedScore = 200;
        this.associatedFallLiveLoss = 1;
        this.isSliced = false;
        this.ObjectType = "FastFruit";
        this.initialVelocity = 30;
        this.fallingVelocity = 15;

        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity+i.nextInt(10);
        } else {
            this.currentXVelocity = -initialVelocity-i.nextInt(10);
        }
        this.currentYVelocity = initialVelocity/5;

        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(xLocation);
        this.myImageView.setLayoutY(yLocation);
        localPrefSize = standardPrefSize*0.9;
        this.myImageView.setFitWidth(localPrefSize);
        this.myImageView.setFitHeight(localPrefSize);

        slashClip = new AudioClip(Paths.get("music/slash.mp3").toUri().toString());
    }


    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:resources/orange.png");
        view[1] = new Image("file:resources/cutOrange.png");

        return view;
    }

}
