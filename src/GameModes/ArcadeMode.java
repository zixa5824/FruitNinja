package GameModes;

import SliceableObjects.FruitFactory;
import SliceableObjects.ISliceableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ArcadeMode implements IGameModeStrategy {


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
            y=new Random().nextInt(6);
            localList.add(fruitFactory.getFruits(y));
        }
        return localList;
    }

    @Override
    public int getLives() {
        // TODO Auto-generated method stub
        return 0;
    }

}
