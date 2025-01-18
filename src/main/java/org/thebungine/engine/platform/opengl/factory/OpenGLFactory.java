package org.thebungine.engine.platform.opengl.factory;

import org.thebungine.engine.core.RendererFactory;
import org.thebungine.engine.input.Input;
import org.thebungine.engine.platform.opengl.*;
import org.thebungine.engine.render.RendererAPI;
import org.thebungine.engine.render.RendererType;
import org.thebungine.engine.render.buffer.IndexBuffer;
import org.thebungine.engine.render.buffer.VertexArray;
import org.thebungine.engine.render.buffer.VertexBuffer;
import org.thebungine.engine.render.shader.Shader;
import org.thebungine.engine.render.texture.Texture2D;
import org.thebungine.engine.window.Window;
import org.thebungine.engine.window.WindowProperties;

import java.io.IOException;

public class OpenGLFactory implements RendererFactory {

    @Override
    public Window createWindow(WindowProperties windowProperties) {
        return new OpenGLWindow(windowProperties);
    }

    @Override
    public Shader createShader(String vertexShader, String fragmentShader) {
        return new OpenGLShader(vertexShader, fragmentShader);
    }

    @Override
    public VertexBuffer createVertexBuffer(float[] vertices) {
        return new OpenGLVertexBuffer(vertices);
    }

    @Override
    public IndexBuffer createIndexBuffer(int[] indices) {
        return new OpenGLIndexBuffer(indices);
    }

    @Override
    public VertexArray createVertexArray() {
        return new OpenGLVertexArray();
    }

    @Override
    public Texture2D createTexture2D(String path) throws IOException {
        return new OpenGLTexture2D(path);
    }

    @Override
    public RendererAPI instantiateRendererAPI() {
        return new OpenGLRendererAPI();
    }

    @Override
    public Input instantiateInput() {
        return new OpenGLInput();
    }

    @Override
    public RendererType getRendererType() {
        return RendererType.OPENGL;
    }
}
