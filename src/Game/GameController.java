package Game;

import GameModes.ClassicMode;
import GameModes.EasyDiff;
import GameModes.HardDiff;
import GameModes.IGameModeStrategy;
import SliceableObjects.ISliceableObject;
import javafx.scene.control.Label;
import javafx.util.Duration;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class GameController implements GameActions ,Serializable{
	private int score;
	private int lives ;
	private double timeS;
	private IGameModeStrategy gameModeStrategy;
	//private
	private String[] srcbrd1;
	private String[] srcbrd2;
	private static GameController instance;
	private GameController() {}
	private ArrayList<Label> observerLabels = new ArrayList<>();
	private ArrayList<Player> players = new ArrayList<>();
	private int difficulty = 0;
	private boolean saveName = false;

	public static GameController getInstance() {
		if (instance == null)
			instance = new GameController();
		return instance; }

	public void addObserver(Label label) {
		observerLabels.add(label);
	}

	public void updateObservers() {
		for (Label label:observerLabels
		) {
			label.setText("Current Score: "+ score);
		}
	}

	public void newGame(IGameModeStrategy IGameModeStrategy) {
		this.gameModeStrategy = IGameModeStrategy;
		lives=gameModeStrategy.getInitialLives();//bisho: we must set initial lives at the start and set the score to 0;
		timeS=gameModeStrategy.timerType();
		score=0;
		saveName = false;
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
	public void setTime(double timeS) { // for the timer
		this.timeS=timeS;
	}
	public void timeEdit(double change){ //bisho : in case we add a bomb/special fruit that affect time 
//		if (now > lastTimerCall + 1_000_000_000l) {
//			duration = duration.subtract(Duration.seconds(1));
//
//			int remainingSeconds = (int) duration.toSeconds();
//
//			int m = ((remainingSeconds % SECONDS_PER_DAY) % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
//			int h = (remainingSeconds % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
//			if (m == 0 && h == 0) { endGame(); }
//
//			timerLabel.setText(String.format("%02d", m));
//		}
		timeS += change;
	}

	@Override
	public boolean checkGameOver() {
		return gameModeStrategy.isGameOver(score,timeS, lives);

	}

	@Override
	public List<ISliceableObject> createGameObject(int time) {
		return gameModeStrategy.NewBatch();

	}

	@Override
	public void updateObjectsLocations(List<ISliceableObject> myObjects,
									   List<ISliceableObject> objectsToRemove) {

		for (ISliceableObject fruit:myObjects) {
			fruit.move(3);
			fruit.getImageView().setLayoutY(fruit.getYlocation());
			fruit.getImageView().setLayoutX(fruit.getXlocation());
		}
		for (ISliceableObject fruit:myObjects) {
			if(fruit.getYlocation() > 900)
				objectsToRemove.add(fruit);
		}

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
			FileOutputStream f = new FileOutputStream("ninjas.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
			for(int i=0;i< players.size();i++)
				o.writeObject(players.get(i));
			o.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void loadGame() {
		try {

			FileInputStream f = new FileInputStream("ninjas.txt");
			ObjectInputStream o = new ObjectInputStream(f);
			while(f.available() > 0)
				players.add((Player)o.readObject());

			o.close();
		}
		catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	public String difficulty()
	{
		if(difficulty == 1)
			return "Classic Easy";
		if(difficulty == 2)
			return "Classic Medium";
		if(difficulty == 3)
			return "Classic Hard";
		if(difficulty == 4)
			return "Arcade Easy";
		if(difficulty == 5)
			return "Arcade Medium";
		if(difficulty == 6)
			return "Arcade Hard";

		return null;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<Player> listPlayers(){
		return players;
	}

	public void addPlayers(Player player) {
		players.add(player);
	}

	public boolean isSaveName() {
		return saveName;
	}

	public void setSaveName(boolean saveName) {
		this.saveName = saveName;
	}

	@Override
	public void resetGame() {
		lives = gameModeStrategy.getInitialLives();
		score = 0;
	}

}