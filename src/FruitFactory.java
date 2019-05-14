
public class FruitFactory {


    public GameObject getFruits(int type){
        switch(type) {

            case 0:
                return new Fruit1();

            case 1:
                return new Fruit2();

            case 2:
                return new Fruit3();

            case 3:
                return new Fruit4();

            case 4:
                return new DangerousBomb();

            case 5:
                return new FatalBomb();

	  /*   case 6:
		         return new LiveBomb();
		         break;
	     case 7:
		         return new SpecialBomb();
		         break;*/
            default:
                return null;
        }}











}
