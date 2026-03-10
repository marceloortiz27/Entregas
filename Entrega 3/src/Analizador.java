import java.util.Random;

public class Analizador {

    // Método Burbuja
    public void burbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }

    // Método Selección
    public void seleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int aux = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = aux;
        }
    }

    // Crea un arreglo con números al azar
    public int[] generarAleatorios(int n) {
        Random rnd = new Random();
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = rnd.nextInt(10000);
        }
        return arreglo;
    }
}