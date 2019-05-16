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
    public List<ISliceableObject> NewBatch(int time) {

        List<ISliceableObject> localList=new ArrayList<ISliceableObject>();
        FruitFactory fruitFactory= new FruitFactory();
        int x,y;
        x=new Random().nextInt(6);
        for(int i=0;i<x;i++) {
            y=new Random().nextInt(4);//no bomb in arcade
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

}
