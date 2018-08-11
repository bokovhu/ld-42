package me.bokov.ld42.actor.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import me.bokov.ld42.model.game.Box;
import me.bokov.ld42.store.Textures;

public class BoxActor extends Actor {

    private final Box box;

    public BoxActor ( Box box ) {
        this.box = box;

        switch ( box.getSize () ) {

            case small:

                setBounds ( 0f, 0f, 16f, 32f );

                break;
            case medium:

                setBounds ( 0f, 0f, 24f, 32f );

                break;
            case big:

                setBounds ( 0f, 0f, 32f, 32f );

                break;
        }

        addListener (
                new InputListener () {

                    @Override
                    public boolean touchDown ( InputEvent event, float x, float y, int pointer, int button ) {

                        System.out.println (box.getId () + " was touched");

                        return true;

                    }

                }
        );

    }

    @Override
    public void draw ( Batch spriteBatch, float parentAlpha ) {

        spriteBatch.setColor ( box.getColor ().gdxColor );

        switch ( box.getSize () ) {

            case small:

                spriteBatch.draw (
                        Textures.get ().getSmallBoxTexture (),
                        getX (),
                        getY ()
                );

                break;
            case medium:

                spriteBatch.draw (
                        Textures.get ().getMediumBoxTexture (),
                        getX (),
                        getY ()
                );

                break;
            case big:

                spriteBatch.draw (
                        Textures.get ().getBigBoxTexture (),
                        getX (),
                        getY ()
                );

                break;
        }

    }

}
