import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class block extends Actor {
 private int turnspeed;
public block(int maxturnspeed) {
        turnspeed = Greenfoot.getRandomNumber(maxturnspeed * 2 + 1) - maxturnspeed;
        if (turnspeed == 0) {
            turnspeed = 1;
        }}public void act() {
        turn(turnspeed);
    }

        
    
   
}


