/*
 * Declaración de IA: Asistencia de IA utilizada para la implementación de
 * herencia y polimorfismo en la clase Aula.
 */

public class Aula extends Espacio {
    private String docenteResponsable;

    public Aula(String codigo, String nombre, int capacidad, String docenteResponsable) {
        super(codigo, nombre, capacidad);
        if (docenteResponsable == null || docenteResponsable.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Se requiere el nombre del docente responsable.");
        }
        this.docenteResponsable = docenteResponsable;
    }

    @Override
    public int costoReserva(int horas) {
        if (horas <= 0) {
            System.out.println("[ERROR] La cantidad de horas debe ser mayor a 0.");
            return -1;
        }
        if (horas > 4) {
            System.out.println("[RECHAZADO] Supera el máximo de 4 horas continuas para un Aula (" + codigo + ").");
            return -1;
        }
        return 0; // Sin costo (Uso académico)
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " | Tipo: Aula | Docente Responsable: " + docenteResponsable;
    }

    public String getDocenteResponsable() {
        return docenteResponsable;
    }
}
