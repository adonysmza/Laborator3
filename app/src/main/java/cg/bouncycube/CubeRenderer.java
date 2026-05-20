package cg.bouncycube;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CubeRenderer implements GLSurfaceView.Renderer {
    private final Cube cube;
    private float transY;
    private float angle;

    public CubeRenderer() {
        cube = new Cube();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, (float) Math.sin(transY), -7.0f);
        gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(angle, 1.0f, 0.0f, 0.0f);

        // Cerinta de test: dubleaza inaltimea cubului pe axa Y.
        gl.glScalef(1.0f, 2.0f, 1.0f);

        transY += 0.075f;
        angle += 0.4f;

        cube.draw(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float fieldOfView = 30.0f / 57.3f;
        float aspectRatio = (float) width / (float) height;
        float zNear = 0.1f;
        float zFar = 1000.0f;
        float size = zNear * (float) Math.tan(fieldOfView / 2.0f);

        gl.glFrustumf(-size, size, -size / aspectRatio, size / aspectRatio, zNear, zFar);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL10.GL_CULL_FACE);

        // Pentru testul din assignment poti decomenta:
        // gl.glCullFace(GL10.GL_FRONT);

        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);
    }
}
