package me.bokov.ld42.model.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Group {

    // Model variables -------------------------------------------------------------------------------------------------

    private List <Shelf> shelves = new ArrayList <> (  );

    // Actor variables -------------------------------------------------------------------------------------------------



    public List <Shelf> getShelves () {
        return shelves;
    }

    public void setShelves ( List <Shelf> shelves ) {
        this.shelves = shelves;
    }
}
