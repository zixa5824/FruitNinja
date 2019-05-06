import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;




public class Controller implements GameActions {
	private int score=0;
	private int lives=0;
	private GameModeStrategy stra;
	//private
	private String[] srcbrd1;
	private String[] srcbrd2;
	

	private static Controller A;
	private Controller  () {}
		
		 
		 
		 public static Controller  getInstance() {
			 if (A == null)
				 A = new Controller  ();
			 return A; }
	
	
	
		 public void newGame(GameModeStrategy stra) {
				stra=this.stra;
			}
		 
		 
		 
		 

	@Override
	public GameObject createGameObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sliceObjects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {

		try {
			FileOutputStream fos = new FileOutputStream(new File("ninjas.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
		//	encoder.writeObject(var);
			
			
			encoder.close();
			fos.close();
			
		}
		catch(IOException ex) {
		ex.printStackTrace();
		}
		
	}

	@Override
	public void loadGame() {
		try {
			FileInputStream fis = new FileInputStream(new File("riversave.xml"));
			XMLDecoder decoder = new XMLDecoder(fis);
			
			
			//decoder.readObject();

			
			decoder.close();
			fis.close();
			
			
			
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void ResetGame() {
		// TODO Auto-generated method stub
		
	}
	

	
	

	
	
	
}
