package opsss;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nermin Elbably
 */
public class Board extends JPanel implements ActionListener
{
    private Timer timer;

    public Board() 
    {
        timer = new Timer(25, this);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
       repaint();
    }
    
    public void Paint(Graphics g)
    {
        super.paint(g);
        
        g.setColor(Color.black);
        g.fillRect(60, 60, 70, 30);
    }
}
