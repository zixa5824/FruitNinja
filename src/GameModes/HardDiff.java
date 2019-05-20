package GameModes;

import SliceableObjects.ISliceableObject;

import java.util.List;

public class HardDiff extends DifficultyDecorator {

    public HardDiff(IGameModeStrategy gameMode) {
        this.gameMode = gameMode;
    }


    @Override
    public int getInitialLives() {
        return gameMode.getInitialLives();
    }

    @Override
    public int timerType() {
        return gameMode.timerType();
    }

    @Override
    public List<ISliceableObject> NewBatch() {
        List<ISliceableObject> thisList = gameMode.NewBatch();
        thisList.addAll(gameMode.NewBatch());
        return thisList;

    }

    @Override
    public void goOffScreen(List<ISliceableObject> objectsOffScreen) {
        gameMode.goOffScreen(objectsOffScreen);
    }

    @Override
    public void sliceObjects(List<ISliceableObject> objectsToSlice) {
        gameMode.sliceObjects(objectsToSlice);
    }

    @Override
    public boolean isGameOver(int score, double timeS, int lives) {
        return gameMode.isGameOver(score, timeS, lives);
    }
}
