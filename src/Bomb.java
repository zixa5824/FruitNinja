
public abstract class Bomb implements GameObject{

    private int x,y;
    private boolean isoffscreen,issliced;

    @Override
    public int getObjectType() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getXLocation() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getYLocation() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMaxHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*@Override
    public int getInitialVelocity() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getFallingVelocity() {
        // TODO Auto-generated method stub
        return 0;
    }
    */

    @Override
    public Boolean isSliced() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void slice() {
        // TODO Auto-generated method stub

    }



}
