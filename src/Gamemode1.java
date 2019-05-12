import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMode1 implements GameModeStrategy{

    @Override
    public int timerType() {
        return -1;
    }

    @Override
    public List<GameObject> NewBatch(int time) {

        List<GameObject> localList = new ArrayList<>();
        FruitFactory fruitFactory = new FruitFactory();
        int x,y;
        x = new Random().nextInt(6)+1;
        for(int i = 0;i < x; i++) {
            y = new Random().nextInt(1);//reduced to 1 for testing
            localList.add(fruitFactory.getFruits(y));
        }
        return localList;
    }

    @Override
    public int getLives() {

        return 3;
    }




}
