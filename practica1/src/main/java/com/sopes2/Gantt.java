package com.sopes2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Genera una representación en consola
 * del diagrama de Gantt.
 *
 * @author Monserrat Gomez
 * @version 1.0
 */
public class Gantt {

    /**
     * Muestra el diagrama de Gantt.
     *
     * @param resultados resultados obtenidos del algoritmo
     */
    public static void mostrar(List<Resultado> resultados) {

        if (resultados == null || resultados.isEmpty()) {
            System.out.println("\nNo hay resultados para mostrar.");
            return;
        }

        /*
         * Crear una copia para ordenar los resultados
         * sin modificar la lista original.
         */
        List<Resultado> ordenados = new ArrayList<>(resultados);

        ordenados.sort(Comparator.comparingInt(Resultado::getInicio));

        System.out.println("\nDIAGRAMA DE GANTT");
        System.out.println("==============================================");

        /*
         * Mostrar los nombres de los procesos.
         */
        System.out.print("|");

        int tiempoActual = 0;

        for (Resultado resultado : ordenados) {

            /*
             * Si hay un espacio entre dos procesos,
             * significa que el CPU estuvo desocupado.
             */
            if (tiempoActual < resultado.getInicio()) {
                System.out.print(" IDLE |");
                tiempoActual = resultado.getInicio();
            }

            System.out.printf(" %-6s |", resultado.getProceso().getNombre());

            tiempoActual = resultado.getCompletionTime();
        }

        System.out.println();

        /*
         * Mostrar los tiempos correspondientes
         * a cada separación del diagrama.
         */
        tiempoActual = 0;

        System.out.print("0");

        for (Resultado resultado : ordenados) {

            /*
             * Mostrar el momento en que termina
             * el período IDLE.
             */
            if (tiempoActual < resultado.getInicio()) {
                System.out.printf("%8d", resultado.getInicio());
                tiempoActual = resultado.getInicio();
            }

            System.out.printf("%9d", resultado.getCompletionTime());

            tiempoActual = resultado.getCompletionTime();
        }

        System.out.println();
    }
}