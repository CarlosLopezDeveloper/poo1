
/*
 * Declaración de IA: Asistencia de IA utilizada para la implementación de
 * herencia y polimorfismo en la clase Laboratorio.
 */

public class Laboratorio extends Espacio {
    private int equiposDisponibles;

    public Laboratorio(String codigo, String nombre, int capacidad, int equiposDisponibles) {
        super(codigo, nombre, capacidad);
        if (equiposDisponibles < 0) {
            throw new IllegalArgumentException("Error: El número de equipos disponibles no puede ser negativo.");
        }
        this.equiposDisponibles = equiposDisponibles;
    }

    @Override
    public int costoReserva(int horas) {
        if (horas <= 0) {
            System.out.println("[ERROR] La cantidad de horas debe ser mayor a 0.");
            return -1;
        }
        if (horas > 3) {
            System.out.println("[RECHAZADO] Supera el máximo de 3 horas continuas para un Laboratorio (" + codigo + ").");
            return -1;
        }
        return horas * 15000; // $15.000 por hora
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " | Tipo: Laboratorio | Equipos Disponibles: " + equiposDisponibles;
    }

    public int getEquiposDisponibles() {
        return equiposDisponibles;
    }
}