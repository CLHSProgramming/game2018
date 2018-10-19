package com.clhsprog.game2018;

import java.awt.Graphics;

public interface Drawable
{
    public void draw( Graphics g );
    
    public default int getZ()
    {
        return 0;
    }
}
