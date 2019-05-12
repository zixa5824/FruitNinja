import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface GameObject {
    /**
     *@return the type of game object
     */
    public int getObjectType();
    /*
     *@return X location of game object
     */
    public int getXLocation();
    /*
     *@return Y location of game object
     */
    public int getYLocation();
    /*
     *@return max Y location that the object can reach on the screen
     */
    public int getMaxHeight();
    /*
     *@return velocity at which game object is thrown
     */
    public double getXVelocity();

    public double getYVelocity();


    /*public double getFallingVelocity();

     *@return whether the object is sliced or not
     */



    public Boolean isSliced();
    /*
     *@return whether the object is dropped off the screen or not
     */
    public Boolean hasMovedOffScreen();
    /*
     *it is used to slice the object
     */
    public void slice();
    /*
    *it is used to move the object on the screen
    @param deltaTime: time elapsed since the object is thrown
    it is used calculate the new position of
    fruit object.
    */
    public void move(double time);
    /*
    *@return at least two images of the object, one when it is
    sliced and one when it is not.
    */
    public Image[] getImages();
}

