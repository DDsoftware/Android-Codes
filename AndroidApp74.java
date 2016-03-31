package com.thenewboston.buckyblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private TextureAtlas shooterAtlas;
    private Animation animation;
    private float timePassed = 0;

    @Override
    public void create () {
      batch = new SpriteBatch();

        shooterAtlas = new TextureAtlas(Gdx.files.internal("shooter.atlas"));
        animation = new Animation(1/30f, shooterAtlas.getRegions());
    }

    @Override
    public void dispose() {
        batch.dispose();
        shooterAtlas.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        timePassed += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(timePassed, true), 300, 500);
        batch.end();
    }

}