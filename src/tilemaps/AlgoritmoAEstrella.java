package tilemaps;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Marrero
 */
public class AlgoritmoAEstrella {

    private final NodoMapa[][] matriz;
    private final NodoMapa nodoInicio;
    private final NodoMapa nodoFinal;

    public AlgoritmoAEstrella(NodoMapa[][] matriz, NodoMapa inicio, NodoMapa fin) {

        this.matriz = matriz;
        this.nodoInicio = inicio;
        this.nodoFinal = fin;

    }

    /* Ejecuta el algoritmo A* para encontrar el camino
     desde el nodo inicial hasta el nodo final
     en el caso de que ese camino exista nos devuelve
     un ArrayList con los puntos del sendero que contiene
     a la solucion del problema */
    public ArrayList calcularSendero() {

        Deap listaAbierta = new Deap(); //Creamos montículo doble
        ArrayList listaCerrada = new ArrayList<>(); //La lista cerrada con las soluciones de tipo NodoMapa
        NodoMapa nodoActual = null;
        boolean solucion = false;

        int filas = matriz.length; 
        int columnas = 0;
        if (filas > 0) {
            columnas = matriz[0].length;
        }

        listaAbierta.push(nodoInicio); //Metemos en la lista abierta el nodo de salida
        int it = 0; //Iteraciones del algoritmo

        //Buscamos el camino mientras hayan opciones y no haya sido encontrado
        while (!listaAbierta.isEmpty() && !solucion) {

            it++;
            nodoActual = (NodoMapa) listaAbierta.popBottom();
            listaCerrada.add(nodoActual);

            //Sacamos a los vecinos del nodoActual
            ArrayList nodosVecinos = new ArrayList<>();

            boolean derecha = false, izquierda = false, arriba = false, abajo = false; //Posibles movimientos
            if (0 <= nodoActual.getX() + 1 && nodoActual.getX() + 1 < columnas
                    && 0 <= nodoActual.getY() && nodoActual.getY() < filas) {

                if (matriz[nodoActual.getY()][nodoActual.getX() + 1].getTransitable()) {
                    nodosVecinos.add(matriz[nodoActual.getY()][nodoActual.getX() + 1]);
                    derecha = true;
                }
            }

            if (0 <= nodoActual.getX() - 1 && nodoActual.getX() - 1 < columnas
                    && 0 <= nodoActual.getY() && nodoActual.getY() < filas) {

                if (matriz[nodoActual.getY()][nodoActual.getX() - 1].getTransitable()) {
                    nodosVecinos.add(matriz[nodoActual.getY()][nodoActual.getX() - 1]);
                    izquierda = true;
                }
            }

            if (0 <= nodoActual.getX() && nodoActual.getX() < columnas
                    && 0 <= nodoActual.getY() - 1 && nodoActual.getY() - 1 < filas) {

                if (matriz[nodoActual.getY() - 1][nodoActual.getX()].getTransitable()) {
                    nodosVecinos.add(matriz[nodoActual.getY() - 1][nodoActual.getX()]);
                    arriba = true;
                }
            }

            if (0 <= nodoActual.getX() && nodoActual.getX() < columnas
                    && 0 <= nodoActual.getY() + 1 && nodoActual.getY() + 1 < filas) {

                if (matriz[nodoActual.getY() + 1][nodoActual.getX()].getTransitable()) {
                    nodosVecinos.add(matriz[nodoActual.getY() + 1][nodoActual.getX()]);
                    abajo = true;
                }
            }

       // Para cada nodo encontrado, comprobamos si hemos llegado al punto de destino.
	while (!nodosVecinos.isEmpty() && !solucion){
	
            NodoMapa nodoAdyacente = (NodoMapa) nodosVecinos.remove(0);
            if (!listaCerrada.contains(nodoAdyacente)){
		
                if (!listaAbierta.contains(nodoAdyacente)){
                    nodoAdyacente.setNodoPadre(nodoActual);
		    listaAbierta.push(nodoAdyacente);

                    if (nodoFinal == nodoAdyacente)
			solucion = true;
		}
            else {
	
                int nuevoG = nodoActual.getG();
                    if (nodoAdyacente.getX()==nodoActual.getX() ||
                        nodoAdyacente.getY()==nodoActual.getY())
                        
                            nuevoG += 10;
                    else
                            nuevoG += 14;

                    if (nuevoG < nodoAdyacente.getG()){
                        nodoAdyacente.setNodoPadre(nodoActual);
                        listaAbierta.reordenar();
                    }
		}
                }
	}
	}


		// Si hemos llegado al nodo final, volvemos hacia atrás desde ese nodo extrayendo el camino hasta el nodo inicial.
        if (solucion){
	
            ArrayList camino = new ArrayList<>();
            NodoMapa nodoAuxiliar = nodoFinal;
            while (nodoAuxiliar != null){
				
               camino.add(0, nodoAuxiliar);
                nodoAuxiliar = nodoAuxiliar.getNodoPadre();
		
            }
	
            return camino;
	}
		
        else 
            return null;
	}
}
