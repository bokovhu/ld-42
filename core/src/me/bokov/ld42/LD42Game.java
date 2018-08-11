package me.bokov.ld42;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import me.bokov.ld42.bean.WarehouseGenerator;
import me.bokov.ld42.model.game.Warehouse;
import me.bokov.ld42.store.Fonts;
import me.bokov.ld42.store.Textures;

public class LD42Game extends ApplicationAdapter {

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

        stage.addActor ( warehouse );

        inputMultiplexer = new InputMultiplexer ( stage );
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

}
