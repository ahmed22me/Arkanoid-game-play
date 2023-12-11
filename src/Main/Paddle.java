package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle implements GameEntity, KeyListener
{
    int xpad = 275;
    int ypad = 670;
    int padWidth = 125;
    int padHeight = 25;
    int padxVel = 50;

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.decode("#1E90FF"));
        g.fill3DRect(xpad, ypad, padWidth, padHeight,true);
    }


    @Override
    public Rectangle getRect()
    {
        return new Rectangle(xpad, ypad, padWidth, padHeight);

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
            if(xpad>700-padWidth)
                padxVel = - padxVel;
            else
                xpad +=10;
        }

        if(e.getKeyCode()== KeyEvent.VK_LEFT)
        {
            if(xpad<5)
                xpad = 5;
            else
                xpad -= 10;
        }

    }

    public void largePaddle(){

        padWidth=200;

    }
    public void getNormal(){
        padWidth=125;
    }
    public void smallPaddle(){
        padWidth=90;
    }
}
