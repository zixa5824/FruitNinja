import java.util.Random;

public abstract class Fruit implements GameObject{

    //Margins
    private int xLoc = new Random().nextInt() * 750 + 310;
    private int yLoc = 800;
    private double yVelocity = 10, xVelocity = 1.5;
    private boolean isOffScreen = false, isSliced=false;


    @Override
    public int getObjectType() {
        // 1 for fruit , 2 for bombs , 3 for special fruits
        return 1;
    }

    @Override
    public int getXLocation() {

        return xLoc;
    }

    @Override
    public int getYLocation() {

        return yLoc;
    }

    @Override
    public int getMaxHeight() {

        return 40;
    }

    @Override
    public double getXVelocity() {

        return xVelocity;
    }
    @Override
    public double getYVelocity() {

        return yVelocity;
    }

    @Override
    public Boolean isSliced() {

        return isSliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {

        return isOffScreen;
    }

    @Override
    public void slice() {
        isSliced=true;
    }

}
