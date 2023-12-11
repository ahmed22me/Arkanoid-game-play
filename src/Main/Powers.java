package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Powers implements GameEntity
{
    private int x, y;

    private  int PWidth, PHeight;
    Random randPower = new Random();

    public Powers(int x, int y)
    {
        this.x = x;
        this.y = y;
        PWidth = 15;
        PHeight = 15;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.decode("#FFD700"));
        g.fillOval(x, y, PWidth, PHeight);
    }

    public void actionPerformed(ActionEvent ae)
    {
        y +=20;
    }

    @Override
    public Rectangle getRect()
    {
        return new Rectangle(x, y, PWidth, PHeight);
    }
}
