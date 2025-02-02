package org.thebungine.engine.render;

import org.joml.Matrix4f;
import org.thebungine.engine.platform.opengl.OpenGLShader;
import org.thebungine.engine.render.buffer.VertexArray;
import org.thebungine.engine.render.shader.Shader;

public class Scene {

    private OrthographicCamera camera;

    public Scene() {

    }

    public Scene withCamera(OrthographicCamera camera) {
        this.camera = camera;
        camera.recalculateViewMatrix();

        return this;
    }

    public Scene submit(VertexArray vertexArray, Shader shader, Matrix4f transform)
    {
        shader.bind();
        vertexArray.bind();

        ((OpenGLShader)shader).uploadUniformMat4("uViewProjection", camera.getViewProjection());
        ((OpenGLShader)shader).uploadUniformMat4("uTransform", transform);

        RenderCommand.drawIndexed(vertexArray);

        return this;
    }

    public void end() {

    }
}