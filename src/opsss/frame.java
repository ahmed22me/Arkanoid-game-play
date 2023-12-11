package opsss;

import javax.swing.JFrame;

public class frame extends JFrame
{
    panel pane;
    Breaks b;
    public frame()
    {
        pane = new panel();
        //b = new Breaks(4, 8);
        
        this.setTitle("Arkanid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.add(b);
        this.add(pane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        this.setResizable(false);
        this.setVisible(true);
    }
}
