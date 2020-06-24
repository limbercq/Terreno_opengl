package com.informatica.umsa.terreno;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Casa1 {
	private float vertices[] = new float [] {
			//primer pilar
			4,-3.8f,0,	//A
			4,-3.8f,4,	//E
			4,-3,4,		//D
			4,-3,0,		//C//			
			4,-3.8f,3,	//B
			4,-3.8f,4,	//E
			4,0,4,		//F
			4,0,3,		//G//			
			-3,-3.8f,0,	//I
			-3,-3.8f,4,	//H
			-3,-3,4,	//M
			-3,-3,0,	//J//			
			-3,-3.8f,3, //N
			-3,-3.8f,4,	//H
			-3,0,4,		//K
			-3,0,3,		//L//			
			4,-3.8f,0,	//A
			-3,-3.8f,0,	//I
			-3,-3.8f,4,	//H
			4,-3.8f,4,	//E//			
			4,-3.8f,4,	//E
			-3,-3.8f,4,	//H
			-3,0,4,		//K
			4,0,4,		//F//		
			4,-3.8f,3,	//B
			-3,-3.8f,3, //N
			-3,0,3,		//L
			4,0,3,		//G			
			//do pilar
			1.5f,-1.5f,5,//o
			1.5f,-1.5f,6,//P
			1.5f,4.5f,6,//R
			1.5f,4.5f,5,//Q		
			1.5f,3.5f,0,//V
			1.5f,3.5f,6,//T
			1.5f,4.5f,6,//R
			1.5f,4.5f,0,//U			
			-3,-1.5f,5,//o
			-3,-1.5f,6,//P
			-3,4.5f,6,//R
			-3,4.5f,5,//Q			
			-3,3.5f,0,//V
			-3,3.5f,6,//T
			-3,4.5f,6,//R
			-3,4.5f,0,//U
			//techo2
			1.5f,-1.5f,6,//P
			-3,-1.5f,6,	 //P
			-3,4.5f,6,	 //R
			1.5f,4.5f,6, //R	
			1.5f,-1.5f,5,//o
			-3,-1.5f,5,	 //o
			-3,4.5f,5,	 //Q
			1.5f,4.5f,5, //Q
			
			//pared
			4,-3,0,		//C
			4,-3,4,		//D
			-3,-3,4,	//M
			-3,-3,0,	//J
			//p2
			1.5f,4.5f,6,//R
			1.5f,4.5f,0,//U
			-3,4.5f,0,//U
			-3,4.5f,6,//R
			//p21
			1.5f,3.5f,0,//V
			1.5f,3.5f,6,//T
			-3,3.5f,6,	//T
			-3,3.5f,0,	//V	//
			
			1.5f,-1.5f,5,//o
			1.5f,-1.5f,6,//P
			-3,-1.5f,6,//P
			-3,-1.5f,5,//o//
			4,0,3,		//G
			4,0,4,		//F
			-3,0,4,		//K
			-3,0,3,		//L//
			//adelante
			1.5f,-3,0,
			1.5f,-3,3,
			1.5f,0,3,
			1.5f,0,0,
			
			1.5f,0,0,
			1.5f,0,5,
			1.5f,3.5f,5,
			1.5f,3.5f,0,
			//atraz
			-3,-3,0,
			-3,-3,3,
			-3,0,3,
			-3,0,0,
			
			-3,0,0,
			-3,0,5,
			-3,3.5f,5,
			-3,3.5f,0,
			
	};
	byte maxColor = (byte)255;

	private byte colores[] = new byte[] {
			
			
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			
			(byte)148, (byte)196, (byte)213, 1, // 3
			(byte)148, (byte)196, (byte)213, 1, // 3
			(byte)148, (byte)196, (byte)213, 1, // 3
			(byte)148, (byte)196, (byte)213, 1, // 3
			
			(byte)148, (byte)196, (byte)213, 1, // 3
			(byte)148, (byte)196, (byte)213, 1, // 3
			(byte)148, (byte)196, (byte)213, 1, // 3
			(byte)148, (byte)196, (byte)213, 1, // 3
			
			//pared asuzl
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			//techo
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			//pilar 2
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			(byte)111, (byte)168, (byte)188, 1, // 3
			//techo2
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			(byte)106, (byte)134, (byte)148, 1, // 3
			
			//pared
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			(byte)131, (byte)159, (byte)190, 1, // 3
			//adelante
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
			(byte)95, (byte)92, (byte)105, 1, // 3
	};
	private short indices[] = new short [] {
			//techo 
			0,1,2,0,2,3,
			4,5,6,4,6,7,
			8,9,10,8,10,11,
			12,13,14,12,14,15,
			16,17,18,16,18,19,
			20,21,22,20,22,23,
			24,25,26,24,26,27,
			//pilar2
			28,29,30,28,30,31,
			32,33,34,32,34,35,
			36,37,38,36,38,39,
			40,41,42,40,42,43,
			//techo2
			44,45,46,44,46,47,
			48,49,50,48,50,51,
			//pared 
			52,53,54,52,54,55,
			56,57,58,56,58,59,
			60,61,62,60,62,63,
			64,65,66,64,66,67,
			68,69,70,68,70,71,
			//adenate
			72,73,74,72,74,75,
			76,77,78,76,78,79,
			//atras
			80,81,82,80,82,83,
			84,85,86,84,86,87,
	};

	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;	

	public Casa1() {
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer	
	}
	public void dibuja(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

	}
}
