package Game;

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
	private IGameModeStrategy gameModeStrategy;
	//private
	private String[] srcbrd1;
	private String[] srcbrd2;
	private static GameController instance;
	private GameController() {}



	public static GameController getInstance() {
		if (instance == null)
			instance = new GameController();
		return instance; }



	public void newGame(IGameModeStrategy IGameModeStrategy) {
		this.gameModeStrategy = IGameModeStrategy;
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
		return gameModeStrategy.NewBatch(time);
	}

	@Override
	public void updateObjectsLocations() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sliceObjects(List<ISliceableObject> objectsToSlice) {
		gameModeStrategy.sliceObjects(objectsToSlice);
	}

	public void increaseScore(int score) {
		this.score += score;
	}

	public void decreaseLives(int penalty) {

	}

	public void increaseLives(int boost) {

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
		lives = gameModeStrategy.getInitialLives();
		score = 0;
	}








}
