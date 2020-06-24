package com.informatica.umsa.terreno

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.view.Window;
import android.view.WindowManager;


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
/* Ventana sin título */
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        /* Establece las banderas de la ventana de esta Actividad */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Orientación de la pantalla vertical (PORTRAIT) u horizontal(LANDSCAPE) */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        /* Se crea el objeto Renderiza */
        var superficie =  Renderiza(this);

        /*
         * Activity <- GLSurfaceView  : Coloca la Vista de la Superficie del
         * OpenGL como un Contexto de ésta Actividad.
         */
        setContentView(superficie);
        // setContentView(R.layout.activity_main);

    }

}
