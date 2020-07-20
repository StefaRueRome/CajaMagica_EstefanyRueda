/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estefany Rueda
 */
public class cajaMagica {

    int dimension = 5;
    int[][] arreglo;

    public cajaMagica() {
        arreglo = new int[dimension][dimension];
        crearCaja();
    }

    public void crearCaja() {
        //encontrar la casilla central del primer renglon
        int mitad = dimension / 2;
        //ubicacion
        int ubicacionColumna = mitad;
        int ubicacionFila = 0;

        //Asignar el 1 a la columna de la mitad de la primera fila
        arreglo[ubicacionFila][ubicacionColumna] = 1;

        //Guardar ubicación actual de la columna y fila
        int ubicacionFActual = ubicacionFila;
        int ubicacionCActual = ubicacionColumna;

        //Recorrer los numeros desde 2
        for (int i = 2; i <= (Math.pow(arreglo.length, 2)); i++) {
            ubicacionFila -= 1;
            ubicacionColumna -= 1;
            //cuando se devuelve se sale de la matriz
            if (ubicacionFila < 0) {
                ubicacionFila = arreglo.length - 1;
            }
            if (ubicacionColumna < 0) {
                ubicacionColumna = arreglo.length - 1;
            }
            //Validación si la celda esta vacia 
            if (arreglo[ubicacionFila][ubicacionColumna] == 0) {
                arreglo[ubicacionFila][ubicacionColumna] = i;
            } else {

                ubicacionFila = ubicacionFActual + 1;
                ubicacionColumna = ubicacionCActual;
                arreglo[ubicacionFila][ubicacionColumna] = i;
            }
            //se vuelve a guardar la ubicacion actual
            ubicacionFActual = ubicacionFila;
            ubicacionCActual = ubicacionColumna;

        }

        mostrarArreglo();

    }

    public void mostrarArreglo() {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                System.out.println(arreglo[i][j] + "");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {

        new cajaMagica();
    }
}
