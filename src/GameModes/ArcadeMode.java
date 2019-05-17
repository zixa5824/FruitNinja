package GameModes;

import SliceableObjects.Bomb;
import SliceableObjects.Fruit;
import SliceableObjects.FruitFactory;
import SliceableObjects.ISliceableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Game.GameController;
public class ArcadeMode implements IGameModeStrategy {

	private GameController gameController = GameController.getInstance();
    @Override
    public int timerType() {
        return 60;
    }

    @Override
    public List<ISliceableObject> NewBatch() {
        List<ISliceableObject> localList = new ArrayList<>();
        FruitFactory fruitFactory = new FruitFactory();
        int x,y;
        x = new Random().nextInt(4)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(3);//BISHO : NO BOMBS IN ARCADE
            localList.add(fruitFactory.getFruits(y));
        }
        return localList;
    }

    @Override
    public void sliceObjects(List<ISliceableObject> objectsToSlice) {
    	 for (ISliceableObject object:objectsToSlice
    		        ) {
    		            int x = object.slice();
    		            if (object instanceof Fruit) {
    		                gameController.scoreEdit(x);
    		            }
    		            else if(object instanceof Bomb){
    		                gameController.scoreEdit(-x*100); 
    		            }
    }
    }
    @Override
    public int getInitialLives() {
        
        return -1;
    }

	@Override
	public void goOffScreen(List<ISliceableObject> objectsOffScreen) {
		// do nothing at all
		
	}

	@Override
	public boolean isGameOver(int score, double timeS, int lives) {
		if(timeS<0)
			return true;
		else return false;
		
	}

}
