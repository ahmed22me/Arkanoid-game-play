package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Brick implements GameEntity
{
    private int x, y, bWidth, bHeight;
    private boolean isActive;
    private int strength;
    Random rand = new Random();
    private static int count =0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getCount() {
        return count;
    }

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
        count++;
        System.out.println(count);
        //
    }
}
