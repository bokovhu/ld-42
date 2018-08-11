package me.bokov.ld42.model.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import me.bokov.ld42.store.Textures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Shelf extends Group {

    public enum ShelfColor {

        white ( Color.WHITE ),
        red ( Color.RED ),
        green ( Color.GREEN ),
        blue ( Color.BLUE );

        public Color gdxColor;

        ShelfColor ( com.badlogic.gdx.graphics.Color c ) {
            this.gdxColor = c.cpy ();
        }

    }

    public Shelf () {

        setBounds (
                0f, 0f,
                48f, 64f + ( shelfHeight - 1 ) * 32f
        );

    }

    // Model variables -------------------------------------------------------------------------------------------------

    private static AtomicInteger idGenerator = new AtomicInteger ();

    private int id = idGenerator.incrementAndGet ();

    private int shelfHeight;
    private ShelfColor shelfColor;
    private List <Box> boxes = new ArrayList <> ();

    // Actor variables -------------------------------------------------------------------------------------------------

    public boolean isBoxColorCompatible ( Box.BoxColor boxColor ) {

        switch ( this.shelfColor ) {

            case white:

                return true;
            case red:

                return boxColor == Box.BoxColor.white
                        || boxColor == Box.BoxColor.red
                        || boxColor == Box.BoxColor.magenta
                        || boxColor == Box.BoxColor.yellow;

            case green:

                return boxColor == Box.BoxColor.white
                        || boxColor == Box.BoxColor.green
                        || boxColor == Box.BoxColor.cyan
                        || boxColor == Box.BoxColor.yellow;

            case blue:

                return boxColor == Box.BoxColor.white
                        || boxColor == Box.BoxColor.blue
                        || boxColor == Box.BoxColor.cyan
                        || boxColor == Box.BoxColor.magenta;

        }

        throw new IllegalArgumentException ( "??" );

    }

    public boolean isBoxPlaceable ( Box box ) {

        if ( boxes.isEmpty () ) {
            return isBoxColorCompatible ( box.getBoxColor () );
        }

        Box topBox = boxes.get ( boxes.size () - 1 );

        switch ( topBox.getBoxSize () ) {

            case small:

                return box.getBoxSize () == Box.BoxSize.small
                        && isBoxColorCompatible ( box.getBoxColor () );
            case medium:

                return ( box.getBoxSize () == Box.BoxSize.medium
                        || box.getBoxSize () == Box.BoxSize.small )
                        && isBoxColorCompatible ( box.getBoxColor () );
            case big:

                return isBoxColorCompatible ( box.getBoxColor () );
        }

        throw new IllegalArgumentException ( "??" );

    }

    public boolean removeBox ( Box box ) {

        if ( !boxes.contains ( box ) ) return false;

        if ( box.getShelfIndex () != boxes.size () - 1 ) {

            return false;

        }

        boxes.remove ( box );
        removeActor ( box );

        box.setShelf ( null );
        box.setShelfIndex ( null );

        return true;

    }

    public boolean addBox ( Box box ) {

        if ( boxes.size () < shelfHeight ) {

            if ( !isBoxPlaceable ( box ) ) return false;

            if ( box.getShelf () != null ) {

                if ( !box.getShelf ().removeBox ( box ) ) return false;

            }

            box.setShelfIndex ( boxes.size () );
            box.setShelf ( this );

            if (box.getParent () != null) {
                box.getParent ().removeActor ( box );
            }

            box.setY ( getY () + 16f + 32f * box.getShelfIndex () );
            box.setX ( 8f );
            if (box.getBoxSize () == Box.BoxSize.small) box.setX ( box.getX () + 8f );
            else if (box.getBoxSize () == Box.BoxSize.medium) box.setX ( box.getX () + 4f );

            addActor ( box );

            boxes.add ( box );

            return true;

        }

        return false;

    }

    public int getShelfHeight () {
        return shelfHeight;
    }

    public void setShelfHeight ( int shelfHeight ) {
        this.shelfHeight = shelfHeight;
    }

    public ShelfColor getShelfColor () {
        return shelfColor;
    }

    public void setShelfColor ( ShelfColor shelfColor ) {
        this.shelfColor = shelfColor;
    }

    public List <Box> getBoxes () {
        return boxes;
    }

    public void setBoxes ( List <Box> boxes ) {
        this.boxes = boxes;
    }

    public int getId () {
        return id;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;
        Shelf shelf = (Shelf) o;
        return id == shelf.id;
    }

    @Override
    public int hashCode () {
        return Objects.hash ( id );
    }

    @Override
    public void draw ( Batch spriteBatch, float parentAlpha ) {

        spriteBatch.setColor ( shelfColor.gdxColor );

        spriteBatch.draw (
                Textures.get ().getShelfBottomTexture (),
                getX (),
                getY ()
        );

        int yOffset = 32;

        for ( int i = 1; i < shelfHeight; i++ ) {

            spriteBatch.draw (
                    Textures.get ().getShelfMiddleTexture (),
                    getX (),
                    getY () + yOffset
            );

            yOffset += 32;

        }

        spriteBatch.draw (
                Textures.get ().getShelfTopTexture (),
                getX (),
                getY () + yOffset
        );

        super.draw ( spriteBatch, parentAlpha );

    }

}
