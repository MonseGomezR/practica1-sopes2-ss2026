package com.sopes2;

import lombok.Getter;

/**
 * Representa un proceso que será utilizado por el simulador
 * de algoritmos de planificación de CPU.
 *
 * @author Monserrat Gomez
 * @version 1.0
 */
@Getter
public class Proceso {

    private String nombre;
    private int tiempoLlegada;
    private int rafaga;

    /**
     * Constructor de la clase Proceso.
     *
     * @param nombre nombre identificador del proceso
     * @param tiempoLlegada tiempo en el que llega el proceso
     * @param rafaga tiempo requerido de CPU
     */
    public Proceso(String nombre, int tiempoLlegada, int rafaga) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.rafaga = rafaga;
    }

    @Override
    public String toString() {
        return nombre +
                " [AT=" + tiempoLlegada +
                ", BT=" + rafaga + "]";
    }
}