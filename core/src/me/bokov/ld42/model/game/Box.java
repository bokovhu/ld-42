package me.bokov.ld42.model.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import me.bokov.ld42.actor.game.BoxInputListener;
import me.bokov.ld42.store.Textures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Box extends Actor {

    public enum BoxSize {

        small,
        medium,
        big

    }

    public enum BoxColor {

        white ( Color.WHITE),
        red ( Color.RED),
        green ( Color.GREEN),
        blue ( Color.BLUE),
        yellow ( Color.YELLOW),
        cyan ( Color.CYAN),
        magenta ( Color.MAGENTA);

        public Color gdxColor;
        BoxColor ( Color c ) {
            this.gdxColor = c.cpy ();
        }

    }
    
    public Box (BoxSize boxSize) {

        this.boxSize = boxSize;

        switch ( boxSize ) {

            case small:

                setBounds ( 0f, 0f, 16f, 32f );

                break;
            case medium:

                setBounds ( 0f, 0f, 24f, 32f );

                break;
            case big:

                setBounds ( 0f, 0f, 32f, 32f );

                break;
        }

        addListener (new BoxInputListener ( this ));
        
    }

    // Model variables -------------------------------------------------------------------------------------------------
    
    private static AtomicInteger idGenerator = new AtomicInteger (  );

    private int id = idGenerator.incrementAndGet ();

    private final BoxSize boxSize;
    private BoxColor boxColor;
    private String identifier;
    private Shelf shelf;
    private Integer shelfIndex;
    
    // Actor variables -------------------------------------------------------------------------------------------------

    public BoxSize getBoxSize () {
        return boxSize;
    }

    public BoxColor getBoxColor () {
        return boxColor;
    }

    public void setBoxColor ( BoxColor boxColor ) {
        this.boxColor = boxColor;
    }

    public String getIdentifier () {
        return identifier;
    }

    public void setIdentifier ( String identifier ) {
        this.identifier = identifier;
    }

    public Shelf getShelf () {
        return shelf;
    }

    public void setShelf ( Shelf shelf ) {
        this.shelf = shelf;
    }

    public Integer getShelfIndex () {
        return shelfIndex;
    }

    public void setShelfIndex ( Integer shelfIndex ) {
        this.shelfIndex = shelfIndex;
    }

    public int getId () {
        return id;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;
        Box box = (Box) o;
        return id == box.id;
    }

    @Override
    public int hashCode () {
        return Objects.hash ( id );
    }

    @Override
    public void draw ( Batch spriteBatch, float parentAlpha ) {

        spriteBatch.setColor ( boxColor.gdxColor );

        switch ( boxSize ) {

            case small:

                spriteBatch.draw (
                        Textures.get ().getSmallBoxTexture (),
                        getX (),
                        getY ()
                );

                break;
            case medium:

                spriteBatch.draw (
                        Textures.get ().getMediumBoxTexture (),
                        getX (),
                        getY ()
                );

                break;
            case big:

                spriteBatch.draw (
                        Textures.get ().getBigBoxTexture (),
                        getX (),
                        getY ()
                );

                break;
        }

        super.draw ( spriteBatch, parentAlpha );

    }

}
