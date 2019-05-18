package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class DangerousBomb extends Bomb {


    public DangerousBomb() {
        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
        this.associatedScore = 0;
        this.associatedFallLiveLoss = 0;
        this.ObjectType = "DangerousBomb";
        this.isSliced = false;
        this.lifeDamage = 1;

        this.initialVelocity = 29;
        this.fallingVelocity = 20;


        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity;
        } else {
            this.currentXVelocity = -initialVelocity;
        }
        this.currentYVelocity = initialVelocity/5;

        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(xLocation);
        this.myImageView.setLayoutY(yLocation);
        localPrefSize = standardPrefSize;
        this.myImageView.setFitWidth(localPrefSize);
        this.myImageView.setFitHeight(localPrefSize);
    }


    @Override
    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:resources/bomb.png");
         view[1] = new Image("file:resources/bomb_cut.png");

        return view;
    }


}
