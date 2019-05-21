package SliceableObjects;

import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.Random;

public abstract class SliceableObject implements ISliceableObject {

    protected Random i = new Random();
    protected int associatedScore;
    protected int associatedFallLiveLoss;
    protected double xLocation;
    protected double yLocation;
    protected double maxHeight = 650;
    protected double initialVelocity;
    protected double fallingVelocity;
    protected double currentXVelocity;
    protected double currentYVelocity;
    protected boolean isSliced;
    protected boolean hasMovedOffScreen;
    protected String ObjectType;
    protected ImageView myImageView = new ImageView();
    protected double standardPrefSize = 130;
    protected double localPrefSize;
    protected AudioClip slashClip;


    public void move(double time) {

        xLocation = xLocation + currentXVelocity*time/10;

        yLocation = yLocation - currentYVelocity*time*1.5;

        currentYVelocity -= fallingVelocity/170;

        if (yLocation < 0) {
            currentYVelocity = -currentYVelocity*time/10-i.nextDouble()-.5;
        }

        if (xLocation >= 1200 - localPrefSize) {
            currentXVelocity= -currentXVelocity*time/30 -i.nextInt(10)-5;
        } else if (xLocation < 0) {
            currentXVelocity = -currentXVelocity*time/30 +i.nextInt(10)+5;
        }

    }

    @Override
    public Boolean hasMovedOffScreen() {
        if (this.yLocation < 810)
            return true;

        else return false;
    }



    @Override
    public String getObjectType() {
        return this.ObjectType;
    }

    @Override
    public double getXlocation() {
        return this.xLocation;
    }

    @Override
    public double getYlocation() {
        return this.yLocation;
    }

    @Override
    public double getMaxHeight() {
        return this.maxHeight;
    }

    @Override
    public double getInitialVelocity() {
        return this.initialVelocity;
    }

    @Override
    public double getFallingVelocity() {
        return this.fallingVelocity;
    }

    @Override
    public Boolean isSliced() {

        return this.isSliced;
    }

    @Override
    public ImageView getImageView() {
        return this.myImageView;
    }



}
