package GameModes;

import SliceableObjects.ISliceableObject;
import SliceableObjects.SliceableObject;

import java.util.List;

public interface IGameModeStrategy {

    public int getLives () ;

    public int timerType () ;

    public List<ISliceableObject> NewBatch(int time);



}
