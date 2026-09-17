/*
 * Declaración de IA: Asistencia de IA utilizada para la estructuración
 * de la clase opcional Reserva y la justificación del acoplamiento unidireccional.
 */

public class Reserva {
    private Espacio espacio;
    private String solicitante;
    private String fecha;
    private int horas;

    /*
     * JUSTIFICACIÓN DE LA DIRECCIÓN DE LA RELACIÓN:
     * La clase Espacio NO conoce a la clase Reserva. Esta dirección es la correcta
     * porque mantiene un bajo acoplamiento (Principio de Responsabilidad Única).
     * Un espacio físico del campus existe por sí solo, sin importar si tiene o no reservas
     * registradas en una fecha concreta. La clase Reserva es la que gestiona el contexto
     * administrativo asociando un Espacio con un solicitante y un intervalo de tiempo.
     */

    public Reserva(Espacio espacio, String solicitante, String fecha, int horas) {
        if (espacio == null) {
            throw new IllegalArgumentException("Error: El espacio no puede ser nulo.");
        }
        if (solicitante == null || solicitante.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El solicitante no puede estar vacío.");
        }
        if (horas <= 0) {
            throw new IllegalArgumentException("Error: Las horas deben ser mayores a cero.");
        }
        this.espacio = espacio;
        this.solicitante = solicitante;
        this.fecha = fecha;
        this.horas = horas;
    }

    public int calcularCostoTotal() {
        // Uso de polimorfismo para calcular el costo sin importar el sub-tipo de Espacio
        return espacio.costoReserva(horas);
    }

    public void procesarReserva() {
        if (espacio.isReservado()) {
            System.out.println("No se puede procesar la reserva para " + solicitante + ": El espacio se encuentra ocupado.");
            return;
        }

        int costoTotal = calcularCostoTotal();
        if (costoTotal != -1) {
            espacio.reservar();
            System.out.println("Reserva registrada con éxito a nombre de: " + solicitante);
            System.out.println("Fecha: " + fecha + " | Horas: " + horas + " | Costo Total: $" + costoTotal);
        } else {
            System.out.println("No se completó la reserva debido a una infracción de horas máximas.");
        }
    }

    // Getters
    public Espacio getEspacio() { return espacio; }
    public String getSolicitante() { return solicitante; }
    public String getFecha() { return fecha; }
    public int getHoras() { return horas; }
}
