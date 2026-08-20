package com.sopes2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implementación del algoritmo
 * First Come, First Served (FCFS).
 *
 * Los procesos se ejecutan en el mismo orden
 * en que llegan al sistema.
 *
 * @author Monserrat Gomez
 * @version 1.0
 */
public class FCFS extends Planificador {

    /**
     * Ejecuta el algoritmo FCFS.
     *
     * @param procesos lista de procesos
     * @return resultados de la ejecución
     */
    @Override
    public List<Resultado> ejecutar(List<Proceso> procesos) {

        List<Proceso> ordenados = new ArrayList<>(procesos);

        // Ordenar por tiempo de llegada.
        ordenados.sort(Comparator.comparingInt(Proceso::getTiempoLlegada));

        List<Resultado> resultados = new ArrayList<>();
        int tiempo = 0;

        for (Proceso proceso : ordenados) {
            // Si el CPU está desocupado,
            // avanzar hasta que llegue el proceso.
            if (tiempo < proceso.getTiempoLlegada()) {
                tiempo = proceso.getTiempoLlegada();
            }

            int inicio = tiempo;
            tiempo += proceso.getRafaga();
            int completionTime = tiempo;

            resultados.add(new Resultado(proceso, inicio, completionTime));
        }

        return resultados;
    }
}