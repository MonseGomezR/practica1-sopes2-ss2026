package com.sopes2;

import lombok.Getter;

/**
 * Almacena los resultados obtenidos después de
 * ejecutar un proceso mediante un algoritmo
 * de planificación.
 *
 * @author Monserrat Gomez
 * @version 1.0
 */
@Getter
public class Resultado {
    private Proceso proceso;

    private int inicio;
    private int completionTime;
    private int turnaroundTime;
    private int waitingTime;
    private int responseTime;

    /**
     * Constructor del resultado.
     *
     * @param proceso        proceso al que pertenecen las métricas
     * @param inicio         instante en que comienza su ejecución
     * @param completionTime instante en que termina
     */
    public Resultado(Proceso proceso, int inicio, int completionTime) {
        this.proceso = proceso;
        this.inicio = inicio;
        this.completionTime = completionTime;

        this.turnaroundTime = completionTime - proceso.getTiempoLlegada();
        this.waitingTime = turnaroundTime - proceso.getRafaga();
        this.responseTime = inicio - proceso.getTiempoLlegada();
    }
}
