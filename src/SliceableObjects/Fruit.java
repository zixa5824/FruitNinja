package SliceableObjects;

import java.applet.AudioClip;
import java.nio.file.Paths;

public abstract class Fruit extends SliceableObject {


    public int slice() {
     if(!isSliced) {
        isSliced = true;

        slashClip.play();
        return associatedScore;

     }
   return 0;
    }
    public int offscreen() {
    	
        if(!hasMovedOffScreen) {
        	hasMovedOffScreen=true;
        if(isSliced == true)
            return 0; //bisho: this condition is for when the object is already sliced no life loss occur , can be done in a varity of ways but this is more direct
        else
            return associatedFallLiveLoss;
        }
        return 0;
    }
}
