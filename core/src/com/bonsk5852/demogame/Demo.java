package com.bonsk5852.demogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Demo extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;
    private float x;
    private float y;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        x = 0;
        y = 0;
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= 2;
        }

        // mouse/touch stuff
        if (Gdx.input.isTouched()) {
            int mouseX = Gdx.input.getX();
            int mouseY = Gdx.input.getY();
            if (mouseX > Gdx.app.getGraphics().getWidth() / 2) {
                x += 1;
            } else if (mouseX < Gdx.app.getGraphics().getWidth() / 2) {
                x -= 1;
            }
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
