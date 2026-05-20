package cg.bouncycube;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Cube {
    private final FloatBuffer vertexBuffer;
    private final ByteBuffer colorBuffer;
    private final ByteBuffer triangleFan1;
    private final ByteBuffer triangleFan2;

    public Cube() {
        float[] vertices = {
                -1.0f,  1.0f,  1.0f,
                 1.0f,  1.0f,  1.0f,
                 1.0f, -1.0f,  1.0f,
                -1.0f, -1.0f,  1.0f,
                -1.0f,  1.0f, -1.0f,
                 1.0f,  1.0f, -1.0f,
                 1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f, -1.0f
        };

        byte maxColor = (byte) 255;
        byte[] colors = {
                maxColor, 0, 0, maxColor,
                maxColor, 0, 0, maxColor,
                maxColor, 0, 0, maxColor,
                maxColor, 0, 0, maxColor,
                0, 0, 0, maxColor,
                0, 0, 0, maxColor,
                0, 0, 0, maxColor,
                0, 0, 0, maxColor
        };

        byte[] tFan1 = {
                1, 0, 3,
                1, 3, 2,
                1, 2, 6,
                1, 6, 5,
                1, 5, 4,
                1, 4, 0
        };

        byte[] tFan2 = {
                7, 4, 5,
                7, 5, 6,
                7, 6, 2,
                7, 2, 3,
                7, 3, 0,
                7, 0, 4
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        colorBuffer = ByteBuffer.allocateDirect(colors.length);
        colorBuffer.put(colors);
        colorBuffer.position(0);

        triangleFan1 = ByteBuffer.allocateDirect(tFan1.length);
        triangleFan1.put(tFan1);
        triangleFan1.position(0);

        triangleFan2 = ByteBuffer.allocateDirect(tFan2.length);
        triangleFan2.put(tFan2);
        triangleFan2.position(0);
    }

    public void draw(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, colorBuffer);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, 18, GL10.GL_UNSIGNED_BYTE, triangleFan1);
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, 18, GL10.GL_UNSIGNED_BYTE, triangleFan2);

        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
