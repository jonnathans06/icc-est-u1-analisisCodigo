 import java.util.Random;

public class Benchmarking {
    
private MetodosOrdenamiento metodosOrdenamiento; //variable global

    //Constructor
    public Benchmarking() {
    // long inicioMillis = System.currentTimeMillis(); //nos puede dar la fecha en milisegundos //CurrentTime
    // long inicioNano = System.nanoTime(); //nos da el tiempo desde que ejecuto la maquina

    // System.out.println(inicioMillis);
    // System.out.println(inicioNano);

        metodosOrdenamiento = new MetodosOrdenamiento(); // instanciamos la variable
        int[] arreglo = generarArregloAleatorio(1000000);
 ///       Runnable tarea = () ->

    //    double tiempoNano = medirConNanoTime(tarea);
      //  double tiempoMillis = medirConCurrentTime(tarea);
      long inicio = System.nanoTime();
        metodosOrdenamiento.burbujaTradicional(arreglo);
        long fin = System.nanoTime();
        double tiempoNano = (fin - inicio) / 1_000_000_000.0;
        System.out.println("Tiempo con nanoTime: " + tiempoNano + " segundos");
        //System.out.println("Tiempo con currentTime " + tiempoMillis + " segundos");
    }

    private int[] generarArregloAleatorio(int i) {
        int[] arreglo = new int[i];
        Random random = new Random();
        for(int j = 0; j < i; j++) {
            arreglo[j] = random.nextInt(100000); // genera un numero aleatorio entre 0 y 10000
        }
        return arreglo;
    }

    // Tiempo usuario nanoTime (en segundos)
    public double medirConNanoTime(Runnable tarea) {
        long inicio = System.nanoTime();
        tarea.run();
        long fin = System.nanoTime();
        return (fin - inicio) / 1000000000.0; //en segundos
    }

    // Tiempo usuario currentTimeMillis (en segundos)
    public double medirConCurrentTime(Runnable tarea) {
        long inicio = System.currentTimeMillis();
        tarea.run();
        long fin = System.currentTimeMillis();
        return (fin - inicio) / 1000.0; //en segundos
    }

}
