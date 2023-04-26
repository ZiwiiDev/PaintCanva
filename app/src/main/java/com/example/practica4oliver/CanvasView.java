package com.example.practica4oliver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {

    private float clickX, clickY;
    private static final float RADIO_ESTRELLA = 5;

    private Paint pincel, pincelEstrella, pincelCirculoRojo, pincelCirculoAzul, pincelCirculoAmarillo;

    private Canvas drawCanvas;

    //Path que utilizaré para ir pintando las lineas
    private Path path, pathEstrella;

    private boolean bitmapMain, borrarCanvas, dibujarImagen, dibujarCirculo, dibujarEstrella, esRojo, esAzul, esAmarillo  = false;

    Bitmap icono, imagenCirculo, imagenDibujar, background;

    Display display;

    int anchoFondo, altoFondo;

    Point tamanioFondo;

    Rect pantalla;

    float height, width, controlX = 0, controlY = 0, radio = 30f;

    public CanvasView(Context context) {
        super(context);
        inicializar();
    }

    public void inicializar () {
        pincelEstrella = new Paint();

        pincel = new Paint();
        pincel.setColor(Color.WHITE);
        pincel.setTextSize(120);
        pincel.setTextAlign(Paint.Align.CENTER);

        pincelCirculoRojo = new Paint();
        pincelCirculoRojo.setAntiAlias(true);
        pincelCirculoRojo.setStrokeWidth(10);
        pincelCirculoRojo.setStyle(Paint.Style.FILL);
        pincelCirculoRojo.setStrokeJoin(Paint.Join.ROUND);
        pincelCirculoRojo.setStrokeCap(Paint.Cap.ROUND);

        pincelCirculoAzul = new Paint();
        pincelCirculoAzul.setAntiAlias(true);
        pincelCirculoAzul.setStrokeWidth(10);
        pincelCirculoAzul.setStyle(Paint.Style.FILL);
        pincelCirculoAzul.setStrokeJoin(Paint.Join.ROUND);
        pincelCirculoAzul.setStrokeCap(Paint.Cap.ROUND);

        pincelCirculoAmarillo = new Paint();
        pincelCirculoAmarillo.setAntiAlias(true);
        pincelCirculoAmarillo.setStrokeWidth(10);
        pincelCirculoAmarillo.setStyle(Paint.Style.FILL);
        pincelCirculoAmarillo.setStrokeJoin(Paint.Join.ROUND);
        pincelCirculoAmarillo.setStrokeCap(Paint.Cap.ROUND);

        path = new Path();
        pathEstrella = new Path();

        tamanioFondo = new Point();

        background = BitmapFactory.decodeResource(getResources(), R.mipmap.fondo_primera_pantalla_foreground);
        //display = ((MainActivity) getContext()).getWindowManager().getDefaultDisplay();
        //display.getSize(tamanioFondo);
        anchoFondo = tamanioFondo.x;
        altoFondo = tamanioFondo.y;
        pantalla = new Rect(0, 0, anchoFondo, altoFondo);
    }

    //Tamaño asignado a la vista
    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        imagenCirculo = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(imagenCirculo);

        imagenDibujar = BitmapFactory.decodeResource(getResources(), R.mipmap.imagen_miniatura_dibujar);
    }

    //Actualiza color
    public void setColor(){
        if (esRojo) {
            pincelCirculoRojo.setColor(getResources().getColor(R.color.red));
        } else if (esAzul) {
            pincelCirculoAzul.setColor(getResources().getColor(R.color.blue));
        } else if (esAmarillo) {
            pincelCirculoAmarillo.setColor(getResources().getColor(R.color.yellow));
        }

        pincelEstrella.setColor(getResources().getColor(R.color.black));
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(imagenCirculo, 0, 0, null);

        height = getHeight();
        width = getWidth();

        if (bitmapMain) {
            //canvas.drawBitmap(background, null, pantalla, null);
            canvas.drawText("Dibujando", width / 2, 130, pincel);

            icono = BitmapFactory.decodeResource(getResources(), R.mipmap.pikachu_icono);

            canvas.drawBitmap(icono, 400, 500, pincel);
            invalidate();
        }
    }

    // Cuando clickas la pantalla
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        controlX = event.getX();
        controlY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (dibujarImagen) {
                    drawCanvas.drawBitmap(imagenDibujar, controlX-120, controlY-120, null);
                } else if (dibujarEstrella) {
                    pathEstrella.moveTo(clickX, clickY);
                } else if (dibujarCirculo) {
                    if (esRojo) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoRojo);
                        drawCanvas.drawPath(path, pincelCirculoRojo);
                    } else if (esAzul) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoAzul);
                        drawCanvas.drawPath(path, pincelCirculoAzul);
                    } else if (esAmarillo) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoAmarillo);
                        drawCanvas.drawPath(path, pincelCirculoAmarillo);
                    }
                } else if (borrarCanvas) {
                    path.reset();
                    pathEstrella.reset();
                    drawCanvas.drawColor(Color.WHITE);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (dibujarImagen) {
                    drawCanvas.drawBitmap(imagenDibujar, controlX-120, controlY-120, null);
                } else if (dibujarEstrella) {
                    touchEstrella(controlX, controlY);
                } else if (dibujarCirculo) {
                    if (esRojo) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoRojo);
                        drawCanvas.drawPath(path, pincelCirculoRojo);
                    } else if (esAzul) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoAzul);
                        drawCanvas.drawPath(path, pincelCirculoAzul);
                    } else if (esAmarillo) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoAmarillo);
                        drawCanvas.drawPath(path, pincelCirculoAmarillo);
                    }
                } else if (borrarCanvas) {
                    path.reset();
                    pathEstrella.reset();
                    drawCanvas.drawColor(Color.WHITE);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (dibujarImagen) {
                    drawCanvas.drawBitmap(imagenDibujar, controlX-120, controlY-120, null);
                }else if (dibujarEstrella) {
                    pathEstrella.lineTo(clickX, clickY);
                }else if (dibujarCirculo) {
                    if (esRojo) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoRojo);
                        drawCanvas.drawPath(path, pincelCirculoRojo);
                    } else if (esAzul) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoAzul);
                        drawCanvas.drawPath(path, pincelCirculoAzul);
                    } else if (esAmarillo) {
                        drawCanvas.drawCircle(controlX, controlY, radio, pincelCirculoAmarillo);
                        drawCanvas.drawPath(path, pincelCirculoAmarillo);
                    }
                }else if (borrarCanvas) {
                    path.reset();
                    pathEstrella.reset();
                    drawCanvas.drawColor(Color.WHITE);
                    invalidate();
                }
                break;
            }
        invalidate();
        return true;
    }

    private void touchEstrella(float x, float y) {
        float direccionX = Math.abs(x - clickX);
        float direccionY = Math.abs(y - clickY);
        if (direccionX >= RADIO_ESTRELLA || direccionY >= RADIO_ESTRELLA) {
            pathEstrella.quadTo(clickX, clickY, (x + clickX) / 2, (y + clickY) / 2);
            clickX = x;
            clickY = y;
            dibujarEstrella(clickX, clickY);
            drawCanvas.drawPath(pathEstrella, pincelEstrella);
        }
        pincelEstrella.setColor(getResources().getColor(R.color.black));
    }

    private void dibujarEstrella(float x, float y) {
        double angulo = 0;
        pathEstrella.moveTo(x, y);
        for (int i = 0; i < 6; i++) {
            angulo += Math.PI / 5 * 2;
            float x1 = (float) (x + Math.cos(angulo) * 20);
            float y1 = (float) (y + Math.sin(angulo) * 20);
            float x2 = (float) (x + Math.cos(angulo + Math.PI / 10) * 40);
            float y2 = (float) (y + Math.sin(angulo + Math.PI / 10) * 40);
            pathEstrella.lineTo(x1, y1);
            pathEstrella.lineTo(x2, y2);
        }
        pathEstrella.close();
    }

    public void setEsRojo () {
        esRojo = true;
        esAzul = false;
        esAmarillo = false;
    }

    public void setEsAzul () {
        esAzul = true;
        esAmarillo = false;
        esRojo = false;
    }

    public void setEsAmarillo () {
        esAmarillo = true;
        esAzul = false;
        esRojo = false;
    }

    public void activarBitmap () {
        bitmapMain = true;
    }

    public void borrarCanvas() {
        borrarCanvas = true;
        bitmapMain = false;
        dibujarCirculo = false;
        dibujarImagen = false;
        dibujarEstrella = false;
    }

    public void pintarCirculo () {
        dibujarCirculo = true;
        borrarCanvas = false;
        dibujarImagen = false;
        dibujarEstrella = false;
        bitmapMain = false;
    }

    public void pintarImagen () {
        dibujarImagen = true;
        dibujarCirculo = false;
        dibujarEstrella = false;
        borrarCanvas = false;
    }

    public void pintarEstrella () {
        dibujarEstrella = true;
        borrarCanvas = false;
        dibujarImagen = false;
        dibujarCirculo = false;
    }
}
