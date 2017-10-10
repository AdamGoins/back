package shaders;

import com.sun.prism.ps.Shader;

/**
 * Created by root on 7/25/17.
 */
public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/shaders/vertextShader.txt";
    private static final String FRAGMENT_FILE = "src/shaders/framentShader.txt";

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "textureCoords");
    }
}
