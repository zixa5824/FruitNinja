package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public interface IGameModeStrategy {

    public int getInitialLives() ;

    public int timerType () ;

    public List<ISliceableObject> NewBatch(int time);


    void sliceObjects(List<ISliceableObject> objectsToSlice);
}
