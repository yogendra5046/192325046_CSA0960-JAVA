import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RobotWorld extends World {
    private int currentMaxTurnSpeed = 2;
    private int currentLevel = 1;

    public RobotWorld() {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }

    private void prepare() {
        // Add a block at the specified location
        addObject(new block(currentMaxTurnSpeed), 427, 145);

        // Add a robot at the top left of the world (X:48, Y:50)
        Robot robot = new Robot();
        addObject(robot, 48, 50);

        // Create a row of walls leaving a gap about the width of the block
        addObject(new wall(), 48, 147);
        addObject(new wall(), 52, 147);
        addObject(new wall(), 159, 147);
        addObject(new wall(), 266, 147);
        addObject(new wall(), 587, 147);
        addObject(new wall(), 692, 147);
         addObject(new wall(), 719, 147);
         
         

        // Add a green block between the gap (X, Y): (427, 145)
        block greenBlock = new block(11);
        addObject(greenBlock, 427, 145);

        // Add a home instance at the bottom right (X, Y): (751, 552)
        home Home = new home();
        addObject(Home, 751, 552);

        // Add a scorepanel instance at the bottom left (X, Y): (71, 554)
        scorepanel ScorePanel = new scorepanel();
        addObject(ScorePanel, 71, 554);

        // Add 5 pizza instances
        addObject(new pizza(), 720, 46);
        addObject(new pizza(), 433, 38);
        addObject(new pizza(), 183, 302);
        addObject(new pizza(), 682, 312);
        addObject(new pizza(), 417, 537);
    }

    public void setUpLevel() {
        if (currentLevel == 2) {
            currentMaxTurnSpeed++;
            addObject(new block(currentMaxTurnSpeed), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            addPizzas(5);
        } else if (currentLevel == 3) {
            currentMaxTurnSpeed++;
            addObject(new block(currentMaxTurnSpeed), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            addPizzas(5);
        } else if (currentLevel == 4) {
            // Custom level setup
        }
    }

    private void addPizzas(int count) {
        for (int i = 0; i < count; i++) {
            addObject(new pizza(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }

    public void increaseLevel() {
        currentLevel++;
        setUpLevel();
    }
}
