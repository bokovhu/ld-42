package me.bokov.ld42.bean;

import me.bokov.ld42.model.game.Box;
import me.bokov.ld42.model.game.Shelf;
import me.bokov.ld42.model.game.Warehouse;

import java.util.ArrayList;
import java.util.Random;

public class WarehouseGenerator {

    private int minNumberOfShelves = 7;
    private int maxNumberOfShelves = 10;
    private int minShelfHeight = 1;
    private int maxShelfHeight = 6;
    private int minEmptySpaces = 7;
    private int maxEmptySpaces = 10;

    public Warehouse generate () {

        Warehouse warehouse = new Warehouse ();

        warehouse.setTransform ( true );

        Random random = new Random (  );

        warehouse.setShelves ( new ArrayList <> (  ) );

        int numShelves = random.nextInt ( maxNumberOfShelves - minNumberOfShelves ) + minNumberOfShelves;

        for (int shelfIndex = 0; shelfIndex < numShelves; shelfIndex++) {

            Shelf shelf = new Shelf ();

            shelf.setTransform ( true );
            shelf.setX ( (48f + 6f) * shelfIndex );

            int shelfHeight = random.nextInt ( maxShelfHeight - minShelfHeight ) + minShelfHeight;

            shelf.setShelfHeight ( shelfHeight );

            shelf.setShelfColor (
                    Shelf.ShelfColor.values () [ random.nextInt ( Shelf.ShelfColor.values ().length ) ]
            );

            for (int boxIndex = 0; boxIndex < shelfHeight; boxIndex++) {

                boolean placed = false;
                while (!placed) {

                    Box box = new Box (
                            Box.BoxSize.values () [ random.nextInt ( Box.BoxSize.values ().length ) ]
                    );

                    box.setBoxColor (
                            Box.BoxColor.values () [ random.nextInt ( Box.BoxColor.values ().length ) ]
                    );

                    if ( shelf.addBox ( box ) ) placed = true;

                }

            }

            warehouse.getShelves ().add ( shelf );
            warehouse.addActor ( shelf );

        }

        int numEmptySpaces = random.nextInt ( maxEmptySpaces - minEmptySpaces ) + minEmptySpaces;

        for (int i = 0; i < numEmptySpaces; i++) {

            boolean removed = false;
            while (!removed) {

                Shelf shelf = warehouse.getShelves ().get ( random.nextInt ( warehouse.getShelves ().size () ) );

                if (!shelf.getBoxes ().isEmpty ()) {

                    shelf.removeBox ( shelf.getBoxes ().get ( shelf.getBoxes ().size () - 1 ) );
                    removed = true;

                }

            }

        }

        return warehouse;

    }

}
