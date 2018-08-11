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
    private int minEmptySpaces = 3;
    private int maxEmptySpaces = 5;

    public Warehouse generate () {

        Warehouse warehouse = new Warehouse ();
        Random random = new Random (  );

        warehouse.setShelves ( new ArrayList <> (  ) );

        int numShelves = random.nextInt ( maxNumberOfShelves - minNumberOfShelves ) + minNumberOfShelves;

        for (int shelfIndex = 0; shelfIndex < numShelves; shelfIndex++) {

            Shelf shelf = new Shelf ();

            int shelfHeight = random.nextInt ( maxShelfHeight - minShelfHeight ) + minShelfHeight;

            shelf.setHeight ( shelfHeight );

            shelf.setColor (
                    Shelf.Color.values () [ random.nextInt ( Shelf.Color.values ().length ) ]
            );

            for (int boxIndex = 0; boxIndex < shelfHeight; boxIndex++) {

                boolean placed = false;
                while (!placed) {

                    Box box = new Box ();

                    box.setSize (
                            Box.Size.values () [ random.nextInt ( Box.Size.values ().length ) ]
                    );
                    box.setColor (
                            Box.Color.values () [ random.nextInt ( Box.Color.values ().length ) ]
                    );

                    if ( shelf.addBox ( box ) ) placed = true;

                }

            }

            warehouse.getShelves ().add ( shelf );

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
