import SliceableObjects.ISliceableObject;

public interface IGameActions {



    /*
     *@return created game object
     */
    ISliceableObject createGameObject();




    /*
    * update moving objects locations
    *
    */
    void updateObjectsLocations();




    /*
    * it is used to slice fruits located in your swiping region
    This method can take your swiping region as parameters (they
    depend on how you calculate it).
    */
    void sliceObjects();


    /*
     *resets the game to its initial state
     */
    void ResetGame();









}
