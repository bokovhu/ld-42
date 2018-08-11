package me.bokov.ld42.bean;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import me.bokov.ld42.actor.game.BoxActor;
import me.bokov.ld42.actor.game.ShelfActor;
import me.bokov.ld42.model.game.Box;
import me.bokov.ld42.model.game.Shelf;
import me.bokov.ld42.model.game.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseToActorsConverter {

    public List <Actor> convert ( Warehouse warehouse ) {

        List <Actor> topLevelActors = new ArrayList <> (  );

        for (int i = 0; i < warehouse.getShelves ().size (); i++) {

            Shelf shelf = warehouse.getShelves ().get ( i );

            Group shelfGroup = new Group ();
            shelfGroup.setTransform ( true );

            ShelfActor shelfActor = new ShelfActor ( shelf );

            shelfGroup.addActor ( shelfActor );

            shelfGroup.setX ( (48f + 6f) * i );

            Group shelfBoxesGroup = new Group ();
            shelfBoxesGroup.setTransform ( true );

            for ( int j = 0; j < shelf.getBoxes ().size (); j++ ) {

                Box box = shelf.getBoxes ().get ( j );

                BoxActor boxActor = new BoxActor ( box );

                boxActor.setY (
                        16f + 32f * box.getShelfIndex ()
                );
                boxActor.setX ( 8f );

                switch ( box.getSize () ) {

                    case small:

                        boxActor.setX (
                                boxActor.getX () + 8f
                        );

                        break;
                    case medium:

                        boxActor.setX (
                                boxActor.getX () + 4f
                        );

                        break;
                    case big:
                        break;
                }

                shelfBoxesGroup.addActor ( boxActor );

            }

            shelfGroup.addActor ( shelfBoxesGroup );

            topLevelActors.add ( shelfGroup );

        }

        return topLevelActors;

    }

}
