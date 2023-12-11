package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball implements GameEntity, ActionListener
{
   private int XPos, YPos, XVelocity, YVelocity, ballSize;

    //Collisions
   private int xDestination, yDestination;
    //XDestination and yDestination are used to see one frame animation / to see where tha ball has hit

    private boolean topLeft, topRight, bottomLeft, bottomRight;
    // They are used to check if the collision happens or not
    public Ball()
    {
        XPos = 335;
        YPos = 600;
        XVelocity = 20;
        YVelocity = 30;
        ballSize = 20;

        xDestination = XPos;
        yDestination = YPos;

        topLeft = topRight = bottomLeft = bottomRight = false;
    }

    public int getYPos() {
        return YPos;
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
        /* All rectangles have the method that called contains which can tell that whether or not this x & y point exists inside
           the pounds of this this rectangle r
        */
    }



    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.decode("#FFE4E1"));
        g.fillOval(XPos, YPos, ballSize, ballSize);
    }

    /* Rectangle r represents the bounding box for the Paddle or the Bricks that we are checking to see
       if the ball has collided with or not*/
    public boolean checkCollision(Rectangle r)
    {
        boolean collisionDetected = false;
        // The Future Position of the ball
        xDestination = XPos + XVelocity;
        yDestination = YPos + YVelocity;

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
                //xTemp = (int) (r.getMinX() - ballSize/2 - 1);
            }
        }
        // If we are going to the left
        if(XVelocity<0)
        {
            if(topLeft || bottomLeft)
            {
                XVelocity = -XVelocity;
                collisionDetected = true;
                //xTemp = (int) (r.getMaxX() + ballSize/2 + 1);
            }
        }

        // Vertical Collision
        CalculateCorners(XPos, yDestination, r);
        // If we are going down
        if(YVelocity >0)
        {
            if(bottomRight|| bottomLeft)
            {
                YVelocity = -YVelocity;
                collisionDetected = true;
                //yTemp = (int) (r.getMinY()+ ballSize/2 - 5);
            }
        }
        // If we are going up
        if(YVelocity <0)
        {
            if(topLeft || topRight)
            {
                YVelocity = -YVelocity;
                collisionDetected = true;
                //yTemp = (int) (r.getMaxY()+  ballSize/2 + 2);
            }
        }

        return collisionDetected;
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(XPos>665 || XPos<15)
            XVelocity= -XVelocity;
        if(YPos>750 )
            YVelocity = -YVelocity;
        if(YPos<0)
            YVelocity = -YVelocity;
        XPos+=XVelocity;
        YPos+= YVelocity;
    }

    @Override
    public Rectangle getRect()
    {
        return new Rectangle(XPos-ballSize/2, YPos-ballSize/2, ballSize, ballSize);
    }

    public void bigBall(){
        ballSize=30;

    }

    public void normalBall(){
        ballSize=20;
    }
}
