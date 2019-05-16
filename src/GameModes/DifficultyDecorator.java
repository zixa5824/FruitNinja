package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public abstract class DifficultyDecorator implements IGameModeStrategy {

    protected IGameModeStrategy gameMode;

    @Override
    public int getInitialLives() {
        return 0;
    }

    @Override
    public int timerType() {
        return 0;
    }

    @Override
    public List<ISliceableObject> NewBatch(int time) {
        return null;
    }
}
