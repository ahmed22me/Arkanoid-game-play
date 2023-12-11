package opsss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball implements  GameEntity, ActionListener
{
    int XPos, YPos, XVelocity, YVelociyt, ballSize;
    
    //Collisions
    int xDestination, yDestination, xTemp, yTemp;
    //XDestination and yDestination are used to see one frame animation / to see where tha ball has hit
    //xTemp and yTemp are used to store where we think the shape is out to go based on the collisions that we have or haven't detected
    
    boolean topLeft, topRight, bottomLeft, bottomRight;
    // They are used to check if the collision happens or not 
    public Ball()
    {
        XPos = 335;
        YPos = 450;
        XVelocity = 20;
        YVelociyt = 30;
        ballSize = 20;
        
        xTemp = XPos;
        yTemp = YPos;
        
        xDestination = XPos;
        yDestination = YPos;
        
        topLeft = topRight = bottomLeft = bottomRight = false;
    }
    
    @Override
    public void modify(Modifier m) 
    {
        
    }
    
    public void CalculateCorners(int FXpos, int FYpos, Rectangle r)
    {
        //Point Stores the x and y positions
        Point tl = new Point(FXpos-ballSize/2, FYpos-ballSize/2);
        Point tr = new Point(FXpos+ballSize/2, FYpos-ballSize/2);
        Point bl = new Point(FXpos-ballSize/2, FYpos+ballSize/2);
        Point br = new Point(FXpos+ballSize/2, FYpos+ballSize/2);
       
        //To indicate that the collision didn't happen yet
        topLeft = topRight = bottomLeft = bottomRight = false;
        
        topLeft = r.contains(tl);
        topRight = r.contains(tr);
        bottomLeft = r.contains(bl);
        bottomRight = r.contains(br);
        /* All rectangles have the method that called contains which can tell that wether or not this x & y point exists inside 
           the pounds of this this rectangle r 
        */
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.decode("#00FFFF"));
        g.fillOval(XPos, YPos, ballSize, ballSize);
    }
    
    /* Rectangle r represents the bounding box for the Paddle or the Bricks that we are checking to see 
       if the ball has collided with or not*/
    public boolean checkCollision(Rectangle r)
    {
        boolean collisionDetected = false;
        // The Future Position of the ball
        xDestination = XPos + XVelocity;
        yDestination = YPos + YVelociyt;
        // Storage the current position of the ball to keep it safe
        xTemp = XPos;
        yTemp = YPos;
        
        // Horizontal Collision
        CalculateCorners(xDestination, YPos, r);
        // If we are going to the right
        if(XVelocity>0)
        {
            if(topRight || bottomRight)
            {
                XVelocity = -XVelocity;
                collisionDetected = true;
                // Just to prevent overlapping
                xTemp = (int) (r.getMinX() - ballSize/2 - 1);
            }
        }
        // If we are going to the left
        if(XVelocity<0)
        {
            if(topLeft || bottomLeft)
            {
                XVelocity = -XVelocity;
                collisionDetected = true;
                xTemp = (int) (r.getMaxX() + ballSize/2 + 1);
            }
        }
        
        // Verticle Collision
        CalculateCorners(XPos, yDestination, r);
        // If we are going down
        if(YVelociyt>0)
        {
            if(bottomRight|| bottomLeft)
            {
                YVelociyt = -YVelociyt;
                collisionDetected = true;
                yTemp = (int) (r.getMinY() );
            }
        }
        // If we are going up
        if(YVelociyt<0)
        {
            if(topLeft || topRight)
            {
                YVelociyt = -YVelociyt;
                collisionDetected = true;
                yTemp = (int) (r.getMaxY());
            }
        }
        
        return collisionDetected;
    }
    
    // this is to take whatever is in the temporary containers and move the ball round
    public void setPosition()
    {
        xTemp += XVelocity;
        yTemp += YVelociyt;
        XPos = xTemp;
        YPos = yTemp;
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(XPos>665 || XPos<15)
            XVelocity= -XVelocity;
        if(YPos>650 )
            YVelociyt = -YVelociyt;
        if(YPos<0)
            YVelociyt = -YVelociyt;
        XPos+=XVelocity;
        YPos+=YVelociyt;
    }

    @Override
    public Rectangle getRect() 
    {
        return new Rectangle(XPos-ballSize/2, YPos-ballSize/2, ballSize, ballSize);
    }

}
