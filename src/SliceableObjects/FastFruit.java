package SliceableObjects;

import SliceableObjects.Fruit;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class FastFruit extends Fruit {

    public FastFruit() {
        Random i = new Random();
        this.yLocation = 1;
        this.xLocation = i.nextInt(1200);
        this.associatedScore = 200;
        this.ObjectType = "FastFruit";
        this.initialVelocity = 50;
        this.fallingVelocity = 40;
//        images[0] = new ImageView(new Image("resources/apple.png"));
//        images[1] = new ImageView(new Image("resources/cutApple.png"));
    }


    @Override
    public Image[] getImages() {
        Image[] view= new Image[3];
        view[0] = new Image("file:watermelon.png");
        view[1] = new Image("file:watermelonCUT.png");
        return view;
    }

}
