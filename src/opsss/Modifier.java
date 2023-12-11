package opsss;

// The modifier in a type of brick but it has abilites or some diffferences

import java.util.Random;

public class Modifier extends Brick
{
    // Addtional Fields
    boolean isFalling;
    int yVelocity;
    Random rand = new Random();
    
    public Modifier(int x, int y)
    {
        super(x, y);
        yVelocity = rand.nextInt(4) + 2;
        isFalling = false;
    }
    
    public void setIsFalling(boolean falling)
    {
        isFalling = falling;
    }
    
    public void update()
    {
        if(isFalling)
            y += yVelocity;
    }
}
