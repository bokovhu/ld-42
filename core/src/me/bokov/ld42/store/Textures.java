package me.bokov.ld42.store;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    private static Textures INSTANCE = new Textures ();

    private Texture bigBoxTexture;
    private TextureRegion bigBoxTextureRegion;

    private Texture mediumBoxTexture;
    private TextureRegion mediumBoxTextureRegion;

    private Texture smallBoxTexture;
    private TextureRegion smallBoxTextureRegion;

    private Texture shelfBottomTexture;
    private TextureRegion shelfBottomTextureRegion;

    private Texture shelfMiddleTexture;
    private TextureRegion shelfMiddleTextureRegion;

    private Texture shelfTopTexture;
    private TextureRegion shelfTopTextureRegion;

    private Textures () {

    }

    public void load () {

        bigBoxTexture = new Texture ( Gdx.files.internal ( "textures/box.png" ) );
        bigBoxTextureRegion = new TextureRegion ( bigBoxTexture );

        mediumBoxTexture = new Texture ( Gdx.files.internal ( "textures/box-medium.png" ) );
        mediumBoxTextureRegion = new TextureRegion ( mediumBoxTexture );

        smallBoxTexture = new Texture ( Gdx.files.internal ( "textures/box-small.png" ) );
        smallBoxTextureRegion = new TextureRegion ( smallBoxTexture );

        shelfBottomTexture = new Texture ( Gdx.files.internal ( "textures/shelf-bottom.png" ) );
        shelfBottomTextureRegion = new TextureRegion ( shelfBottomTexture );

        shelfMiddleTexture = new Texture ( Gdx.files.internal ( "textures/shelf-middle.png" ) );
        shelfMiddleTextureRegion = new TextureRegion ( shelfMiddleTexture );

        shelfTopTexture = new Texture ( Gdx.files.internal ( "textures/shelf-top.png" ) );
        shelfTopTextureRegion = new TextureRegion ( shelfTopTexture );

    }

    public void dispose () {

        bigBoxTexture.dispose ();
        mediumBoxTexture.dispose ();
        smallBoxTexture.dispose ();
        shelfBottomTexture.dispose ();
        shelfMiddleTexture.dispose ();
        shelfTopTexture.dispose ();

    }

    public static Textures get () {
        return INSTANCE;
    }

    public Texture getBigBoxTexture () {
        return bigBoxTexture;
    }

    public TextureRegion getBigBoxTextureRegion () {
        return bigBoxTextureRegion;
    }

    public Texture getMediumBoxTexture () {
        return mediumBoxTexture;
    }

    public TextureRegion getMediumBoxTextureRegion () {
        return mediumBoxTextureRegion;
    }

    public Texture getSmallBoxTexture () {
        return smallBoxTexture;
    }

    public TextureRegion getSmallBoxTextureRegion () {
        return smallBoxTextureRegion;
    }

    public Texture getShelfBottomTexture () {
        return shelfBottomTexture;
    }

    public TextureRegion getShelfBottomTextureRegion () {
        return shelfBottomTextureRegion;
    }

    public Texture getShelfMiddleTexture () {
        return shelfMiddleTexture;
    }

    public TextureRegion getShelfMiddleTextureRegion () {
        return shelfMiddleTextureRegion;
    }

    public Texture getShelfTopTexture () {
        return shelfTopTexture;
    }

    public TextureRegion getShelfTopTextureRegion () {
        return shelfTopTextureRegion;
    }
}
