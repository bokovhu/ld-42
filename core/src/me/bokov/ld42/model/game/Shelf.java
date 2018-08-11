package me.bokov.ld42.model.game;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    public enum Color {

        white,
        red,
        green,
        blue

    }

    private int height;
    private Color color;
    private List <Box> boxes = new ArrayList <> (  );

    public boolean removeBox ( Box box ) {

        if (!boxes.contains ( box )) return false;

        if ( box.getShelfIndex () != boxes.size () - 1 ) {

            return false;

        }

        boxes.remove ( box );

        box.setShelf ( null );
        box.setShelfIndex ( null );

        return true;

    }

    public boolean addBox ( Box box ) {

        if (boxes.size () < height) {

            if (box.getShelf () != null) {

                if (!box.getShelf ().removeBox ( box )) return false;

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
}
