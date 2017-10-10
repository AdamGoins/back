package engine_tester;

/**
 * Created by root on 7/25/17.
 */
public class RawModel {

    private int vaoID;
    private int vertexCount;

    public RawModel(int vaoID, int vertexCount){
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;

    }

    public int getVaoID() {
        return vaoID;
    }

    public int getVertexCount() {
        return vertexCount;
    }
}
