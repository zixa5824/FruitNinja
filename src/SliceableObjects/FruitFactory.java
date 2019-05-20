package SliceableObjects;

public class FruitFactory {


    public ISliceableObject getFruits(int type){
        switch(type) {

            case 0:
                return new NormalFruit();

            case 1:
                return new SlowFruit();

            case 2:
                return new FastFruit();

            case 3:
                return new LifeFruit();

            case 4:
                return new ExtraBonusFruit();
                
            case 5:
            
            return new DangerousBomb();
            
            case 6:
            
            return new FatalBomb();
            
            default:
                return null;
        }}











}
