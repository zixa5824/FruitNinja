package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;
public class NormalFruit extends Fruit {

    public NormalFruit() {

        Random i = new Random();
        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
//        this.xLocation = i.nextInt(1200);
        this.associatedScore = 100;
        this.ObjectType = "NormalFruit";
        this.initialVelocity = 30;
        this.fallingVelocity = 20;

        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity;
        } else {
            this.currentXVelocity = -initialVelocity;
        }

        this.currentYVelocity = initialVelocity/5;

        this.images[0] = new ImageView(this.getImages()[0]);
        this.images[0].setLayoutX(xLocation);
        this.images[0].setLayoutY(yLocation);
        this.images[0].setFitWidth(50);
        this.images[0].setFitHeight(50);

        this.images[1] = new ImageView(this.getImages()[1]);
        this.images[1].setLayoutX(xLocation);
        this.images[1].setLayoutY(yLocation);
        this.images[1].setFitWidth(50);
        this.images[1].setFitHeight(50);


    }
    public Image[] getImages() {
        Image[] view= new Image[2];
        view[0] = new Image("file:apple.png");
        view[1] = new Image("file:appleCUT.png");
        return view;
    }



    public void move(double time) {

        xLocation = xLocation + currentXVelocity*time/10;

        yLocation = yLocation - currentYVelocity*time;

        currentYVelocity -= fallingVelocity/200;

        if (xLocation > 1200) {
            currentXVelocity= -currentXVelocity;
        } else if (xLocation < 0) {
            currentXVelocity = -currentXVelocity;
        }

        }


}
