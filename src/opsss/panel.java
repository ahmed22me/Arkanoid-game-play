package opsss;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class panel extends JPanel implements ActionListener
        
{
    final int panel_width = 700;
    final int panel_height = 700;
    int score = 0;
    Timer timer;
    Random rand = new Random();
    //Image
    Image brickImg;
    Image background;
    
    Paddle thePaddle;
    Ball theBall;
    Brick[][] bricks;
    
    Powers pow;
    
    static final int Num_Cols = 7;
    static final int Num_Rows = 4;
    static final int Grid_Size = 65;
    static final int OffSet = 115;
    
    int Num_Bricks = Num_Cols*Num_Rows;
    
    public panel()
    {
        this.setPreferredSize(new Dimension(panel_width, panel_height));
        
       thePaddle = new Paddle();
       theBall = new Ball();
       bricks = new Brick[Num_Rows][Num_Cols];
       
       //Images
       brickImg = new ImageIcon("src//redRectangle.jpg").getImage() ;
       generateBricks();
       
        addKeyListener(thePaddle);
        
        this.setFocusTraversalKeysEnabled(true);
        this.setFocusable(true);
        
        background = new ImageIcon("src//reback.jpg").getImage();
        timer = new Timer(100, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        
       super.paintComponent(g);
       
        g.drawImage(background, 0, 0, null);
        thePaddle.paintComponent(g);
        theBall.paintComponent(g);
        
        for(Brick[] row: bricks)
        {
            for(Brick b : row)
            {
                if(b.isActive())
                    b.paintComponent(g);
            }
        }
        
        //draw Score
        g.setColor(Color.white);
        g.setFont(new Font("comic sans MS", Font.BOLD, 25));
        g.drawString("Score  " + score, 550, 30);
        
        /*if(theBall.YPos>650)
        {
           // for(int i=0; i<70; i++)
            //{
                g.setColor(Color.white);
                g.setFont(new Font("comic sans MS", Font.BOLD, 50));
                g.drawString("Game Over !", 200, 300);
                g.setFont(new Font("comic sans MS", Font.BOLD, 30));
                g.drawString("Score  " + score, 270, 350);
                g.setFont(new Font("comic sans MS", Font.BOLD, 20));
                theBall.paintComponent(g);
                timer.stop();
            }

            g.drawString("Press Enter to restart", 240, 400);
        }*/
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        checkCollision();
        theBall.checkCollision(thePaddle.getRect());
        
        theBall.actionPerformed(ae);
        
        theBall.setPosition();
        
       // pow.actionPerformed(ae);
        repaint();
    }
    
    public void checkCollision()
    {
        for(Brick[] row: bricks)
        {
            for(Brick b : row)
            {
                if(b.isActive())
                    if(theBall.checkCollision(b.getRect()) == true)
                    {
                        b.gotHit();
                        score += 5;
                    }
            }
        }
        
        /*if(pow.isActive())
        {
            if(theBall.checkCollision(pow.getRect()) == true)
            {
                pow.finish();
            }
        }*/
    }

    public class AL extends KeyAdapter
    {
        public void KeyPressed(KeyEvent e)
        {
            thePaddle.keyPressed(e);
            repaint();
        }
    }
     
    void generateBricks()
    {
        for(int row = 0; row<Num_Rows; row++)
        {
            for(int col = 0; col<Num_Cols; col++)
            {
               
                //bricks[row][col] = new Brick(col*Grid_Size+OffSet, row*Grid_Size+OffSet, brickImg);
                bricks[row][col] = new Brick(col*Grid_Size+OffSet, row*Grid_Size+OffSet);
            }
        }
    }
}