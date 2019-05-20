package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public interface IGameModeStrategy {

    int getInitialLives() ;

    int timerType () ;

    List<ISliceableObject> NewBatch();

    void goOffScreen(List<ISliceableObject> objectsOffScreen);
    
    void sliceObjects(List<ISliceableObject> objectsToSlice);
    
    boolean isGameOver(int score , double timeS , int lives);//bisho: new game over condition
    
}
