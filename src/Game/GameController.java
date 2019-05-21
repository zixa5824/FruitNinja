package Game;

import GameModes.*;
import GameModes.IGameModeStrategy;
import SliceableObjects.ISliceableObject;

import javafx.scene.control.Label;
import javafx.util.Duration;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GameController implements GameActions,Serializable {
	private int score;
	private int lives ;
	private double timeS;
	private IGameModeStrategy gameModeStrategy;
	private static GameController instance;
	private GameController() {}
	private ArrayList<Label> observerLabels = new ArrayList<>();
	private ArrayList<Player> records = new ArrayList<>();
	private boolean saveName = false;
	private int difficulty = 0;
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
	public void save() {//bisho: saving using objectstream/serializable interface

		try {
			 FileOutputStream f = new FileOutputStream("ninjas.txt");
	         ObjectOutputStream o = new ObjectOutputStream(f);
	         for(int i=0;i<records.size();i++)
	         o.writeObject(records.get(i));
	         o.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void load() {//bisho: loading using objectstream/serializable interface
		try {
			File temp = new File("ninjas.txt");
				if (!temp.exists()) {
					return;
				}
	         FileInputStream f = new FileInputStream("ninjas.txt");
	         ObjectInputStream o = new ObjectInputStream(f);
	         while(f.available() > 0)
					records.add((Player)o.readObject());
			
	         o.close();
		}
		catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void resetGame() {
		lives = gameModeStrategy.getInitialLives();
		score = 0;
	}

	public ArrayList<Player> listPlayers(){
		return records;
	}

	public void addPlayers(Player player) {
		records.add(player);
	}



	public boolean isSaveName() {
		return saveName;
	}

	public void setSaveName(boolean saveName) {
		this.saveName = saveName;
	}

	public String difficulty()
	{
		return gameModeStrategy.toString();
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getBest() {//bisho: for getting the highest score for the current mode
		int max=0;
		for(int i=0;i<records.size();i++)
			if(records.get(i).getPlayerScore()>max&&records.get(i).getDifficulty().equals(gameModeStrategy.toString()))
				max=records.get(i).getPlayerScore();
		return max;
	}

}
