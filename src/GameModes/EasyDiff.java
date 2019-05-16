package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public class EasyDiff extends DifficultyDecorator{


    public EasyDiff(IGameModeStrategy gameMode) {
        this.gameMode = gameMode;
    }


    @Override
    public void goOffScreen(List<ISliceableObject> objectsOffScreen) {

    }

    @Override
    public void sliceObjects(List<ISliceableObject> objectsToSlice) {

    }
}
