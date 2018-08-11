package me.bokov.ld42.model.game;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Box {

    public enum Size {

        small,
        medium,
        big

    }

    public enum Color {

        white,
        red,
        green,
        blue,
        yellow,
        cyan,
        magenta

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
