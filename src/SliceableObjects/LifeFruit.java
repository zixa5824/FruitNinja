package SliceableObjects;

import java.nio.file.Paths;
import java.util.Random;

import Game.GameController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class LifeFruit extends Fruit {
	private int lifechange=1;
	 public LifeFruit() {

	        this.yLocation = 800;
	        this.xLocation = i.nextInt(900);
	        this.associatedScore = 0;
	        this.associatedFallLiveLoss=0;// no life loss from missing this one
	        this.isSliced = false;
	        this.ObjectType = "LifeFruit";
	        this.initialVelocity = 40;
	        this.fallingVelocity = 38;
		 if (i.nextBoolean()) {
			 this.currentXVelocity = initialVelocity+i.nextInt(10);
		 } else {
			 this.currentXVelocity = -initialVelocity-i.nextInt(10);
		 }
	        this.currentYVelocity = initialVelocity/5;

	        localPrefSize = standardPrefSize*0.5;
	        this.myImageView = new ImageView(this.getMyImage()[0]);
	        this.myImageView.setLayoutX(xLocation);
	        this.myImageView.setLayoutY(yLocation);
	        this.myImageView.setFitWidth(localPrefSize);
	        this.myImageView.setFitHeight(localPrefSize);

		 slashClip = new AudioClip(Paths.get("music/slash.mp3").toUri().toString());

	 }
	
	 
	    public int slice() {
	    	if(!isSliced) {
	    		isSliced=true;
	    	 GameController c = GameController.getInstance();
	    	 c.livesEdit(lifechange);
		    	}	
		    	return 0;
		    }
	
    @Override
    public Image[] getMyImage() {
    	Image[] view= new Image[2];
        view[0] = new Image("file:resources/strawberry.png");
        view[1] = new Image("file:resources/strawberryCut.png");
        return view;
    }
}
