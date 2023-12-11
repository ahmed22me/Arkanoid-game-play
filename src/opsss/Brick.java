package opsss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;
import java.util.Random;

public class Brick implements GameEntity
{
    int x, y, bWidth, bHeight;
    float  r, G, b;
    boolean isActive;
    int strength;
    Random rand = new Random();
    
    // Images
    Image BrickImage;
    
    public Brick(int x, int y) 
    {
        this.x = x;
        this.y = y;
        bWidth = 60;
        bHeight = 30;
        strength = rand.nextInt(3);
        isActive = true;
    }
    
     @Override
    public void paintComponent(Graphics g)
    {
        switch(strength)
        {
            case 0:
                g.setColor(Color.decode("#FF1493"));
                break;
            case 1:
                 g.setColor(Color.decode("#EE82EE"));
                 break;
            case 2:
                g.setColor(Color.decode("#9400D3"));
                break;
        }
            
       //g.setColor(Color.getHSBColor(r, G, b));
       g.fill3DRect(x, y, bWidth, bHeight, true);  
       //g.drawImage(BrickImage, x, y, bWidth, bHeight, null);
       
    }
    
    @Override
    public void modify(Modifier m) 
    {
        
    }

    public Rectangle getRect()
    {
        return new Rectangle(x, y, bWidth, bHeight);
    }
    
    boolean isActive()
    {
        return isActive;
    }
    
    public void gotHit()
    {
        strength--;
        if(strength<0)
            isActive = false;
    }
}
