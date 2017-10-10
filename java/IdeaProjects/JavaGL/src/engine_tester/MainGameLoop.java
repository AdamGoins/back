package engine_tester;

import models.TextureModel;
import org.lwjgl.opengl.Display;
import render.DisplayManager;
import render.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

/**
 * Created by root on 7/25/17.
 */
public class MainGameLoop {

    public static void main(String[] args){

        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {

                // Left bottom of triangle
                -0.5f, 0.5f, 0,
                -0.5f, -0.5f, 0,
                0.5f, -0.5f, 0,
                0.5f, 0.5f, 0,
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2
        };

        float[] textureCoords = {
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("image"));
        TextureModel textureModel = new TextureModel(model, texture);

        while(!Display.isCloseRequested()){
            // Game logic

            renderer.prepare();
            shader.start();
            renderer.render(textureModel);
            shader.stop();
            DisplayManager.updateDisplay();

        }

shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }
}
