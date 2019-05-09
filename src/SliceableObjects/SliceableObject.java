package SliceableObjects;

import javafx.scene.image.ImageView;

    public abstract class SliceableObject implements ISliceableObject {

    private int xLocation;
    private int yLocation;
    private int maxHeight;
    private int initialVelocity;
    private int fallingVelocity;

    private boolean isSliced;
    private boolean hasMovedOffScreen;
    private String ObjectType;
    private ImageView[] images;




    @Override
    public String getObjectType() {
        return this.ObjectType;
    }

    @Override
    public int getXlocation() {
        return this.xLocation;
    }

    @Override
    public int getYlocation() {
        return this.yLocation;
    }

    @Override
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Override
    public int getInitialVelocity() {
        return this.initialVelocity;
    }

    @Override
    public int getFallingVelocity() {
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
    public void move(double time) {

    }



}
