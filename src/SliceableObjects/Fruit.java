package SliceableObjects;

public abstract class Fruit extends SliceableObject {

    protected int associatedScore;
    protected int associatedfallLiveloss;
    public int slice() {

        this.isSliced = true;
        return associatedScore;
    }
    public int offscreen() {
        this.hasMovedOffScreen = true;
        if(isSliced == true)
            return 0; //bisho: this condition is for when the object is already sliced no life loss occur , can be done in a varity of ways but this is more direct
        else
            return associatedfallLiveloss;
    }
}
