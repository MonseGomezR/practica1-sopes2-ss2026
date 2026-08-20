# Simulador de Planificación de CPU

Práctica de Sistemas Operativos 2.
Maria Monserrat Gomez Rabatu - 202030849

## Aviso
El PDF de la practica esta incluido en este repo debido a error de carga en multiples ocaciones por parte de la pagina Moodle
<img width="397" height="157" alt="imagen" src="https://github.com/user-attachments/assets/61605e2c-bb84-4225-afd8-e042a07fbfea" />


## Descripción

Este proyecto implementa un simulador de algoritmos de planificación
de procesos utilizando Java.

El programa permite ingresar una lista de procesos indicando:

- Nombre del proceso
- Tiempo de llegada (AT)
- Ráfaga de CPU (BT)

Posteriormente, el usuario puede seleccionar el algoritmo de
planificación que desea utilizar.

## Algoritmos implementados

- FCFS (First Come, First Served)
- SJF (Shortest Job First)

## Métricas calculadas

Para cada proceso se calculan:

- **CT** — Completion Time
- **TAT** — Turnaround Time
- **WT** — Waiting Time
- **RT** — Response Time

También se calculan:

- Tiempo de espera promedio
- Tiempo de retorno promedio

## Diagrama de Gantt

El programa genera una representación del diagrama de Gantt
directamente en la consola.

Los períodos en los que el procesador permanece desocupado
se representan mediante `IDLE`.

## Tecnologías

- Java 17
- Maven
- Lombok

## Documentación Javadoc

La documentación técnica del proyecto fue generada utilizando
[Javadoc](https://docs.oracle.com/en/java/javase/17/docs/api/).
**[Ver documentación Javadoc](https://monsegomezr.github.io/practica1-sopes2-ss2026/)**

## Estructura del proyecto
```text
src/
└── main/
    └── java/
        └── com/
            └── sopes2/
                ├── MainApp.java
                ├── Proceso.java
                ├── Resultado.java
                ├── Planificador.java
                ├── FCFS.java
                ├── SJF.java
                └── Gantt.java
