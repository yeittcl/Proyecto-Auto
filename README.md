# Proyecto
### Integrantes 
+ **Raul Zapata Villalobos - 2019900803 _(yeittcl)_**

+ **Matias Lopez Jara - 2021770259 _(1Shiro)_**

## Tema 5: Vehículo dirigido por teclado y moverse por pista sensible con bordes que detectan y cuentan colisiones

El panel principal debe contener una ruta cerrada, con curvas y soleras creadas (representadas por Polygon). Las ruedas delanteras deben ser visibles y deben reflejar la dirección si dobla. El usuario deberá controlar la dirección de las ruedas con las flechas del teclado. El móvil debe moverse siguiendo la dirección de las ruedas delanteras de manera similar a uno real. Las ruedas no tienen que girar sólo mostrar en la vista aérea su dirección. El control de velocidad se debe realizar mediante controles GUI. La ruta debe ser configurable por controles GUI: ancho y alto de la pista y ancho de la calzada. Debe tener dos modos: configuración y conducción. 

## UML

### UML & graphics UML
![Graphics_UML](https://user-images.githubusercontent.com/103296338/206950215-1171d262-128f-413f-af75-d74eda9bd43b.png)

### Use Case UML
![Use_Case](https://user-images.githubusercontent.com/103296338/202869041-1bbe1cca-5467-4dfe-a287-e2f56267e9c7.png)

## Interfaz

## Modo juego
![ScreenShot_20221211234821](https://user-images.githubusercontent.com/103296338/206950482-9148074d-7957-4303-b693-4fc3a43c7d87.png)

## Modo Configuracion
![ScreenShot_20221211234827](https://user-images.githubusercontent.com/103296338/206950505-cf7f1f1a-e2ef-4503-b8ce-c5c55eb520b9.png)

## Patrones Utilizados

El patron que utilizamos fue el patron Holder, ya que al tener dos paneles distintos y no teniamos ninguna conexion entre ellos para hacer cambios, decidimos utilizar un holder para conectar la pista que estaba en el panel central con los cambion realizados en el panel de configuracion, en especifico en el slider para el cambio de radio.
en conclusion, haciamos los cambios en el slider, los estableciamos en el holder y a su vez actualizabamos la pista haciendo un get del radio guardado por el holder

## Decisiones

En si nos apegamos al enunciado del problema, para la ventana y los paneles fue lo aprendido en las tareas anteriores, para la creacion del auto, la decision fue crearlo como una extension de la clase Polygon, asi podiamos almacenar los datos y usarlo para pintar directamente en vez de tener que hacer override de sus propiedades Paint, por lo que fue mas sencillo su actualizacion y pintado, ademas que un rectangulo normal creado con graphics no permitia que se rotara en angulos distintos a 0 o 90 grados, por lo que se debia hacer 4 puntos y que se movieran cada uno al mismo tiempo, y para rotar simplemente se ocupaba la rotacion en 2D de un punto. segundo fue crear el gameloop; investigando por internet los sitios siempre explicaban que el gameloop mas facil era hacer repaint en el metodo Paint del panel y asi se creaba un loop infinito, pero investigando mas profundo se explicaba que ese gameloop traia consigo perdidas de FPS e incosistencia en el pintado y parte logica, por lo que se decidio crear un gameloop separado de todos los procesos para que no afectara en su funcionamiento y mejorara la fluidez y encapsulamiento, el loop fue creado con un Thread, como todos sus funcionamiento de capeo de FPS y contado de FPS, por lo que no tendiramos inconsistencias.


La pista por su parte no fue una clase extendida de polygon, que por recomendacion del ayudante este seria simplemente una pista circular, por lo que hacer un polygon no seria muy estetico ya que se veria muy pixeleado, entonces se creo dentro de la clase pista, un objeto de clase Ellipse2D, que crea un circulo con un punto en el plano y un ancho y un alto; si lo generalizamos a un circulo, solo se necesito un radio y un punto, por lo que todo eso lo guardabamos en las variables de la pista y en el cosntructor creabamos la elipse y para pintarlo simplemente le pasabamos el circulo con un gent y listo, las actualizaciones del circulo igual se hacian de esa manera mediante un circulo auxiliar que se instanciaba con las nuevas variables y se le pasaba ese puntero al circulo que contenia la clase.


Para las colisiones, el ayudante nos propuso simplemente hacerlo mediante el centro del auto, ya que es muy costoso calcular en cada punto las colisiones, si calculamos la colision con el centro del auto y manteniendo un error en el proceso, apenas se detectarian visualmente. Las colisiones se calculan mediante el radio de los circulo y la distancia del centro. por ejemplo, con el radio del circulo menor, si la distancia del centro del auto al centro del ciruclo es mayor al radio de este, entonces esta fuera del circulo, por consiguiente dentro de la pista. Si el auto se mantiene dentro de la pista mantiene un color azul y su velocidad es mayor, si se sale de la pista, osea colisiona con los bordes, se cambia su color a rojo y su velocidad disminuye considerablemente.


Para mover el auto se creo una clase que manejara los inputs del teclado mediante una interfaz que las escuchara, si se presionan las teclas a,w,s,d el auto se mueve, si se dejan de presionar, este para, por lo que un booleando en cada tecla los maneja.
Por ultimo Los paneles de configuracion, para cambiar entre modo juego y modo configuracion, se creo un JTabbedPane, que genera pestañas en la parte superior de la ventana, asi se puedn ir intercambiando, en la pantalla de configuraciones tenemos 2 sliders, que cada uno maneja el radio de cada circulo, el pequeño interior y el mayor exterior, cada slider esta en un panel separado solo por decision estetica.
Las ruedas son un clase que extiende Polygon, al igual que auto y hace que pueda rotarse y seguir los puntos del auto, asi se ve que doblan junto a el.

## Problemas y Autocritica
El primer problema grande que encontramos fue como rotar el auto y que este se moviera en esa direccion, pero gracias a la ayuda del ayudante, el nos explico como funcionaba la rotacion en 2D y cual era la generalizacion en los videojuegos, ya que una rotacion en 2D se hace en el punto de origen, pero con algunos calculos se podia hacer en cualquier parte de la pantalla teniendo como punto base, el centro de cada polygon.

2do problema, fue como hacer que tengamos dos paneles al mismo tiempo y hacer switch con algun boton o algo para intercambiar entre ellos, se investigo por internet y se encoontro un objeto en swing que permitia esto, llamado JTabbedPane, este permitia almecenar objetos swing tales como paneles y hacer que se vieran como pestañas en la ventana.


y el ultimo problema que no se pudo solucionar del todo, fue la rotacion de las ruedas del auto, qunque estas siguen y doblan junto al auto, estas no se ven como unas ruedas de verdad, que trato de decir, que las ruedas no cambiar de rotacion antes de auto, si nosotros doblamos el volante del auto estando estacionados, estos se mueven de izquierda a derecha, pero nuestras ruedas no pueden hacer eso, simplemente estan a la direccion del auto y rotan junto a el como una sola pieza.


En si creemos que cumplimos con el trabajo pero se pudo hacer cosas mejores, en el plano estetico, podiamos poner imagenes a los paneles para que se viera mas lindo, o mejorar la interfaz de configuraciones, crear mas configuracion como intentar cambiar el color del auto o de las pistas. y por el lado jugable, podriamos hacer mas pistas o generar una mas grande con mas dificultad para que fuera mas entretenido, ademas que no supimos como implementar Test a nuestro proyecto por lo que ese apartado quedo vacio.

