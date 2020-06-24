package com.informatica.umsa.terreno;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Casita {
	private float vertices[] = new float [] {
			//BASE NMQ NQR
			1.7f, -3.7f, -1,		//N 0
			-1.7f, -3.7f, -1,		//M 1
			-1.7f, 3.7f, -1,		//Q 2
			1.7f, 3.7f, -1,		    //R	3			
			//frente alto BIJC
			1, -1, -1, 		//B 4
			1, -1, 3,		//I 5
			1, 1, 3,		//J 6
			1, 1, -1,		//C 7
			//frente ancho NPTR
			1, -3, -1,		//N 8
			1, -3, 1,		//P 9
			1, 3, 1,		//T 10
			1, 3, -1,		//R	11
			
			//atras alto KLAD
			-1, -1, -1, 	//A 12
			-1, 1, -1,		//D 13
			-1, 1, 3,		//L 14
			-1, -1, 3,		//K 15
			//atras ancho MOSQ
			-1, -3, -1,		//M 16
			-1, -3, 1,		//O 17
			-1, 3, 1,		//S 18
			-1, 3, -1,		//Q 19
			//pared izq arriba EKIF
			-1, -1, 1.8f,	//E 20
			-1, -1, 3,		//K 21
			1, -1, 3,		//I 22
			1, -1, 1.8f,	//F 23
			//pared izq abajo MOPN
			-1, -3, -1,		//M 24
			-1, -3, 1,		//O 25
			1, -3, 1,		//P 26
			1, -3, -1,		//N 27
			//pared der arriba GJLH
			1, 1, 1.8f,		//G 28
			1, 1, 3,		//J 29
			-1, 1, 3,		//L 30
			-1, 1, 1.8f,	//H 31
			//pared der abajo RTSQ
			1, 3, -1,		//R	32
			1, 3, 1,		//T 33
			-1, 3, 1,		//S 34
			-1, 3, -1,		//Q 35
			//techo izq OEFP
			-1.2f, -3.2f, 1,		//O 36
			-1.2f, -1f, 1.8f,	//E 37
			1.2f, -1f, 1.8f,	//F 38
			1.2f, -3.2f, 1,		//P 39
			//techo der TGHS
			1.2f, 3.2f, 1,		//T 40
			1.2f, 1, 1.8f,		//G 41
			-1.2f, 1, 1.8f,	//H 42			
			-1.2f, 3.2f, 1,		//S 43
			//huecos techo PFGT
			1, -3, 1,		//P 44
			1, -1, 1.8f,	//F 45
			1, 1, 1.8f,		//G 46
			1, 3, 1,		//T 47
			//hueco atras SHEO
			-1, 3, 1,		//S 48
			-1, 1, 1.8f,	//H 49			
			-1, -1, 1.8f,	//E 50
			-1, -3, 1,		//O 51
			//techo arriova	
			//IUJ
			1.15f, -1.15f, 3,		//I 52
			0.15f, 0.15f, 4,		//U 53
			1.15f, 1.15f, 3,		//J 54
			//KUI
			-1.15f, -1.15f, 3,		//K 55
			1.15f, -1.15f, 3,		//I 56
			0.15f, 0.15f, 4,		//U 57
			//LUK
			-1.15f, 1.15f, 3,		//L 58
			0.15f, 0.15f, 4,		//U 59
			-1.15f, -1.15f, 3,		//K 60
			//JUL
			1.15f, 1.15f, 3,		//J 61
			0.15f, 0.15f, 4,		//U 62
			-1.15f, 1.15f, 3,		//L 63
			//ventana izq C1 F1 E1 D1
			1.1f, -2.5f, -0.5f,//C1 64
			1.1f, -2.5f, 0.4f,	//F1 65
			1.1f, -1.5f, 0.4f, //E1 66 
			1.1f, -1.5f, -0.5f,//D1 67
			
			//F1 K1 E1
			1.1f, -2.5f, 0.4f,	//F1 68
			1.1f, -2, 0.8f,		//K1 69
			1.1f, -1.5f, 0.4f, 	//E1 70 
			
			//ventana der  H I L J G 1
			1.1f, 1.5f, -0.5f,	//H1 71
			1.1f, 1.5f, 0.4f,	//I1 72
			1.1f, 2.5f, 0.4f,	//J1 73
			1.1f, 2.5f, -0.5f,	//G1 74
			//I L J 1
			1.1f, 1.5f, 0.4f,	//I1 75
			1.1f, 2, 0.8f,		//L1 76
			1.1f, 2.5f, 0.4f,	//J1 77
			
			// puerta V A1  Z W
			1.1f, -0.7f, -1,	//V 78
			1.1f, -0.7f, 0.1f,	//A1 79
			1.1f, 0.7f, 0.1f,	//Z 80
			1.1f, 0.7f, -1,	//W 81
			
			// A1 B1 Z
			1.1f, -0.7f, 0.1f,	//A1 82
			1.1f, 0, 0.7f,		//B1 83
			1.1f, 0.7f, 0.1f,	//Z 84
			//ventanar atras
			//ventana izq C1 F1 E1 D1
			-1.1f, -2.5f, -0.5f,//C1 85
			-1.1f, -2.5f, 0.4f,	//F1 86
			-1.1f, -1.5f, 0.4f, //E1 87 
			-1.1f, -1.5f, -0.5f,//D1 88
			
			//F1 K1 E1
			-1.1f, -2.5f, 0.4f,	//F1 89
			-1.1f, -2, 0.8f,		//K1 90
			-1.1f, -1.5f, 0.4f, 	//E1 91 
			
			//ventana der  H I L J G 1
			-1.1f, 1.5f, -0.5f,	//H1 92
			-1.1f, 1.5f, 0.4f,	//I1 93
			-1.1f, 2.5f, 0.4f,	//J1 94
			-1.1f, 2.5f, -0.5f,	//G1 95
			//I L J 1
			-1.1f, 1.5f, 0.4f,	//I1 96
			-1.1f, 2, 0.8f,		//L1 97
			-1.1f, 2.5f, 0.4f,	//J1 98
			
			
			/*
			 
			
			 *
			 *  
			1, -1, -1, 		//B 1
			1, 1, -1,		//C 2
			-1, 1, -1,		//D 3
			
			
			
			
			
			
			-1, -3, -1,		//M 12
			1, -3, -1,		//N 13
			
			1, -3, 1,		//P 15
								
			
			1, 3, 1,		//T 19
			
			1, -0.7f, -1,	//V 21
			1, 0.7f, -1,	//W 22
			1, 0.7f, 0.1f,	//Z 23
			1, -0.7f, 0.1f,	//A1 24
			
			1, -2.5f, -0.5f,//C1 26
			1, -1.5f, -0.5f,//D1 27
			1, -1.5f, 0.4f,	//E1 28
			1, -2.5f, 0.4f,	//F1 29
			1, 2.5f, -0.5f,	//G1 30
			1, 1.5f, -0.5f,	//H1 31
			1, 1.5f, 0.4f,	//I1 32
			1, 2.5f, 0.4f,	//J1 33
			1, -2, 0.8f,	//K1 34
			1, 2, 0.8f,		//L1 35
			0, 0, 5,		//M1 36
			0, -0.4f, 4.5f,	//N1 37
			0, 0.4f, 4.5f,	//O1 38
		*/	
			
	};

	byte maxColor = (byte)255;
	
	/* Los colores x c/v�rtice (r,g,b,a) */
	private byte colores[] = new byte[] { 
			//base
			(byte)144, (byte)235, (byte)23, 1, // 0
			(byte)144, (byte)235, (byte)23, 1, // 0
			(byte)144, (byte)235, (byte)23, 1, // 0
			(byte)144, (byte)235, (byte)23, 1, // 0
			//frente alto		
			(byte)244, (byte)233, (byte)102, 1, // 0
			(byte)244, (byte)233, (byte)102, 1, // 1
			(byte)244, (byte)233, (byte)102, 1, // 2
			(byte)244, (byte)233, (byte)102, 1, // 3
			//frente ancho
			(byte)244, (byte)233, (byte)102, 1, // 0
			(byte)244, (byte)233, (byte)102, 1, // 1
			(byte)244, (byte)233, (byte)102, 1, // 2
			(byte)244, (byte)233, (byte)102, 1, // 3
			//atras alto
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//atras ancho
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//pared izq arriba
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			
			//pared izq abajo
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//pared der arriba
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//pared der abajo
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//techo izq
			(byte)255, (byte)130, (byte)0, 1, // 0
			(byte)255, (byte)130, (byte)0, 1, // 1
			(byte)255, (byte)130, (byte)0, 1, // 2
			(byte)255, (byte)130, (byte)0, 1, // 3			
			//techo der
			(byte)255, (byte)130, (byte)0, 1, // 0
			(byte)255, (byte)130, (byte)0, 1, // 1
			(byte)255, (byte)130, (byte)0, 1, // 2
			(byte)255, (byte)130, (byte)0, 1, // 3
			
			//hueco frente
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//hueco atras
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			//techo
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3
			
			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3
			
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3
			
			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3
			//ventana izq
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			//ventana der
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			//PUERTA
			(byte)135, (byte)90, (byte)11, 1, // 0
			(byte)135, (byte)90, (byte)11, 1, // 0
			(byte)135, (byte)90, (byte)11, 1, // 0
			(byte)135, (byte)90, (byte)11, 1, // 0
			
			(byte)135, (byte)90, (byte)11, 1, // 0
			(byte)135, (byte)90, (byte)11, 1, // 0
			(byte)135, (byte)90, (byte)11, 1, // 0
			//ventanas atras
			//ventana izq
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			
			//ventana der
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			(byte)130, (byte)246, (byte)186, 1, // 0
			
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
			(byte)74, (byte)247, (byte)150, 1, // 0
		/*		
		
		0, maxColor, 0, 1, // 0
		0, maxColor, 0, 1, // 1
		0, maxColor, 0, 1, // 2
		
		maxColor, maxColor, 0, 1, // 0
		maxColor, maxColor, 0, 1, // 1
		maxColor, maxColor, 0, 1, // 2
		
		0, maxColor, maxColor, 1, // 0
		0, maxColor, maxColor, 1, // 1
		0, maxColor, maxColor, 1, // 2
		
		
	*/	
	};
	

	
	/* Indices */
	private short indices[] = new short [] {
			//base
			0,1,2,0,2,3,
			//frente alto
			4,5,6,4,6,7,			
			//frente ancho
			8,9,10,8,10,11,
			//atras alto
			12,13,14,12,14,15,
			//atras ancho
			16,17,18,16,18,19,
			//pared izq arriva
			20,21,22,20,22,23,
			//pared izq abajo
			24,25,26,24,26,27,
			//pared der arriba
			28,29,30,28,30,31,
			//pared der abajo
			32,33,34,32,34,35,
			//techo izq
			36,37,38,36,38,39,
			//techo der
			40,41,42,40,42,43,
			//hueco frente
			44,45,47,44,46,47,
			//hueco atras
			48,49,51,48,50,51,
			//techo 
			52,53,54,
			55,56,57,
			58,59,60,
			61,62,63,
			//ventana izq
			64,65,66,64,66,67,
			68,69,70,
			//ventana der
			71,72,73,71,73,74,
			75,76,77,
			//puerta
			78,79,80,78,80,81,
			82,83,84,
			//ventana izq
			85,86,87,85,87,88,
			89,90,91,
			//ventana der
			92,93,94,92,94,95,
			96,97,98,
	};
	
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;	

	public Casita() {
		
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
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
		
		/* Se habilita el acceso al arreglo de v�rtices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		/* Se especifica los datos del arreglo de v�rtices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);

		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);

		/* Renderiza las primitivas desde los datos de los arreglos (v�rtices,
		 * colores e �ndices) */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);

		/* Se deshabilita el acceso al arreglo de v�rtices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		//* Se deshabilita el acceso al arreglo de colores */
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}
}
