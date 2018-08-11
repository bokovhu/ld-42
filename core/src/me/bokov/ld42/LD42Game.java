package me.bokov.ld42;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import me.bokov.ld42.actor.game.BoxActor;
import me.bokov.ld42.actor.game.ShelfActor;
import me.bokov.ld42.bean.WarehouseGenerator;
import me.bokov.ld42.bean.WarehouseToActorsConverter;
import me.bokov.ld42.model.game.Box;
import me.bokov.ld42.model.game.Shelf;
import me.bokov.ld42.model.game.Warehouse;
import me.bokov.ld42.store.Fonts;
import me.bokov.ld42.store.Textures;

import java.util.ArrayList;
import java.util.Random;

public class LD42Game extends ApplicationAdapter implements InputProcessor {

    SpriteBatch spriteBatch;
    ShapeRenderer shapeRenderer;

    Camera cam;

    float gameTime = 0f;

    float fpsTimer = 0f;
    int fps = 0;

    Warehouse warehouse;

    Stage stage;

    InputMultiplexer inputMultiplexer;

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

        WarehouseGenerator warehouseGenerator = new WarehouseGenerator ();

        warehouse = warehouseGenerator.generate ();

        stage = new Stage ( new ScreenViewport (  ) );

        WarehouseToActorsConverter warehouseToActorsConverter = new WarehouseToActorsConverter ();
        warehouseToActorsConverter.convert ( warehouse )
                .forEach ( stage::addActor );

        inputMultiplexer = new InputMultiplexer ( stage, this );
        Gdx.input.setInputProcessor ( inputMultiplexer );

    }

    public void tick () {

        float delta = Gdx.graphics.getDeltaTime ();
        gameTime += delta;

        fpsTimer += delta;

        if (fpsTimer >= 1f) {

            fpsTimer = 0f;
            System.out.println ("FPS: " + fps);
            fps = 0;

        }

        stage.act (delta);

    }

    @Override
    public void render () {

        tick ();

        Gdx.gl.glClearColor ( 1, 1, 1, 1 );
        Gdx.gl.glClear ( GL20.GL_COLOR_BUFFER_BIT );

        stage.draw ();

        ++fps;

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

        stage.getViewport ().update ( width, height );

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
