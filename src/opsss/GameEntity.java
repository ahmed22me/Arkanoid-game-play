package opsss;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface GameEntity 
{
    
    public void paintComponent(Graphics g);
    Rectangle getRect();
    public void modify(Modifier m);
}
