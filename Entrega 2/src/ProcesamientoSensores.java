import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class LecturaSensor {
    private String id;
    private double valor;
    private String tipo;
    private LocalDateTime timestamp;

    public LecturaSensor(String id, double valor, String tipo, LocalDateTime timestamp) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public double getValor() { return valor; }
    public String getTipo() { return tipo; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

public class ProcesamientoSensores {
    public static void main(String[] args) {
        
        List<LecturaSensor> lecturas = Arrays.asList(
            new LecturaSensor("S1", 25.5, "Temperatura", LocalDateTime.now().minusHours(2)),
            new LecturaSensor("S2", 30.0, "Temperatura", LocalDateTime.now().minusHours(5)),
            new LecturaSensor("S3", 10.0, "Presion",    LocalDateTime.now().minusHours(10)),
            new LecturaSensor("S4", 45.0, "Temperatura", LocalDateTime.now().minusHours(30)),
            new LecturaSensor("S5", 22.0, "Temperatura", LocalDateTime.now().minusMinutes(30))
        );

        String tipoBusqueda = "Temperatura";

        double promedio24h = lecturas.stream()
            .filter(s -> s.getTipo().equalsIgnoreCase(tipoBusqueda)) // Usamos getTipo()
            .filter(s -> s.getTimestamp().isAfter(LocalDateTime.now().minusHours(24)))
            .mapToDouble(LecturaSensor::getValor) // Usamos referencia al método getter
            .average()
            .orElse(0.0);

        Optional<LecturaSensor> lecturaMaxima = lecturas.stream()
            .max(Comparator.comparingDouble(LecturaSensor::getValor));

        System.out.println("Promedio '" + tipoBusqueda + "' (24h): " + promedio24h);
        
        lecturaMaxima.ifPresent(l -> 
            System.out.println("Máximo: ID=" + l.getId() + " | Valor=" + l.getValor())
        );
    }
}