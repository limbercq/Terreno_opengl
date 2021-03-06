package com.informatica.umsa.terreno;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Estadium4 {
	/**
	 * 3 --------- 2 /| /| / | / | 7 --------- 6 | | | | | | 0 ------|-- 1 | / |
	 * / |/ |/ 4 --------- 5
	 */
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			// Frente 
			0, -6, 5.98f, // 4 0
			4.7f, -6, 3.5f, // 5 1
			6.95f, -1 , 8.3f, // 6 2
			0, -1, 10.98f, // 7 3
					
			// Atr�s
			0, -1, 1.23f, // 3 4
			9.7f, -1, 1.23f, // 2 5
			4.7f, -6, 1.23f, // 1 6
			0, -6, 1.23f, // 0 7
			
			// Izquierda 
			0, -6, 1.23f, // 0 8 
			0, -6, 5.98f, // 4 9 
			0, -1, 10.98f, // 7 10 
			0, -1, 1.23f, // 3 11
			
			
			// Derecha
			4.7f, -6, 3.5f, // 5 12
			4.7f, -6, 1.23f, // 1 13
			9.7f, -1, 1.23f, // 2 14
			6.95f, -1 , 8.3f, // 6 15
			// Abajo
			0, -6, 1.23f, // 0 16
			4.7f, -6, 1.23f, // 1 17
			4.7f, -6, 3.5f, // 5 18
			0, -6, 5.98f, // 4 19
			// Arriba
			0, -1, 10.98f, // 7 20
			6.95f, -1 , 8.3f, // 6 21
			9.7f, -1, 1.23f, // 2 22
			0, -1, 1.23f, // 3 23
	};

	/* Los colores x c/v�rtice (r,g,b,a) */
	byte maxColor = (byte) 255;
	private byte colores[] = new byte[] {
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Atr�s - amarillo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Izquierda - celeste
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Abajo - azul
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Arriba - verde
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
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

	public Estadium4() {
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
