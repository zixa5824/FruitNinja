package GameModes;

import Game.GameController;
import SliceableObjects.Bomb;
import SliceableObjects.Fruit;
import SliceableObjects.FruitFactory;
import SliceableObjects.ISliceableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassicMode implements IGameModeStrategy {


    int initialLives = 3;

    @Override
    public int timerType() {
        return -1;
    }

    @Override
    public List<ISliceableObject> NewBatch(int time) {

        List<ISliceableObject> localList = new ArrayList<>();
        FruitFactory fruitFactory = new FruitFactory();
        int x,y;
        x = new Random().nextInt(3)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(3);//reduced to 1 for testing
            localList.add(fruitFactory.getFruits(y));
        }
        return localList;
    }

    @Override
    public void sliceObjects(List<ISliceableObject> objectsToSlice) {
        GameController gameController = GameController.getInstance();
        for (ISliceableObject object:objectsToSlice
        ) {
            int x = object.slice();
            if (object instanceof Fruit) {
                gameController.increaseScore(x);
            }
            else if(object instanceof Bomb){
                gameController.decreaseLives(x);
            }
            //ToDo: increase score by associated score if fruit, kill if bomb
        }
    }

    @Override
    public int getInitialLives() {

        return this.initialLives;
    }




}
