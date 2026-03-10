public class Main {
    public static void main(String[] args) {
        Analizador miAnalizador = new Analizador();
        int[] tamanos = {100, 1000, 10000};

        System.out.println("ALGORITMO | N | TIEMPO (ms) | COMP. TEORICAS");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < tamanos.length; i++) {
            int n = tamanos[i];
            
            
            long comparaciones = (long) n * (n - 1) / 2;

            // --- PRUEBA BURBUJA ---
            int[] datosB = miAnalizador.generarAleatorios(n);
            long inicioB = System.currentTimeMillis();
            miAnalizador.burbuja(datosB);
            long finB = System.currentTimeMillis();
            System.out.println("Burbuja   | " + n + " | " + (finB - inicioB) + " ms | " + comparaciones);

            // --- PRUEBA SELECCIÓN ---
            int[] datosS = miAnalizador.generarAleatorios(n);
            long inicioS = System.currentTimeMillis();
            miAnalizador.seleccion(datosS);
            long finS = System.currentTimeMillis();
            System.out.println("Seleccion | " + n + " | " + (finS - inicioS) + " ms | " + comparaciones);
            
            System.out.println("----------------------------------------------");
        }
    }
}