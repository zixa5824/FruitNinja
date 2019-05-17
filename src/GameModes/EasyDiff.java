package GameModes;

import SliceableObjects.FastFruit;
import SliceableObjects.ISliceableObject;

import java.util.List;
import java.util.Random;

public class EasyDiff extends DifficultyDecorator{


    public EasyDiff(IGameModeStrategy gameMode) {
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
        Random i = new Random();
        List<ISliceableObject> thisList = gameMode.NewBatch();

        for (ISliceableObject object:thisList
             ) {
            if (object instanceof FastFruit) {
                thisList.remove(object);
            }
        }
        if (thisList.size() > 4) {
            thisList.remove(i.nextInt(4));
        }
        if(thisList.size() > 3)
        {
            thisList.remove(i.nextInt(3));
        }
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
