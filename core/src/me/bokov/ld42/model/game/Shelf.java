package me.bokov.ld42.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Shelf {

    public enum Color {

        white ( com.badlogic.gdx.graphics.Color.WHITE ),
        red ( com.badlogic.gdx.graphics.Color.RED ),
        green ( com.badlogic.gdx.graphics.Color.GREEN ),
        blue ( com.badlogic.gdx.graphics.Color.BLUE );

        public com.badlogic.gdx.graphics.Color gdxColor;

        Color ( com.badlogic.gdx.graphics.Color c ) {
            this.gdxColor = c.cpy ();
        }

    }

    private static AtomicInteger idGenerator = new AtomicInteger ();

    private int id = idGenerator.incrementAndGet ();

    private int height;
    private Color color;
    private List <Box> boxes = new ArrayList <> ();

    public boolean removeBox ( Box box ) {

        if ( !boxes.contains ( box ) ) return false;

        if ( box.getShelfIndex () != boxes.size () - 1 ) {

            return false;

        }

        boxes.remove ( box );

        box.setShelf ( null );
        box.setShelfIndex ( null );

        return true;

    }

    public boolean addBox ( Box box ) {

        if ( boxes.size () < height ) {

            if ( box.getShelf () != null ) {

                if ( !box.getShelf ().removeBox ( box ) ) return false;

            }

            box.setShelfIndex ( boxes.size () );
            box.setShelf ( this );
            boxes.add ( box );

            return true;

        }

        return false;

    }

    public int getHeight () {
        return height;
    }

    public void setHeight ( int height ) {
        this.height = height;
    }

    public Color getColor () {
        return color;
    }

    public void setColor ( Color color ) {
        this.color = color;
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
}
