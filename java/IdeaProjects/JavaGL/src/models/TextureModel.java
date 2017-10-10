package models;

import engine_tester.RawModel;
import textures.ModelTexture;

/**
 * Created by root on 7/25/17.
 */
public class TextureModel {

    private RawModel rawModel;
    private ModelTexture texture;

    public TextureModel(RawModel model, ModelTexture texture){
        this.rawModel = model;
        this.texture = texture;
    }

    public RawModel getRawModel() {
        return rawModel;
    }

    public ModelTexture getTexture() {
        return texture;
    }
}
