/*
 * Declaración de IA: Asistencia de IA para la elaboración del menú de pruebas
 * polimórfico y demostración explícita de captura de excepciones.
 */

public class SistemaReservas {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   SISTEMA DE RESERVA DE ESPACIOS CAMPUS (SIREC) ");
        System.out.println("=================================================\n");

        // 1. Demostración de validación de instanciación con valores inválidos
        System.out.println("--- 1. PRUEBA DE VALIDACIÓN DE VALORES INVÁLIDOS ---");
        try {
            System.out.println("Intentando crear un espacio con capacidad negativa (-5)...");
            Espacio espacioInvalido = new Aula("AUL-ERR", "Aula Error", -5, "Prof. Test");
        } catch (IllegalArgumentException e) {
            System.out.println("CAPTURADO: " + e.getMessage());
        }

        try {
            System.out.println("Intentando crear un espacio con código vacío...");
            Espacio espacioInvalido = new Laboratorio("", "Lab Error", 20, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("CAPTURADO: " + e.getMessage());
        }
        System.out.println();

        // 2. Creación del catálogo polimórfico
        System.out.println("--- 2. CREACIÓN DEL CATÁLOGO DE ESPACIOS ---");
        Espacio[] catalogo = new Espacio[5];
        catalogo[0] = new Aula("AUL-101", "Aula Magna 101", 40, "Prof. Ramírez");
        catalogo[1] = new Laboratorio("LAB-203", "Lab de Redes", 25, 25);
        catalogo[2] = new CanchaDeportiva("CAN-001", "Cancha Sur", 22, false);
        catalogo[3] = new Aula("AUL-102", "Aula Taller", 35, "Dra. Gómez");
        catalogo[4] = new Laboratorio("LAB-101", "Lab de Química", 20, 15);

        // Recorrido polimórfico con ciclo for
        for (Espacio e : catalogo) {
            System.out.println(e.descripcion());
            int costo = e.costoReserva(2);
            if (costo != -1) {
                System.out.println("Costo por 2 horas de reserva: $" + costo);
            }
            System.out.println("--------------------------------------------------------------------------------");
        }
        System.out.println();

        // 3. Demostración de reglas de reserva y liberación
        System.out.println("--- 3. PRUEBA DE REGLAS DE NEGOCIO EN RESERVAS ---");

        // Reservar un espacio por primera vez
        System.out.print("Intento 1 - ");
        catalogo[0].reservar();

        // Intentar reservar de nuevo el mismo espacio
        System.out.print("Intento 2 - ");
        catalogo[0].reservar();

        // Intentar liberar un espacio que NO ha sido reservado
        System.out.print("Intento 3 - ");
        catalogo[1].liberar();

        // Liberar un espacio que SÍ estaba reservado
        System.out.print("Intento 4 - ");
        catalogo[0].liberar();

        System.out.println();

        // 4. Demostración de horas máximas por tipo de espacio
        System.out.println("--- 4. PRUEBA DE EXCESO DE HORAS CONTINUAS ---");
        System.out.println("Solicitando 5 horas para Aula Magna (Máx 4h):");
        int costoAula = catalogo[0].costoReserva(5);

        System.out.println("Solicitando 4 horas para Lab de Redes (Máx 3h):");
        int costoLab = catalogo[1].costoReserva(4);

        System.out.println("Solicitando 3 horas para Cancha Sur (Máx 2h):");
        int costoCancha = catalogo[2].costoReserva(3);
    }
}