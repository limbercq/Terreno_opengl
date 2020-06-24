package com.example.terreno;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Arbol2 {
	/**
	 * 3 --------- 2 /| /| / | / | 7 --------- 6 | | | | | | 0 ------|-- 1 | / |
	 * / |/ |/ 4 --------- 5
	 */
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			// Frente 
			-1-2+0.8f-1.6f, -1, 1+2-0.8f, // 4 0
			1-2-0.8f-1.6f, -1, 1+2-0.8f, // 5 1
			1-1-2-1.6f, 1, 1-1+2, // 6 2
			-1+1-2-1.6f, 1, 1-1+2, // 7 3
			// Atr�s
			-1+1-2-1.6f, 1, -1+1+2, // 3 4
			1-1-2-1.6f, 1, -1+1+2, // 2 5
			1-2-0.8f-1.6f, -1, -1+2+0.8f, // 1 6
			-1-2+0.8f-1.6f, -1, -1+2+0.8f, // 0 7
						
			// Izquierda 
			-1-2+0.8f-1.6f ,-1, -1+2+0.8f, // 0 8 
			-1-2+0.8f-1.6f, -1, 1+2-0.8f, // 4 9 
			-1+1-2-1.6f, 1, 1-1+2, // 7 10 
			-1+1-2-1.6f, 1, -1+1+2, // 3 11
			// Derecha
			1-2-0.8f-1.6f, -1, 1+2-0.8f, // 5 12
			1-2-0.8f-1.6f, -1, -1+2+0.8f, // 1 13
			1-1-2-1.6f, 1, -1+1+2, // 2 14
			1-1-2-1.6f, 1, 1-1+2, // 6 15
			// Abajo
			-1-2+0.8f-1.6f, -1, -1+2+0.8f, // 0 16
			1-2-0.8f-1.6f, -1, -1+2+0.8f, // 1 17
			1-2-0.8f-1.6f, -1, 1+2-0.8f, // 5 18
			-1-2+0.8f-1.6f, -1, 1+2-0.8f, // 4 19
			// Arriba
			-1+1-2-1.6f, 1, 1-1+2, // 7 20
			1-1-2-1.6f, 1, 1-1+2, // 6 21
			1-1-2-1.6f, 1, -1+1+2, // 2 22
			-1-1-2-1.6f, 1, -1+1+2 // 3 23
	};

	/* Los colores x c/v�rtice (r,g,b,a) */
	byte maxColor = (byte) 255;
	private byte colores[] = new byte[] {
			0, maxColor, 0, maxColor, // 7 20
			0, maxColor, 0, maxColor, // 6 21
			0, maxColor, 0, maxColor, // 2 22
			0, maxColor, 0, maxColor, // 3 23
			// Atr�s - amarillo
			0, maxColor, 0, maxColor, // 7 20
			0, maxColor, 0, maxColor, // 6 21
			0, maxColor, 0, maxColor, // 2 22
			0, maxColor, 0, maxColor ,// 3 23
			// Izquierda - celeste
			0, maxColor, 0, maxColor, // 7 20
			0, maxColor, 0, maxColor, // 6 21
			0, maxColor, 0, maxColor, // 2 22
			0, maxColor, 0, maxColor, // 3 23
			// Derecha - rojo
			0, maxColor, 0, maxColor, // 7 20
			0, maxColor, 0, maxColor, // 6 21
			0, maxColor, 0, maxColor, // 2 22
			0, maxColor, 0, maxColor, // 3 23
			// Abajo - azul
			0, maxColor, 0, maxColor, // 7 20
			0, maxColor, 0, maxColor, // 6 21
			0, maxColor, 0, maxColor, // 2 22
			0, maxColor, 0, maxColor, // 3 23
			// Arriba - verde
			0, maxColor, 0, maxColor, // 7 20
			0, maxColor, 0, maxColor, // 6 21
			0, maxColor, 0, maxColor, // 2 22
			0, maxColor, 0, maxColor // 3 23
	};
	/* Indices */
	private short indices[] = new short[] { 0, 1, 2, 0, 2, 3, // Frente
			4, 5, 6, 4, 6, 7, // Atr�s
			8, 9, 10, 8, 10, 11, // Izquierda
			12, 13, 14, 12, 14, 15, // Derecha
			16, 17, 18, 16, 18, 19, // Abajo
			20, 21, 22, 20, 22, 23 // Arriba
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public Arbol2() {
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer

		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte
												// nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
	}

	public void dibuja(GL10 gl) {
		/* Se habilita el acceso al arreglo de v�rtices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		/* Se especifica los datos del arreglo de v�rtices */
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