package opsss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 *
 * @author Nermin Elbably
 */
public class Powers implements GameEntity
{
    Paddle pad;
    Ball ball;
    int Type;
    boolean isActive;
    
    int x, y, PWidth, PHeight;
    Random randPower = new Random();
    
    int YSpeed;
    
    public Powers(int x, int y)
    {
        this.x = x;
        this.y = y;
        isActive = true;
        PWidth = 10;
        PHeight = 10;
        Type = randPower.nextInt(20);
        YSpeed = 10;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        //High Ball Speed
        if(Type%5 == 0)
            g.setColor(Color.orange);
        //Large Paddle
        else if(Type%3 == 0)
            g.setColor(Color.red);
        
        g.drawOval(x, y, PWidth, PHeight);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        YSpeed -= YSpeed;
    }
    
    @Override
    public Rectangle getRect()
    {
        return new Rectangle(x, y, PWidth, PHeight);
    }
    
    public void largePaddle()
    {
        pad.padWidth = 230;
    }
    
    public void highSpeedBall()
    {
        ball.XVelocity = 40;
        ball.YVelociyt = 60;
    }
    
    public void IsFalling(boolean falling)
            
    {
            isActive = falling;
    }
    
    public void finish()
    {
        for(int i=0; i<50; i++)
        {
            isActive = false;
        }
           
    }

    @Override
    public void modify(Modifier m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
