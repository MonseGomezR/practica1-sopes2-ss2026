package com.sopes2;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del algoritmo
 * Shortest Job First (SJF) no expropiativo.
 *
 * En cada momento se selecciona el proceso disponible
 * que tenga la menor ráfaga de CPU.
 *
 * @author Monserrat Gomez
 * @version 1.0
 */
public class SJF extends Planificador {

    /**
     * Ejecuta el algoritmo SJF no expropiativo.
     *
     * @param procesos lista de procesos
     * @return resultados de la ejecución
     */
    @Override
    public List<Resultado> ejecutar(List<Proceso> procesos) {
        List<Proceso> pendientes = new ArrayList<>(procesos);
        List<Resultado> resultados = new ArrayList<>();
        int tiempo = 0;

        while (!pendientes.isEmpty()) {
            Proceso seleccionado = null;

            // Buscar el proceso disponible
            // con menor ráfaga.
            for (Proceso proceso : pendientes) {
                if (proceso.getTiempoLlegada() <= tiempo) {
                    if (seleccionado == null || proceso.getRafaga() < seleccionado.getRafaga()) {
                        seleccionado = proceso;
                    }
                }
            }

            /*
             * Si no hay procesos disponibles,
             * avanzar hasta el siguiente tiempo de llegada.
             */
            if (seleccionado == null) {
                int siguienteLlegada = Integer.MAX_VALUE;

                for (Proceso proceso : pendientes) {
                    if (proceso.getTiempoLlegada() < siguienteLlegada) {
                        siguienteLlegada = proceso.getTiempoLlegada();
                    }
                }

                tiempo = siguienteLlegada;
                continue;
            }

            int inicio = tiempo;
            tiempo += seleccionado.getRafaga();
            int completionTime = tiempo;
            resultados.add(new Resultado(seleccionado, inicio, completionTime));
            pendientes.remove(seleccionado);
        }

        return resultados;
    }
}