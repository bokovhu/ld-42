package me.bokov.ld42.store;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    private static Textures INSTANCE = new Textures ();

    private Texture boxTexture;
    private TextureRegion boxTextureRegion;

    private Texture shelfBottomTexture;
    private TextureRegion shelfBottomTextureRegion;

    private Texture shelfMiddleTexture;
    private TextureRegion shelfMiddleTextureRegion;

    private Texture shelfTopTexture;
    private TextureRegion shelfTopTextureRegion;

    private Textures () {

    }

    public void load () {

        boxTexture = new Texture ( Gdx.files.internal ( "textures/box.png" ) );
        boxTextureRegion = new TextureRegion ( boxTexture );

        shelfBottomTexture = new Texture ( Gdx.files.internal ( "textures/shelf-bottom.png" ) );
        shelfBottomTextureRegion = new TextureRegion ( shelfBottomTexture );

        shelfMiddleTexture = new Texture ( Gdx.files.internal ( "textures/shelf-middle.png" ) );
        shelfMiddleTextureRegion = new TextureRegion ( shelfMiddleTexture );

        shelfTopTexture = new Texture ( Gdx.files.internal ( "textures/shelf-top.png" ) );
        shelfTopTextureRegion = new TextureRegion ( shelfTopTexture );

    }

    public void dispose () {

        boxTexture.dispose ();
        shelfBottomTexture.dispose ();
        shelfMiddleTexture.dispose ();
        shelfTopTexture.dispose ();

    }

    public static Textures get () {
        return INSTANCE;
    }

    public Texture getBoxTexture () {
        return boxTexture;
    }

    public TextureRegion getBoxTextureRegion () {
        return boxTextureRegion;
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
