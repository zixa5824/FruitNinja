package SliceableObjects;

public abstract class Bomb extends SliceableObject{

    protected int lifeDamage;

    public int slice() {

        this.isSliced = true;
        slashClip.play();
        return lifeDamage;

    }

    @Override
    public int offscreen() {
        return 0;
    }

}
