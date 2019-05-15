package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public class HardDiff extends DifficultyDecorator{

    public HardDiff(IGameModeStrategy gameMode) {
        this.gameMode = gameMode;
    }


    @Override
    public int getLives() {
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
