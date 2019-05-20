package SliceableObjects;

import java.util.Random;

import Game.GameController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ExtraBonusFruit extends Fruit {

	 public ExtraBonusFruit() {

	        Random i = new Random();
	        this.yLocation = 800;
	        this.xLocation = i.nextInt(900);
	        this.associatedScore = 0;
	        this.associatedFallLiveLoss=0;
	        this.isSliced = false;
	        this.ObjectType = "ExtraBonusFruit";
	        this.initialVelocity = 22;
	        this.fallingVelocity = 10;
	        if (i.nextBoolean()) {
	            this.currentXVelocity = initialVelocity;
	        } else {
	            this.currentXVelocity = -initialVelocity;
	        }
	        this.currentYVelocity = initialVelocity/5;

	        localPrefSize = standardPrefSize*0.75;
	        this.myImageView = new ImageView(this.getMyImage()[0]);
	        this.myImageView.setLayoutX(xLocation);
	        this.myImageView.setLayoutY(yLocation);
	        this.myImageView.setFitWidth(localPrefSize);
	        this.myImageView.setFitHeight(localPrefSize);
	    }
    public int slice() {
    	if(!isSliced) {
    		isSliced=true;
    	 GameController c = GameController.getInstance();
	    	c.scoreEdit(c.getScore());// double current score placeholder effect
	    	}	
	    	return 0;
	    }
	

	
 @Override
 public Image[] getMyImage() {
 	Image[] view= new Image[2];
     view[0] = new Image("file:resources/banana.png");
     view[1] = new Image("file:resources/bananaCut.png");
     return view;
 }
}
