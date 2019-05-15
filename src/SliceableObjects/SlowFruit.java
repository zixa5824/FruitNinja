package SliceableObjects;

import SliceableObjects.Fruit;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class SlowFruit extends Fruit {

    public SlowFruit() {
        Random i = new Random();
        this.yLocation = 1;
        this.xLocation = i.nextInt(1200);
        this.associatedScore = 50;
        this.ObjectType = "FastFruit";
        this.initialVelocity = 60;
        this.fallingVelocity = 10;
        images[0] = new ImageView(new Image("resources/watermelon.png"));
        images[1] = new ImageView(new Image("resources/cutWatermelon.png"));
    }


    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:orange.png");
        view[1] = new Image("file:orangeCUT.png");

        return view;
    }

}
