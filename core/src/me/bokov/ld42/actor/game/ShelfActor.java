package me.bokov.ld42.actor.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import me.bokov.ld42.model.game.Shelf;
import me.bokov.ld42.store.Textures;

public class ShelfActor extends Actor {

    private final Shelf shelf;

    public ShelfActor ( Shelf shelf ) {
        this.shelf = shelf;
    }

    @Override
    public void draw ( Batch spriteBatch, float parentAlpha ) {

        spriteBatch.setColor ( shelf.getColor ().gdxColor );

        spriteBatch.draw (
                Textures.get ().getShelfBottomTexture (),
                getX (),
                getY ()
        );

        int yOffset = 32;

        for ( int i = 1; i < shelf.getHeight (); i++ ) {

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

    }
}
