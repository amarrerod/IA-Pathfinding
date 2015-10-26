
package tilemaps;

import static java.lang.Math.pow;


/* Clase para representar cada uno de los nodos del mapa
   con los valores xy de la posición
   la distancia desde el inicio hasta ese punto
   distancia desde el punto hasta el final 
   indicar si el punto puede ser transitado o no
   los valores de las funciones F, G y H para el algoritmo A*
*/

    
public class NodoMapa implements Comparable {
    

        public static final int INICIO = -1;
        public static final int FINAL = -2;
        private static final int VACIO = 0;
        private static final int BLOQUEADA = 1;
    
        private int x;
        private int y;
        private int tipoNodo;
        
        private boolean transitable;

        /**
         * Valor total del nodo.
         * F = G + H*
         */
        private int F;

        /**
         * Valor desde el nodo hasta el nodo inicial.
         * Las diagonales suman 14 y las ortogonales 10.
         */
        private int G;

        /**
         * Valor de la heurística para hacer el cálculo de F
         * Usando las fórmulas de Distancia Manhattan y
         * distancia Euclides para hallar el valor de H 
         */
        private int H;

        private NodoMapa nodoPadre;
        private NodoMapa nodoFinal; //Para poder calcula la estimación


        public NodoMapa(final int x, final int y)
        {
                this.x = x;
                this.y = y;

                transitable = true;
                tipoNodo = VACIO;
                
                F = 0;
                G = 0;
                H = 0;

                nodoPadre = null;
                nodoFinal = null;
        }
        
         /**
         * Compara dos nodos según su valor de F.
         * @param objeto Nodo con el que se va a comparar el nodo que invocó el
         * método.
         * @return Devuelve 1 si el nodo que invocó el método tiene menor F,
         * devuelve 0 si son iguales o -1 en otro caso.
         */
        @Override
        public int compareTo(Object objeto)
        {
                if (F > ((NodoMapa) objeto).F) return 1;
                else if (F < ((NodoMapa) objeto).F) return -1;
                else return 0;
        }

   
        public int getX(){
                return x;
        }

        public boolean setX(int x){
                if (x >= 0)
                {
                        this.x = x;
                        return true;
                }
                return false;
        }

        public int getY(){
                return y;
        }

        public boolean setY(int y){
                if (y >= 0)
                {
                        this.y = y;
                        return true;
                }
                return false;
        }

        /**
         * Recalcula el valor de F. Cuando G, H han cambiado.
         */
        private void recalcularF()
        {
                F = G + H;
        }

        /**
         * Recalcula el valor de G. Cuando el padre se ha modificado.
         */
        private void recalcularG()
        {
                G = nodoPadre.G;
                if (x==nodoPadre.x || y==nodoPadre.y)
                        G += 10;
                else
                        G += 14;
                recalcularF();
        }

        /**
         * Recalcula el valor de H. Normalmente, cuando el nodo final ha cambiado.
         */
        private void recalcularH(){
            
            if (nodoFinal != null)
            //H = distManhattan();
            H = distEuclides();
            else
                H = 0;
      
                recalcularF();
        }

        public int getF(){
                return F;
        }
        public int getG(){
                return G;
        }

        public int getH(){
                return H;
        }

        
        public NodoMapa getNodoPadre()
        {
                return nodoPadre;
        }

        public void setNodoPadre(NodoMapa nodoPadre)
        {
                this.nodoPadre = nodoPadre;
                recalcularG();
        }

        public NodoMapa getNodoFinal()
        {
                return nodoFinal;
        }

   
        public void setNodoFinal(NodoMapa nodoFinal)
        {
                this.nodoFinal = nodoFinal;
                recalcularH();
        }

       
        public boolean getTransitable()
        {
                return transitable;
        }

        
        public void setTransitable(boolean transitable)
        {
                this.transitable = transitable;
        }

            
        //Util a la hora de pintar el mapa para saber el color
        public int getTipo(){
            return this.tipoNodo;
        }
        
        public void setTipo(final int tipo){
            
            if (tipo == BLOQUEADA)
                setTransitable(true);
           else
                 setTransitable(true);           
            
            this.tipoNodo = tipo;
        }
        
        /*@parms:
        * @return: Nos devuelve la distancia mediante la fórmula Manhattan entre 
        * el nodo actual y el nodo final
        */
        private int distManhattan(){
            
            return  (Math.abs(x-nodoFinal.getX()) + Math.abs(y-nodoFinal.getY()));
            
        }
        
        /*@parms:
        * @return: Nos devuelve la distancia
        * mediante la fórmula de Euclides
        * entre el nodo actual y el nodo final
        */
        private int distEuclides(){
            
            int aux1 = (int) pow((x - nodoFinal.getX()),2);
            int aux2 = (int) pow((y - nodoFinal.getY()),2);
            return (int)Math.sqrt((aux1-aux2));
            
        }
        
        @Override
        public String toString()
        {
                return "(" + x + ", " + y + ")";
        }

}
