package com.sopes2;

import java.util.List;

/**
 * Clase abstracta que define la estructura general
 * de un algoritmo de planificación de CPU.
 *
 * @author Monserrat Gomez
 * @version 1.0
 */
public abstract class Planificador {

    /**
     * Ejecuta el algoritmo de planificación.
     *
     * @param procesos lista de procesos a ejecutar
     * @return lista de resultados
     */
    public abstract List<Resultado> ejecutar(List<Proceso> procesos);

    /**
     * Calcula el tiempo de espera promedio.
     *
     * @param resultados resultados de los procesos
     * @return tiempo de espera promedio
     */
    public double calcularPromedioEspera(List<Resultado> resultados) {
        double suma = 0;

        for (Resultado resultado : resultados) {
            suma += resultado.getWaitingTime();
        }

        return suma / resultados.size();
    }

    /**
     * Calcula el tiempo de retorno promedio.
     *
     * @param resultados resultados de los procesos
     * @return tiempo de retorno promedio
     */
    public double calcularPromedioRetorno(List<Resultado> resultados) {

        double suma = 0;

        for (Resultado resultado : resultados) {
            suma += resultado.getTurnaroundTime();
        }

        return suma / resultados.size();
    }
}