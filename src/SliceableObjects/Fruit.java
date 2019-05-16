package SliceableObjects;

import java.util.Random;

import static java.lang.Math.pow;

public class Fruit extends SliceableObject {

    protected int associatedScore;



    public void move(double time) {

        xLocation = xLocation + currentXVelocity*time/10;

        yLocation = yLocation - currentYVelocity*time*1.5;

        currentYVelocity -= fallingVelocity/170;

        if (yLocation < 0) {
            currentYVelocity = -currentYVelocity;
        }

        if (xLocation > 1120) {
            currentXVelocity= -currentXVelocity;
        } else if (xLocation < 0) {
            currentXVelocity = -currentXVelocity;
        }

    }





}
