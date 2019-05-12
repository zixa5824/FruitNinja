import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GameMode2 implements GameModeStrategy {


    @Override
    public int timerType() {
        return 60;
    }

    @Override
    public List<GameObject> NewBatch(int time) {
        List<GameObject> localList=new ArrayList<GameObject>();
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
