package com.example.practica4oliver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CanvasView canvasView;
    ConstraintLayout constraintLayout;
    Button btnBibujar;
    Audio audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mostrar el canvas y muestra la pantalla completa
        //setContentView(new CanvasView(this));

        canvasView = new CanvasView(this);
        constraintLayout = findViewById(R.id.constraintLayout2);
        constraintLayout.addView(canvasView);

        canvasView.activarBitmap();

        audio = new Audio();
        audio.inicializar(getApplicationContext());

        btnBibujar = findViewById(R.id.botonDibujar);

        btnBibujar.setOnClickListener(view -> {
            Intent intent = new Intent(this, PantallaDibujar.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        audio.pararAudioMain();
    }

    @Override
    protected void onStart() {
        super.onStart();
        audio.comenzarAudioMain();
    }

    @Override
    protected void onStop() {
        super.onStop();
        audio.pausarAudioMain();
    }
}
