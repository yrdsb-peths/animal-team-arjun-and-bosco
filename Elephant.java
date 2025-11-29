import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our Hero.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String facing = "right";
    public void act()
    {
        // Add your action code here.
        int dx = 4;
        int dy = getY() + 2;
        int x = getX();
        if(Greenfoot.isKeyDown("left"))
        {
            dx = -dx;
            move(dx);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right"))
        {
            dx = dx;
            move(dx);
            facing = "right";
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(0, dy);
        }
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(null);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
        }
    }
}
