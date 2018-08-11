package me.bokov.ld42.store;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

    private static Textures INSTANCE = new Textures ();

    private Texture boxTexture;
    private TextureRegion boxTextureRegion;

    private Texture shelf1Texture;
    private TextureRegion shelf1TextureRegion;

    private Texture shelf2Texture;
    private TextureRegion shelf2TextureRegion;

    private Texture shelf3Texture;
    private TextureRegion shelf3TextureRegion;

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

        shelf1Texture = new Texture ( Gdx.files.internal ( "textures/shelf-1.png" ) );
        shelf1TextureRegion = new TextureRegion ( shelf1Texture );

        shelf2Texture = new Texture ( Gdx.files.internal ( "textures/shelf-2.png" ) );
        shelf2TextureRegion = new TextureRegion ( shelf2Texture );

        shelf3Texture = new Texture ( Gdx.files.internal ( "textures/shelf-3.png" ) );
        shelf3TextureRegion = new TextureRegion ( shelf3Texture );


        shelfBottomTexture = new Texture ( Gdx.files.internal ( "textures/shelf-bottom.png" ) );
        shelfBottomTextureRegion = new TextureRegion ( shelfBottomTexture );

        shelfMiddleTexture = new Texture ( Gdx.files.internal ( "textures/shelf-middle.png" ) );
        shelfMiddleTextureRegion = new TextureRegion ( shelfMiddleTexture );

        shelfTopTexture = new Texture ( Gdx.files.internal ( "textures/shelf-top.png" ) );
        shelfTopTextureRegion = new TextureRegion ( shelfTopTexture );

    }

    public void dispose () {

        boxTexture.dispose ();
        shelf1Texture.dispose ();
        shelf2Texture.dispose ();
        shelf3Texture.dispose ();
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

    public Texture getShelf1Texture () {
        return shelf1Texture;
    }

    public TextureRegion getShelf1TextureRegion () {
        return shelf1TextureRegion;
    }

    public Texture getShelf2Texture () {
        return shelf2Texture;
    }

    public TextureRegion getShelf2TextureRegion () {
        return shelf2TextureRegion;
    }

    public Texture getShelf3Texture () {
        return shelf3Texture;
    }

    public TextureRegion getShelf3TextureRegion () {
        return shelf3TextureRegion;
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
