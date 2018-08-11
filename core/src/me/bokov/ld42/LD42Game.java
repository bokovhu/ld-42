package me.bokov.ld42;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import me.bokov.ld42.model.game.Box;
import me.bokov.ld42.model.game.Shelf;
import me.bokov.ld42.model.game.Warehouse;
import me.bokov.ld42.store.Fonts;
import me.bokov.ld42.store.Textures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LD42Game extends ApplicationAdapter implements InputProcessor {

    SpriteBatch spriteBatch;
    ShapeRenderer shapeRenderer;

    Camera cam;

    float gameTime = 0f;

    Warehouse warehouse;

    @Override
    public void create () {

        Textures.get ().load ();
        Fonts.get ().load ();

        shapeRenderer = new ShapeRenderer ();

        spriteBatch = new SpriteBatch ();

        cam = new OrthographicCamera (
                Gdx.graphics.getWidth (),
                Gdx.graphics.getHeight ()
        );

        warehouse = new Warehouse ();

        warehouse.setShelves ( new ArrayList <> (  ) );

        Random random = new Random (  );

        for (int i = 0; i < 5; i++) {

            Shelf shelf = new Shelf ();
            shelf.setHeight (
                    random.nextInt ( 5 ) + 1
            );
            shelf.setColor (
                    Shelf.Color.values () [random.nextInt ( Shelf.Color.values ().length )]
            );

            int boxNum = random.nextInt ( shelf.getHeight () ) + 1;

            for (int j = 0; j < boxNum; j++) {

                Box box = new Box ();
                box.setColor ( Box.Color.white );
                box.setSize ( Box.Size.big );

                shelf.addBox ( box );

            }

            warehouse.getShelves ().add ( shelf );

        }

    }

    public void tick () {

        float delta = Gdx.graphics.getDeltaTime ();
        gameTime += delta;

    }

    @Override
    public void render () {

        tick ();

        Gdx.gl.glClearColor ( 1, 1, 1, 1 );
        Gdx.gl.glClear ( GL20.GL_COLOR_BUFFER_BIT );

        spriteBatch.setProjectionMatrix ( cam.combined );
        spriteBatch.begin ();

        for ( int shelfIndex = 0; shelfIndex < warehouse.getShelves ().size (); shelfIndex++ ) {

            Shelf shelf = warehouse.getShelves ().get ( shelfIndex );

            int shelfX = shelfIndex * (48 + 6);

            /* spriteBatch.draw (
                    Textures.get ().getShelf2Texture (),
                    shelfX,
                    0
            ); */

            spriteBatch.setColor ( shelf.getColor ().gdxColor );

            spriteBatch.draw (
                    Textures.get ().getShelfBottomTexture (),
                    shelfX,
                    0
            );

            int yOffset = 32;

            for (int i = 1; i < shelf.getHeight (); i++) {

                spriteBatch.draw (
                        Textures.get ().getShelfMiddleTexture (),
                        shelfX,
                        yOffset
                );

                yOffset += 32;

            }

            spriteBatch.draw (
                    Textures.get ().getShelfTopTexture (),
                    shelfX,
                    yOffset
            );

            for ( Box box : shelf.getBoxes () ) {

                spriteBatch.setColor ( box.getColor ().gdxColor );
                spriteBatch.draw (
                        Textures.get ().getBoxTexture (),
                        shelfX + ( (48f - 32f) / 2f ),
                        16f + box.getShelfIndex () * 32f
                );

            }

        }

        spriteBatch.end ();

    }

    @Override
    public void dispose () {

        spriteBatch.dispose ();
        shapeRenderer.dispose ();

        Textures.get ().dispose ();
        Fonts.get ().dispose ();

    }

    @Override
    public void resize ( int width, int height ) {

        super.resize ( width, height );

        cam = new OrthographicCamera ( width, height );

    }

    @Override
    public boolean keyDown ( int keycode ) {
        return false;
    }

    @Override
    public boolean keyUp ( int keycode ) {
        return false;
    }

    @Override
    public boolean keyTyped ( char character ) {
        return false;
    }

    @Override
    public boolean touchDown ( int screenX, int screenY, int pointer, int button ) {
        return false;
    }

    @Override
    public boolean touchUp ( int screenX, int screenY, int pointer, int button ) {
        return false;
    }

    @Override
    public boolean touchDragged ( int screenX, int screenY, int pointer ) {
        return false;
    }

    @Override
    public boolean mouseMoved ( int screenX, int screenY ) {
        return false;
    }

    @Override
    public boolean scrolled ( int amount ) {
        return false;
    }
}
