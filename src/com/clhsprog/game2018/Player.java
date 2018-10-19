package com.clhsprog.game2018;

import java.awt.Color;
import java.awt.Graphics;

public class Player implements Drawable
{
    private int x, y;
    
    public Player( int x, int y )
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void draw( Graphics g )
    {
        g.setColor( Color.RED );
        g.drawRect( x, y, 10, 10 );
        x++;
        y++;
    }
    
}
