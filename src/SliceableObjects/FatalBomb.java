package SliceableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.Random;

public class FatalBomb extends Bomb {
    public FatalBomb() {
        this.yLocation = 800;
        this.xLocation = i.nextInt(900);
        this.associatedScore = 0;
        this.associatedFallLiveLoss = 0;
        this.ObjectType = "FatalBomb";
        this.isSliced = false;
        this.lifeDamage = 99;

        this.initialVelocity = 29;
        this.fallingVelocity = 20;


        if (i.nextBoolean()) {
            this.currentXVelocity = initialVelocity+i.nextInt(10);
        } else {
            this.currentXVelocity = -initialVelocity-i.nextInt(10);
        }
        this.currentYVelocity = initialVelocity/5;

        this.myImageView = new ImageView(this.getMyImage()[0]);
        this.myImageView.setLayoutX(xLocation);
        this.myImageView.setLayoutY(yLocation);
        localPrefSize = standardPrefSize;
        this.myImageView.setFitWidth(localPrefSize);
        this.myImageView.setFitHeight(localPrefSize);

        slashClip = new AudioClip(Paths.get("grenade.wav").toUri().toString());

    }


    public Image[] getMyImage() {
        Image[] view= new Image[3];
        view[0] = new Image("file:resources/db.png");
        view[1] = new Image("file:resources/bomb_cut.png");
        return view;
    }

	@Override
	public int offscreen() {
		return 0;
	}


}
