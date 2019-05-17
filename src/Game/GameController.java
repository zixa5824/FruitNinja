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
	private int score;
	private int lives ;
	private double timeS;
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
		lives=gameModeStrategy.getInitialLives();//bisho: we must set initial lives at the start and set the score to 0;
		timeS=gameModeStrategy.timerType();	
		score=0;
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
	public double getTime() {
		return timeS;
	}
	public void timeEdit(double change){ //bisho : in case we add a bomb/special fruit that affect time 
		timeS += change;
	}

	@Override
	public boolean checkGameOver() {
		return gameModeStrategy.isGameOver(score,timeS, lives);

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
	@Override
	public void throwOffScreen(List<ISliceableObject> objects) {
		gameModeStrategy.goOffScreen(objects);
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
