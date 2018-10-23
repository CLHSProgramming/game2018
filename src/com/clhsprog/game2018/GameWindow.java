package com.clhsprog.game2018;

import javax.swing.JFrame;

@SuppressWarnings( "serial" )
public class GameWindow extends JFrame
{
    public final Game GAME;
    
    public GameWindow()
    {
        setTitle( Game.NAME );
        setSize( 300, 300 );
        setLocationRelativeTo( null );
        GAME = new Game();
        add( GAME );
        //setUndecorated( true ); //uncomment to remove borders from window
    }
    
    public static void main( String[] args )
    {
        new GameWindow().setVisible( true );
    }
}
