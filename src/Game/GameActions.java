package Game;

import SliceableObjects.ISliceableObject;

import java.util.List;

public interface GameActions {
    boolean checkGameOver();

    /*
     *@return created game object
     */
    public List<ISliceableObject> createGameObject(int time);
    /*
     * update moving objects locations
     * */
    public void throwOffScreen(List<ISliceableObject> objects);
    public void updateObjectsLocations(List<ISliceableObject> myObjects, List<ISliceableObject> objectsToRemove);
    /*
    * it is used to slice fruits located in your swiping region
    This method can take your swiping region as parameters (they
    depend on how you calculate it).
    */
    public void sliceObjects(List<ISliceableObject> objects);
    /*
     *saves the current state of the game
     */
    public void saveGame();
    /*
     *loads the last saved state of the game
     */
    public void loadGame();
    /*
     *resets the game to its initial state
     */
    public void resetGame();

}
