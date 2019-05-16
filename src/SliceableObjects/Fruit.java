package SliceableObjects;

public abstract class Fruit extends SliceableObject {

    protected int associatedScore;

    public int slice() {

        this.isSliced = true;
        return associatedScore;
    }

}
