
public class FruitFactory {

	
	public GameObject getCrosser(String type){
	      if(type == null){
	         return null;
	      }		
	      if(type.equalsIgnoreCase("f1")){
	         return new Fruit1();
	        
	      } else if(type.equalsIgnoreCase("f2")){
	         return new Fruit2();
	         
	      } else if(type.equalsIgnoreCase("f3")){
	         return new Fruit3();
	         
	      } else if(type.equalsIgnoreCase("db")){
		         return new DangerousBomb();
		         
		      }else if(type.equalsIgnoreCase("fb")){
			         return new FatalBomb();
		      }
	      return null;
	   }
	
	
	
	
	
	
	
	
	
	
	
}
