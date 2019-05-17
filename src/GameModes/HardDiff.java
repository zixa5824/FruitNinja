package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public class HardDiff extends DifficultyDecorator{

    public HardDiff(IGameModeStrategy gameMode) {
        this.gameMode = gameMode;
    }


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

    @Override
    public void goOffScreen(List<ISliceableObject> objectsOffScreen) {

    }

    @Override
    public void sliceObjects(List<ISliceableObject> objectsToSlice) {

    }

    @Override
    public boolean isGameOver(int score, double timeS, int lives) {
        return false;
    }
}
