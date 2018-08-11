package me.bokov.ld42.model.game;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List <Shelf> shelves = new ArrayList <> (  );

    public List <Shelf> getShelves () {
        return shelves;
    }

    public void setShelves ( List <Shelf> shelves ) {
        this.shelves = shelves;
    }
}
