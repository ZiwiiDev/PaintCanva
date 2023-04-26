package com.example.practica4oliver;

import android.content.Context;
import android.media.MediaPlayer;

public class Audio {

    private MediaPlayer mpMain;
    private MediaPlayer mpDibujar;

    public void inicializar (Context context) {
        mpMain = MediaPlayer.create(context, R.raw.audio);
        mpDibujar = MediaPlayer.create(context, R.raw.audio_dibujo);

        //Cuando queremos que se inicie
        mpMain.seekTo(0);
        mpDibujar.seekTo(0);
    }

    public void comenzarAudioMain() {
        //Inicia audio
        mpMain.start();
    }

    public void pausarAudioMain() {
        //Pausar el audio
        mpMain.pause();
    }

    public void bucleAudioMain() {
        //Para que se ejecute muchas veces
        mpMain.setLooping(true);
    }

    public void pararAudioMain() {
        mpMain.stop();
    }

    public void comenzarAudioDibujo () {
        mpDibujar.start();
    }

    public void pausarAudioDibujo () {
        mpDibujar.pause();
    }

    public void bucleAudioDibujo() {
        //Para que se ejecute muchas veces
        mpMain.setLooping(true);
    }

    public void pararAudioDibujo () {
        mpDibujar.stop();
    }
}
