package SliceableObjects;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface ISliceableObject {



    /**
     * @return the type of game object
     */
    String getObjectType();

    public int offscreen();

    public Image[] getMyImage();



    /*
     *@return X location of game object
     */
    double getXlocation();






    /*
     *@return Y location of game object
     */
    double getYlocation();



    /*
     *@return max Y location that the object can reach on the screen
     */
    double getMaxHeight();

    ImageView getImageView();

    /*
     *@return velocity at which game object is thrown
     */
    double getInitialVelocity();







    /*
     *@return failing velocity of game object
     */
    double getFallingVelocity();





    /*
     *@return whether the object is sliced or not
     */
    Boolean isSliced();





    /*
     *@return whether the object is dropped off the screen or not
     */
    Boolean hasMovedOffScreen();



    /*
     *it is used to slice the object
     */
    int slice();




    /*
    *it is used to move the object on the screen
    @param deltaT   ime: time elapsed since the object is thrown
    it is used calculate the new position of
    fruit object.
    */
    void move(double time);



}
