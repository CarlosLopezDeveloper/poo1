/*
 * Declaración de IA: Asistencia de IA utilizada para la implementación de
 * herencia y polimorfismo en la clase CanchaDeportiva.
 */

public class CanchaDeportiva extends Espacio {
    private boolean esTechada;

    public CanchaDeportiva(String codigo, String nombre, int capacidad, boolean esTechada) {
        super(codigo, nombre, capacidad);
        this.esTechada = esTechada;
    }

    @Override
    public int costoReserva(int horas) {
        if (horas <= 0) {
            System.out.println("[ERROR] La cantidad de horas debe ser mayor a 0.");
            return -1;
        }
        if (horas > 2) {
            System.out.println("[RECHAZADO] Supera el máximo de 2 horas continuas para una Cancha Deportivo (" + codigo + ").");
            return -1;
        }
        return horas * 30000; // $30.000 por hora
    }

    @Override
    public String descripcion() {
        String tipoTecho = esTechada ? "Techada" : "Al aire libre";
        return super.descripcion() + " | Tipo: Cancha Deportiva | Cobertura: " + tipoTecho;
    }

    public boolean isEsTechada() {
        return esTechada;
    }
}