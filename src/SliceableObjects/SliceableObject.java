package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class SliceableObject implements ISliceableObject {

    protected double xLocation;
    protected double yLocation;
    private double yVelocity = 5, xVelocity = 5;
    protected double maxHeight = 650;
    protected double initialVelocity;
    protected double fallingVelocity;
    protected double currentXVelocity;
    protected double currentYVelocity;
    protected boolean isSliced;
    protected boolean hasMovedOffScreen;
    protected String ObjectType;
    protected ImageView[] images = new ImageView[3];



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
        return null;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {

    }

    @Override
    public ImageView[] getImageView() {
        return this.images;
    }

    @Override
    public void move(double time) {


    }

    @Override
    public double getXVelocity() {
        return this.xVelocity;
    }

    @Override
    public double getYVelocity() {
        return this.yVelocity;
    }

    @Override
    public Image[] getImages() {
        return new Image[0];
    }



}
