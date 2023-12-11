package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class panel extends JPanel implements ActionListener
{
    final int panel_width = 700;
    final int panel_height = 800;
    private int score = 0;
    private int num_lives = 1;
    Timer timer;
    //Image
    Image background;

    Paddle thePaddle;
    Ball theBall;
    Brick[][] bricks;

    static final int Num_Cols = 7;
    static final int Num_Rows = 4;
    static final int Grid_Size = 65;
    static final int OffSet = 115;

    private int Num_Bricks = Num_Cols*Num_Rows;
    Powers pow = new Powers(-55,0);
    CurrentTime time=new CurrentTime();

    public panel()
    {
        this.setPreferredSize(new Dimension(panel_width, panel_height));

        thePaddle = new Paddle();
        theBall = new Ball();
        bricks = new Brick[Num_Rows][Num_Cols];

        //Images
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
        pow.paintComponent(g);

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
        g.drawString("Lives " + num_lives, 60, 30);

       if(theBall.getYPos()>700)
        {
           num_lives -=1 ;
           if(num_lives< 1)
            {
                g.setColor(Color.white);
                g.setFont(new Font("comic sans MS", Font.BOLD, 50));
                g.drawString("Game Over !", 200, 300);
                g.setFont(new Font("comic sans MS", Font.BOLD, 30));
                g.drawString("Score  " + score, 270, 350);
                g.setFont(new Font("comic sans MS", Font.BOLD, 20));

                timer.stop();
            }
        }
       if(Num_Bricks<0)
       {
           g.setColor(Color.white);
           g.setFont(new Font("comic sans MS", Font.BOLD, 50));
           g.drawString("This Is Great .....", 200, 300);
           g.setFont(new Font("comic sans MS", Font.BOLD, 30));
           g.drawString("You Won", 270, 350);
           timer.stop();
       }
    }


    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(time.getsecond()==8){

            thePaddle.getNormal();
            theBall.normalBall();
        }
        checkCollision();
        System.out.println(time.getsecond());
        theBall.checkCollision(thePaddle.getRect());

        theBall.actionPerformed(ae);

        pow.actionPerformed(ae);
        if(thePaddle.getRect().intersects(pow.getRect()))
        {
            pow.setX(-55);
            int x= new Random().nextInt(5)+1;
            System.out.print("Boll");
            if(x==1){
                thePaddle.largePaddle();
            }
            else if(x==2){
                theBall.bigBall();

            }else if(x==3){
                score+=200;

            }
            else if(x==4)
                num_lives++;
            else if(x==5)
            {
                thePaddle.smallPaddle();
            }
            time.setSecond(0);

        }
        repaint();
    }

    public void checkCollision()
    {
        for(Brick[] row: bricks)
        {
            for(Brick b : row)
            {
                if(b.isActive())
                    if(theBall.checkCollision(b.getRect()))
                    {
                        if(Brick.getCount()==2 || Brick.getCount()==10 || Brick.getCount() == 17 || Brick.getCount() == 25 || Brick.getCount() == 30 || Brick.getCount() == 40)
                        {
                            pow.setX(b.getX());
                            pow.setY(b.getY());

                        }
                        b.gotHit();
                        score += 5;
                    }
                else
                    Num_Bricks ++;
            }
        }
    }

    void generateBricks()
    {
        for(int row = 0; row<Num_Rows; row++)
        {
            for(int col = 0; col<Num_Cols; col++)
            {
                bricks[row][col] = new Brick(col*Grid_Size+OffSet, row*Grid_Size+OffSet);
            }
        }
    }
}
