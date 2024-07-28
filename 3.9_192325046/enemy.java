import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
  
    private int moveSpeed = 2;

    public void act() {
        moveRandomly();
    }

    private void moveRandomly() {
        if (Greenfoot.getRandomNumber(100) < 10) {
            turn(Greenfoot.getRandomNumber(360));
        }
        move(moveSpeed);

        // Bounce off the edges
        if (isAtEdge()) {
            turn(180);
        }
    }
}

