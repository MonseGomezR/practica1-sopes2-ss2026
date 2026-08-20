package com.sopes2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del simulador de planificación.
 *
 * Permite al usuario ingresar procesos,
 * seleccionar un algoritmo y visualizar
 * los resultados.
 */
public class MainApp {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método principal del programa.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SIMULADOR DE PLANIFICACION DE CPU");
        System.out.println("==========================================");

        int cantidad = leerEnteroPositivo("Ingrese el numero de procesos: ");
        List<Proceso> procesos = new ArrayList<>();

        // Ingreso de procesos.
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Proceso " + (i + 1) + " ---");
            String nombre = leerNombre("Nombre del proceso: ");
            int at = leerEnteroNoNegativo("Tiempo de llegada (AT): ");
            int bt = leerEnteroPositivo("Rafaga de CPU (BT): ");
            procesos.add(new Proceso(nombre, at, bt));
        }

        // Selección del algoritmo.
        int opcion = leerAlgoritmo();
        Planificador planificador;

        if (opcion == 1) {
            planificador = new FCFS();
        } else {
            planificador = new SJF();
        }

        // Ejecutar algoritmo.
        List<Resultado> resultados = planificador.ejecutar(procesos);

        mostrarResultados(resultados, planificador);
        Gantt.mostrar(resultados);
        scanner.close();
    }

    /**
     * Muestra las métricas de todos los procesos.
     */
    private static void mostrarResultados(List<Resultado> resultados, Planificador planificador) {
        System.out.println("\nRESULTADOS");
        System.out.println("============================================================");
        System.out.printf("%-8s %-5s %-5s %-7s %-5s %-6s %-5s %-5s%n", "Proceso", "AT", "BT", "Inicio", "CT", "TAT", "WT", "RT");
        System.out.println("------------------------------------------------------------");

        for (Resultado resultado : resultados) {

            Proceso p = resultado.getProceso();
            System.out.printf("%-8s %-5d %-5d %-7d %-5d %-6d %-5d %-5d%n",
                    p.getNombre(),
                    p.getTiempoLlegada(),
                    p.getRafaga(),
                    resultado.getInicio(),
                    resultado.getCompletionTime(),
                    resultado.getTurnaroundTime(),
                    resultado.getWaitingTime(),
                    resultado.getResponseTime());
        }

        double promedioWT = planificador.calcularPromedioEspera(resultados);
        double promedioTAT = planificador.calcularPromedioRetorno(resultados);

        System.out.printf("\nTiempo de espera promedio (WT): %.2f%n",promedioWT);
        System.out.printf("Tiempo de retorno promedio (TAT): %.2f%n",promedioTAT);
    }

    /**
     * Solicita al usuario que seleccione
     * un algoritmo válido.
     */
    private static int leerAlgoritmo() {
        while (true) {
            System.out.println("\nSeleccione el algoritmo:");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.print("Opcion: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion == 1 || opcion == 2) {
                    return opcion;
                }
                System.out.println("Error: seleccione 1 o 2.");
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero.");
            }
        }
    }

    /**
     * Lee un número entero positivo.
     */
    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero > 0) {
                    return numero;
                }
                System.out.println("Error: debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero entero valido.");
            }
        }
    }

    /**
     * Lee un número entero mayor o igual a cero.
     */
    private static int leerEnteroNoNegativo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero >= 0) {
                    return numero;
                }
                System.out.println("Error: no puede ser negativo.");

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero entero valido.");
            }
        }
    }

    /**
     * Lee un nombre de proceso.
     */
    private static String leerNombre(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty()) {
                return nombre;
            }
            System.out.println("Error: el nombre no puede estar vacio.");
        }
    }
}
