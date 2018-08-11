package me.bokov.ld42.model.game;

import com.badlogic.gdx.graphics.Color;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Box {

    public enum Size {

        small,
        medium,
        big

    }

    public enum Color {

        white ( com.badlogic.gdx.graphics.Color.WHITE),
        red ( com.badlogic.gdx.graphics.Color.RED),
        green ( com.badlogic.gdx.graphics.Color.GREEN),
        blue ( com.badlogic.gdx.graphics.Color.BLUE),
        yellow ( com.badlogic.gdx.graphics.Color.YELLOW),
        cyan ( com.badlogic.gdx.graphics.Color.CYAN),
        magenta ( com.badlogic.gdx.graphics.Color.MAGENTA);

        public com.badlogic.gdx.graphics.Color gdxColor;
        Color ( com.badlogic.gdx.graphics.Color c ) {
            this.gdxColor = c.cpy ();
        }

    }

    private static AtomicInteger idGenerator = new AtomicInteger (  );

    private int id = idGenerator.incrementAndGet ();

    private Size size;
    private Color color;
    private String identifier;
    private Shelf shelf;
    private Integer shelfIndex;

    public Size getSize () {
        return size;
    }

    public void setSize ( Size size ) {
        this.size = size;
    }

    public Color getColor () {
        return color;
    }

    public void setColor ( Color color ) {
        this.color = color;
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
}
