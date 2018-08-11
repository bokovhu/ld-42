package me.bokov.ld42.store;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Fonts {

    private static Fonts INSTANCE = new Fonts ();

    private BitmapFont droidSansMono12;
    private BitmapFont droidSansMono16;
    private BitmapFont droidSansMono24;
    private BitmapFont droidSandMono32;

    private Fonts () {

    }

    public void load () {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator ( Gdx.files.internal ( "fonts/DroidSansMono.ttf" ) );
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter ();

        parameter.size = 12;
        droidSansMono12 = generator.generateFont ( parameter );

        parameter.size = 16;
        droidSansMono16 = generator.generateFont ( parameter );

        parameter.size = 24;
        droidSansMono24 = generator.generateFont ( parameter );

        parameter.size = 32;
        droidSandMono32 = generator.generateFont ( parameter );

        generator.dispose ();

    }

    public void dispose () {

        droidSansMono12.dispose ();
        droidSansMono16.dispose ();
        droidSansMono24.dispose ();
        droidSandMono32.dispose ();

    }

    public static Fonts get () {
        return INSTANCE;
    }

    public BitmapFont getDroidSansMono12 () {
        return droidSansMono12;
    }

    public BitmapFont getDroidSansMono16 () {
        return droidSansMono16;
    }

    public BitmapFont getDroidSansMono24 () {
        return droidSansMono24;
    }

    public BitmapFont getDroidSandMono32 () {
        return droidSandMono32;
    }
}
