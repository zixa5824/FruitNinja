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

	private GameController gameController = GameController.getInstance();
    private int initialLives = 3;

    @Override
    public int timerType() {
        return -1;
    }

    @Override
    public List<ISliceableObject> NewBatch(int time) {

        List<ISliceableObject> localList = new ArrayList<>();
        FruitFactory fruitFactory = new FruitFactory();
        int x,y;
        x = new Random().nextInt(4)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(3);
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
                gameController.livesEdit(-x);
            }
            //ToDo: increase score by associated score if fruit, kill if bomb
        }
    }
    @Override
    public void goOffScreen(List<ISliceableObject> objectsOffScreen) {//bisho: new method for when objects go of screen 
    	 for (ISliceableObject object:objectsOffScreen ) {
    		            int x = object.offscreen();
    		            if (object instanceof Fruit) 
    		                gameController.livesEdit(-x);
 
    		            }
    		            
        
    }
    
    @Override
    public int getInitialLives() {

        return initialLives;
    }

	@Override
	public boolean isGameOver(int score, double timeS, int lives) {
		if(lives<=0)
			return true;
		else return false;
	}




}
