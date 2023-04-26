package com.example.practica4oliver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PantallaDibujar extends AppCompatActivity implements View.OnClickListener{

    static CanvasView canvasView;
    ConstraintLayout constraintLayout;
    Audio audio;
    Button btnBorrar;
    Button btnVolver;

    ImageButton imagenCirculo;
    ImageButton dibujarImagen;

    ImageButton colorRojo;
    ImageButton colorAzul;
    ImageButton colorAmarillo;
    ImageButton imagenEstrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dibujar);

        // Mostrar el canvas y muestra la pantalla completa
        //setContentView(new CanvasView(this));

        canvasView = new CanvasView(this);
        constraintLayout = findViewById(R.id.constraintLayout2);
        constraintLayout.addView(canvasView);

        audio = new Audio();
        audio.inicializar(getApplicationContext());

        colorRojo = findViewById(R.id.colorRojo);
        colorAzul = findViewById(R.id.colorAzul);
        colorAmarillo = findViewById(R.id.colorAmarillo);

        colorRojo.setOnClickListener(this);
        colorAzul.setOnClickListener(this);
        colorAmarillo.setOnClickListener(this);

        imagenCirculo = findViewById(R.id.imagenCirculo);
        imagenEstrella = findViewById(R.id.imagenEstrella);

        btnVolver = findViewById(R.id.btnVolver);
        btnBorrar = findViewById(R.id.btnBorrar);
        dibujarImagen = findViewById(R.id.dibujarImagen);

        imagenCirculo.setOnClickListener(view -> {
            canvasView.pintarCirculo();
        });

        imagenEstrella.setOnClickListener(view -> {
            canvasView.pintarEstrella();
        });

        dibujarImagen.setOnClickListener(view -> {
            canvasView.pintarImagen();
        });

        btnBorrar.setOnClickListener(view -> {
            canvasView.borrarCanvas();
        });

        btnVolver.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            audio.pararAudioDibujo();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        audio.pararAudioDibujo();
    }

    @Override
    protected void onStart() {
        super.onStart();
        audio.comenzarAudioDibujo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        audio.pausarAudioDibujo();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.colorRojo:
                canvasView.setEsRojo();
                canvasView.setColor();
                break;
            case R.id.colorAzul:
                canvasView.setEsAzul();
                canvasView.setColor();
                break;
            case R.id.colorAmarillo:
                canvasView.setEsAmarillo();
                canvasView.setColor();
                break;
        }
    }
}
