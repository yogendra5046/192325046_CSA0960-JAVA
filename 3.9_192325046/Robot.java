import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Robot extends Actor {
    private int startX = 48;
    private int startY = 50;
    private int moveSpeed = 4;
    private GreenfootImage robotimage1;
    private GreenfootImage robotimage2;
    private int lives;
    private int pizzaEaten;
    private int timer;
    private final int MAXTIMER = 1000;

    public Robot() {
        robotimage1 = new GreenfootImage("man01.png");
        robotimage2 = new GreenfootImage("man02.png");
        setImage(robotimage1); // Set the initial image
        lives = 3;             // Initialize lives
        pizzaEaten = 0;
        timer = MAXTIMER;      // Initialize timer
        setLocation(startX, startY); // Set initial location
    }

    public void resetPosition() {
        setLocation(startX, startY);
    }

    public void resetTimer() {
        timer = MAXTIMER;
    }

    public void animate() {
        if (getImage() == robotimage1) {
            setImage(robotimage2);
        } else {
            setImage(robotimage1);
        }
    }

    public void robotMovement() {
        if (Greenfoot.isKeyDown("left")) {
            move(-1 * moveSpeed);
            animate();
        }
        if (Greenfoot.isKeyDown("right")) {
            move(moveSpeed);
            animate();
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - moveSpeed);
            animate();
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + moveSpeed);
            animate();
        }
    }

    public void removeLife() {
        lives--;
        if (lives <= 0) {
            Greenfoot.stop();
            System.out.println("Game Over!");
        } else {
            resetPosition();
        }
    }

    public void detectWallCollision() {
        if (isTouching(wall.class)) {
            Greenfoot.playSound("hurt.wav");
            removeLife(); // Remove a life on collision
        }
    }

    public void detectBlockCollision() {
        if (isTouching(block.class)) {
            Greenfoot.playSound("hurt.wav");
            removeLife(); // Remove a life on collision
        }
    }
    

    public void eatPizza() {
        Actor pizza = getOneIntersectingObject(pizza.class);
        if (pizza != null) {
            getWorld().removeObject(pizza);
            pizzaEaten++; // Increment the pizzaEaten count
            Greenfoot.playSound("eat.wav"); // Play eating sound
            timer += 200; // Add 200 to the timer
        }
    }

    private void updateTimer() {
        timer--;
        getWorld().showText("Time: " + timer, 70, 580);
        if (timer == 0) {
            removeLife();
        }
    }

    public void detectHome() {
        if (isTouching(home.class)) {
            RobotWorld myWorld = (RobotWorld) getWorld();
            myWorld.increaseLevel();
            resetTimer();
            resetPosition();
        }
    }

    public void act() {
        robotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
        
        updateTimer();
    }
}
