package SliceableObjects;

public class FruitFactory {


    public ISliceableObject getFruits(int type){




        if(8<=type && type<10)
            return new ExtraBonusFruit();

        if(10<=type && type<40)
            return new NormalFruit();

        if(40<=type && type<55)
            return new SlowFruit();

        if(55<=type && type<70)
                return new FastFruit();

        if(73<=type && type<80)
            return new DangerousBomb();

        if(88<=type && type<90)
            return new FatalBomb();

        if(95<=type && type<=100)
            return new LifeFruit();

        else
            return new NormalFruit();
        }











}
