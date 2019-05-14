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
        int randomizedSizeOfFruit, randomFruit;
        randomizedSizeOfFruit = new Random().nextInt() * 4 + 1;
        for(int i = 0;i < randomizedSizeOfFruit; i++)
        {
            randomFruit = new Random().nextInt(3);
            localList.add(fruitFactory.getFruits(randomFruit));
        }
        return localList;
    }

    @Override
    public int getLives() {

        return 3;
    }




}
