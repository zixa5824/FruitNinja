package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public interface IGameModeStrategy {

    public int getInitialLives() ;

    public int timerType () ;

    public List<ISliceableObject> NewBatch();

    public void goOffScreen(List<ISliceableObject> objectsOffScreen);
    
    void sliceObjects(List<ISliceableObject> objectsToSlice);
    
    public boolean isGameOver(int score , double timeS , int lives);//bisho: new game over condition
    
}
