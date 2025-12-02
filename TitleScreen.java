import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Anay 
 * @version December 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Sigma Elephant", 67);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,508,110);
        Label label = new Label("use \u2190 and \u2192 to move", 30);
        addObject(label,252,269);
        label.setLocation(175,192);
        label.setLocation(342,264);
        Label label2 = new Label("Press <space> to begin", 30);
        addObject(label2,329,309);
        label2.setLocation(343,306);
    }
}
