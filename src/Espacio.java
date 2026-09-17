/*
 * Declaración de IA: Asistencia de IA utilizada para la estructuración
 * de la clase base Espacio y validaciones de encapsulamiento.
 */

public class Espacio {
    // Atributos protegidos para permitir el acceso directo en clases hijas
    protected String codigo;
    protected String nombre;
    protected int capacidad;
    protected boolean reservado;

    // Constructor con validación de reglas de negocio
    public Espacio(String codigo, String nombre, int capacidad) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El código no puede estar vacío ni ser nulo.");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Error: La capacidad debe ser mayor que cero.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.reservado = false; // Por defecto, el espacio inicia disponible
    }

    // Método para reservar con validación
    public void reservar() {
        if (this.reservado) {
            System.out.println("[RECHAZADO] El espacio " + codigo + " (" + nombre + ") ya se encuentra reservado.");
        } else {
            this.reservado = true;
            System.out.println("[ÉXITO] El espacio " + codigo + " (" + nombre + ") ha sido reservado correctamente.");
        }
    }

    // Método para liberar con validación
    public void liberar() {
        if (!this.reservado) {
            System.out.println("[RECHAZADO] El espacio " + codigo + " (" + nombre + ") no está reservado, no se puede liberar.");
        } else {
            this.reservado = false;
            System.out.println("[ÉXITO] El espacio " + codigo + " (" + nombre + ") ha sido liberado correctamente.");
        }
    }

    // Método base para costo de reserva (será sobrescrito en las clases hijas)
    public int costoReserva(int horas) {
        return 0;
    }

    // Descripción genérica del espacio
    public String descripcion() {
        String estado = reservado ? "Reservado" : "Disponible";
        return "Código: " + codigo + " | Nombre: " + nombre + " | Capacidad: " + capacidad + " personas | Estado: " + estado;
    }

    // Getters necesarios (Sin setters directos para reservado o capacidad que violen reglas)
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isReservado() {
        return reservado;
    }
}