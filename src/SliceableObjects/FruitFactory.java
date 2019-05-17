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
                return new DangerousBomb();

            case 4:
                return new FatalBomb();
                /*
	     case 5:
		         return new SpecialBomb();
		         break;*/
            default:
                return null;
        }}











}
