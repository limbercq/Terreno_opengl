package com.example.terreno;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Casa3 {

    private float vertices[] = new float[]{
            // Frente
            -1f, 0.0f, 0.5f, // 4 0
            1f, 0.0f, 0.5f, // 5 1
            1f, 0.5f, 0.5f, // 6 2
            -1f, 0.5f, 0.5f, // 7 3
            // Atrás
            -1f, 0.5f, -0.5f, // 3 4
            1f, 0.5f, -0.5f, // 2 5
            1f, 0.0f, -0.5f, // 1 6
            -1f, 0.0f, -0.5f, // 0 7
            // Izquierda
            -1f, 0.0f, -0.5f, // 0 8
            -1f, 0.0f, 0.5f, // 4 9
            -1f, 0.5f, 0.5f, // 7 10
            -1f, 0.5f, -0.5f, // 3 11
            // Derecha
            1f, 0.0f, 0.5f, // 5 12
            1f, 0.0f, -0.5f, // 1 13
            1f, 0.5f, -0.5f, // 2 14
            1f, 0.5f, 0.5f, // 6 15
            // Abajo
            -1f, 0.5f, -0.5f, // 0 16
            1, 0.5f, -0.5f, // 1 17
            1f, 0.5f, 0.5f, // 5 18
            -1f, 0.5f, 0.5f, // 4 19
            // Arriba
            -1f, 0.5f, 0.5f, // 7 20
            1f, 0.5f, 0.5f, // 6 21
            1f, 0.5f, -0.5f, // 2 22
            -1f, 0.5f, -0.5f // 3 23
    };

    /* Indices */
    private short indices[] = new short[]{
            0, 1, 2, 0, 2, 3, // Frente
            4, 5, 6, 4, 6, 7, // Atrás
            8, 9, 10, 8, 10, 11, // Izquierda
            12, 13, 14, 12, 14, 15, // Derecha
            16, 17, 18, 16, 18, 19, // Abajo
            20, 21, 22, 20, 22, 23 // Arriba
    };
    private FloatBuffer bufVertices;
    private ByteBuffer bufColores;
    private ShortBuffer bufIndices;

    public Casa3(byte colores[]) {
        /* Lee los vértices */
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind(); // puntero al principio del buffer

        /* Lee los colores */
        bufColores = ByteBuffer.allocateDirect(colores.length);
        bufColores.put(colores);
        bufColores.position(0); // puntero al principio del buffer
        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(indices);
        bufIndices.rewind(); // puntero al principio del buffer
    }

    public void dibuja(GL10 gl) {
        /* Se habilita el acceso al arreglo de vértices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        /* Se habilita el acceso al arreglo de colores */
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        /* Se especifica los datos del arreglo de vértices */
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        /* Se especifica los datos del arreglo de colores */
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
        /* Se dibuja el cubo */
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices);
        /* Se deshabilita el acceso a los arreglos */
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
