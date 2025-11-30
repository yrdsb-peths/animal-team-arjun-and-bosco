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
    GreenfootSound eatApple = new GreenfootSound("eated_apple.wav");
    
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    GreenfootImage[] idleRight = new GreenfootImage[8];
    
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
        {
            for (int i = 0; i < idleRight.length; i++)
            {
                idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
                idleRight[i].scale(75, 75);
            }
            
            for (int i = 0; i < idleLeft.length; i++)
            {
                idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
                idleLeft[i].mirrorHorizontally();
                idleLeft[i].scale(75, 75);
            }
            
            animationTimer.mark();
        }
    int imageIndex = 0;
    public void animateElephant()
    {
        if (animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
        }else
        {
            setImage(idleLeft[imageIndex]);
        }
        
        
        imageIndex = (imageIndex + 1) % idleRight.length;
    }
    
    
    public void act()
    {
        // Add your action code here.
        int dx = 4;
        int dy = getY() + 2;
        int x = getX();
        
        
        
        if(Greenfoot.isKeyDown("left") || (Greenfoot.isKeyDown("a")))
        {
            dx = -dx;
            move(dx);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right") || (Greenfoot.isKeyDown("d")))
        {
            dx = dx;
            move(dx);
            facing = "right";
        }
        
        
        
        
        eat();
        animateElephant();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(null);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            
            eatApple.play();
        }
    }
}
