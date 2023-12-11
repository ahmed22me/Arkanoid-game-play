package Main;

import javax.swing.JFrame;

public class frame extends JFrame
{
    panel pane;
    public frame()
    {
        pane = new panel();

        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.add(b);
        this.add(pane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(700, 800);
        this.setResizable(false);
        this.setVisible(true);
    }
}
