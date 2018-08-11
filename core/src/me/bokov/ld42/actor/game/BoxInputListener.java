package me.bokov.ld42.actor.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import me.bokov.ld42.model.game.Box;

public class BoxInputListener extends InputListener {

    private final Box box;

    private float touchStartMouseX = -1f;
    private float touchStartMouseY = -1f;

    private float dragStartX = -1f;
    private float dragStartY = -1f;

    public BoxInputListener ( Box box ) {
        this.box = box;
    }

    @Override
    public boolean touchDown ( InputEvent event, float x, float y, int pointer, int button ) {

        boolean handle = false;

        if ( box.getShelf () == null ) handle = true;
        else if ( box.getShelf ().getBoxes ().size () - 1 == box.getShelfIndex () ) handle = true;

        if ( handle ) {

            touchStartMouseX = event.getStageX ();
            touchStartMouseY = event.getStageY ();

            dragStartX = box.getX ();
            dragStartY = box.getY ();

        }

        return handle;

    }

    @Override
    public void touchDragged ( InputEvent event, float x, float y, int pointer ) {

        box.setPosition (
                dragStartX + ( event.getStageX () - touchStartMouseX ),
                dragStartY + ( event.getStageY () - touchStartMouseY )
        );

    }

    @Override
    public void touchUp ( InputEvent event, float x, float y, int pointer, int button ) {

        box.setPosition ( dragStartX, dragStartY );

    }

}
