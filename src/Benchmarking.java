 import java.util.Random;

public class Benchmarking {
    
private MetodosOrdenamiento metodosOrdenamiento; //variable global

    //Constructor
    public Benchmarking(){
        long iniciooMillis = System.currentTimeMillis(); //nos puede dar la fecha en milisegundos //CurrentTime
        long inicioNano = System.nanoTime(); //nos da el tiempo desde que ejecuto la maquina

        System.out.println(iniciooMillis);
        System.out.println(inicioNano);

        metodosOrdenamiento = new MetodosOrdenamiento();
        int[] arreglo = generarArregloAleatoreo(1000000);
        Runnable tarea = () -> metodosOrdenamiento.burbujaTradicional(arreglo);

        double tiempoNano = medirConNanoTime(tarea);
        System.out.println("Medir con nano --> "+tiempoNano);
        double tiempoMillis = medirConCurrentTime(tarea);
        System.out.println("Medir con milli --> "+tiempoMillis);

    }

    private int[] generarArregloAleatoreo(int tamano){
        int [] arreglo = new int[tamano];
        Random random = new Random();
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = random.nextInt(100_000);
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
