package opsss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Breaks  extends Rectangle
{
    final int panel_width = 700;
    final int panel_height = 700;
    int block_width = 70;
    int block_height = 30;
    Boolean destroyed;
    
    int numberofBlock = 0;
    Image background;
    int value;
     public int [][]map;
    public Breaks()
    {
         
          for(int i=70; i<630; i+=80)
         {
                for(int j=60; j<=300; j+=40)
            {
                Rectangle rec = new Rectangle(i, j, block_width, block_height);
                 map = new int[i][j];
        
            }
         }
         
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(background, 0, 0, null);
     
        g2d.setColor(Color.decode("#1E90FF"));

        for(int i=70; i<630; i+=80)
           {
              for(int j=60; j<=300; j+=40)
                {
                   // g2d.fillRect(i, j, block_width, block_height);
                    g2d.fillRoundRect(i, j, block_width, block_height, 20, 20);

                }
             }
    }
    public void setBriValue(int value, int i, int j)
    {
        this.value = value;
    }
}
