package SliceableObjects;

public abstract class Bomb extends SliceableObject{

    protected int lifeDamage;

    public int slice() {

        this.isSliced = true;
        return lifeDamage;
    }
}
