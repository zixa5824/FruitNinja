import GameModes.IGameModeStrategy;
import SliceableObjects.ISliceableObject;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class GameController implements GameActions {
	private int score = 0;
	private int lives = 0;
	private IGameModeStrategy IGameModeStrategy;
	//private
	private String[] srcbrd1;
	private String[] srcbrd2;
	private static GameController A;
	private GameController() {}



	public static GameController getInstance() {
		if (A == null)
			A = new GameController();
		return A; }



	public void newGame(IGameModeStrategy IGameModeStrategy) {
		this.IGameModeStrategy = IGameModeStrategy;
	}
	public void scoreEdit(int change) {
		score += change;
	}
	public void livesEdit(int change) {
		lives += change;
	}
	public int getScore() {
		return score;
	}
	public int getLives() {
		return lives;
	}



	@Override
	public List<ISliceableObject> createGameObject(int time) {
		return IGameModeStrategy.NewBatch(time);
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
	public void resetGame() {
		lives = IGameModeStrategy.getLives();
		score = 0;
	}








}
