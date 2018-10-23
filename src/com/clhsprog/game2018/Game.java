package com.clhsprog.game2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class Game extends JPanel implements ActionListener, Comparator<Drawable>
{
    public static final String NAME = "Game";
    public static final int FPS = 60;
    private javax.swing.Timer timer;
    private ArrayList<Drawable> sprites = new ArrayList<Drawable>();
    
    public Game()
    {
        setBackground( Color.BLACK );
        timer = new javax.swing.Timer( 1000 / FPS, this );
        timer.start();
        
        addDrawable( new Player( 0, 0 ) );
    }
    
    /**
     * Draws all graphics to the screen
     */
    @Override
    public void paint( Graphics g )
    {
        Image buffer = createImage( getWidth(), getHeight() );
        Graphics bufferGraphics = buffer.getGraphics();
        bufferGraphics.setColor( getBackground() );
        bufferGraphics.fillRect( 0, 0, getWidth(), getHeight() );
        for( Drawable d: sprites )
            d.draw( bufferGraphics );
        g.drawImage( buffer, 0, 0, null );
    }
    
    /**
     * Adds a Drawable object to be rendered by the game
     * @param d - the object to add
     */
    public void addDrawable( Drawable d )
    {
        sprites.add( d );
        sprites.sort( this );
    }
    
    /**
     * Fired before every frame, simply repainting the frame
     * @param evt - unused
     */
    @Override
    public void actionPerformed( ActionEvent evt )
    {
        repaint();
    }
    
    /**
     * Compares Drawables to decide draw order
     * @param d1 - the first Drawable
     * @param d2 - the second Drawable
     */
    @Override
    public int compare( Drawable d1, Drawable d2 )
    {
        if( d1.getZ() < d2.getZ() )
            return -1;
        if( d1.getZ() > d2.getZ() )
            return 1;
        return 0;
    }
    
}
