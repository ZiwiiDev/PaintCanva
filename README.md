# PaintCanva
Aplicación móvil muy simple para Android Nativa con Java que desarrolla un Paint para dibujar con Canva.

Vamos a crear una aplicación de Dibujo donde podrás utilizar diferentes pinceles y colores. 
Para desarrollar esta tarea necesitarás crear dos pantallas diferentes. Una pantalla inicial y una pantalla para dibujar.

Al ejecutar la aplicación se abrirá la pantalla inicial donde se muestre el nombre de la aplicación "Dibujando", 
una imagen representativa a modo de icono (a elegir por el alumno/a, descargado de Internet o de diseño propio) y un botón "Comenzar a dibujar".
Además, esta pantalla tendrá una imagen de fondo (a elegir por el alumno/a) y se escuchará una melodía que estará en formato mp3 (TODO HECHO EN CANVAS, MENOS EL
BOTÓN).

![image](https://user-images.githubusercontent.com/100787553/234538513-c6594467-fc9e-433a-a07f-e677024638fc.png)

En el código de la pantalla principal no hay mucho que explicar, sólo muestro el canvas en una parte de la pantalla y no en
la pantalla completa. Luego inicializo un objeto audio para colocarle el audio de fondo y con el
botón vamos al siguiente activity.

![image](https://user-images.githubusercontent.com/100787553/234538234-59eb8925-d453-4c69-9fcd-a62b38f60e8b.png)

Y le agrego los método onStart, onDestroy y onStop

![image](https://user-images.githubusercontent.com/100787553/234538641-e1141e38-631a-41ad-9855-4546249fbb71.png)

Para los audios creo una carpeta “row” y meto los mp3.

![image](https://user-images.githubusercontent.com/100787553/234538694-2f003155-8d60-40f5-923f-bd9a869a304a.png)

Cuando el usuario pulsa sobre el botón "Comenzar a dibujar" se abre la pantalla principal con un lienzo en blanco 
y en la parte inferior un panel de herramientas donde podrás elegir:
  • Pintar con un pincel en forma de círculo en tres colores diferentes.
  • Pintar con un pincel en forma de estrella (obtenida a partir de segmentos de líneas).
  
Además, existirá un botón inferior para volver a la pantalla inicial, que mostrará el texto “Inicio".
La pantalla es la siguiente (incluye audio de fondo):

![image](https://user-images.githubusercontent.com/100787553/234538862-c8864dbf-f000-4035-b2c8-e11ba7dd66c5.png)

Si pulsamos sobre el ImageButton del círculo y sobre un color de los de abajo suya (rojo, azul o amarillo) 
pintamos con círculos pequeños del color seleccionado. Si pulsamos en el lienzo empezaremos a dibujar sobre él. 
Si no se pulsa la imagen del círculo no se dibujarán los círculos. Esto lo he hecho porque si por ejemplo 
dibujas con la estrella y eliges color para no poder usar los colores en la estrella, solo en los círculos.

![image](https://user-images.githubusercontent.com/100787553/234538980-8bc8f78e-e74b-47a9-a7a3-8f362af2d9b0.png)

Si pulsamos sobre el botón de borrar se borra todo lo que hay dibujado en el lienzo.
Hay que pulsar el botón y sobre el lienzo.

Si pulsamos sobre la estrella y probamos a dibujar sobre el lienzo en blanco empezaremos a dibujar con una estrella negra.

![image](https://user-images.githubusercontent.com/100787553/234539096-7380aac9-f108-4666-abc2-f70342728d2d.png)

Si pulsamos sobre el botón de borrar se borra todo lo que hay dibujado en el lienzo. 
Hay que pulsar el botón y sobre el lienzo.

Si pulsamos sobre la imagen en miniatura y probamos a dibujar sobre el lienzo en blanco empezaremos a dibujar con ella.

![image](https://user-images.githubusercontent.com/100787553/234539198-aa89d6d3-acd3-486d-a055-8ed59294d007.png)

Si pulsamos sobre el botón de borrar se borra todo lo que hay dibujado en el lienzo. 
Hay que pulsar el botón y sobre el lienzo.

También podemos combinar todos a la vez.

![image](https://user-images.githubusercontent.com/100787553/234539340-9240c558-782a-4960-bdf9-e401b16ddf4d.png)

Si pulsamos sobre el botón de “inicio” volveremos a la pantalla anterior y se para el audio.
Comienza a sonar el audio de la pantalla inicial.

Ahora vamos a realizar lo siguiente:
  • Incluir una melodía de fondo en la Pantalla de Dibujo.
  • Añadir la posibilidad de pintar con un pincel que será una imagen en miniatura.
  • Añadir un botón que permita borrar el dibujo contenido en el lienzo, que mostrará el texto “Borrar".
  
Ya lo he mencionado anteriormente, pero le he agregado audio de fondo a la pantalla de dibujo, así como a la pantalla inicial. 
También mencionado anteriormente podremos dibujar con un pincel que será una imagen en miniatura 
que viene con los recursos de la actividad. Y también mencionado anteriormente, 
un botón que borra todo lo que hay dibujado en el lienzo. 
He creado una clase para el audio, con los 2 audios distintos utilizados en la tarea.

![image](https://user-images.githubusercontent.com/100787553/234539606-ae48149e-124a-49a8-b4e0-4ca5d2d96fd7.png)

¡¡¡ GRACIAS, UN SALUDO !!!