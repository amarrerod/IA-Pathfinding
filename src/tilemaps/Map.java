

/**
 *
 * @author Alejandro Marrero Díaz
 * @contact: alu0100825008@ull.edu.es
 * @version 1.0
 * @career: Grado en Ingeniería Informática
 * @College: Universidad de La Laguna
 * @subject: Inteligencia Artificial
 * @course: 3
 * 
 * 
 */


package tilemaps;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;


//Clase para representar el mapa del juego

public class Map {

       //Tamaño de los objetos en el juego
	public static final int TILE_SIZE = 15;
        //Valor estandar para la posicion inicial del juego
        public static final int INICIO = -1;
        //Valor estandar para el objetivo del juego
        public static final int FINAL = -2;
        //Valor para indicar que una celda puede ser transitada
        private static final int VACIO = 0;
        //Valor para indicar que una celda esta bloqueada
        private static final int BLOQUEADA = 1;
        //Valor para indicar que esta celda pertenece a la solucion
        private static final int SOLUCION = '*';
        //Filas, columnas y porcentaje de obstaculos del mapa
	private int filas, columnas, obstPercentage;
     
        //Matriz del tipo NodoMapa en la que estan cada uno de los nodos del mapa
        public NodoMapa[][] pixelesMapa;

        //Coordenadas X e Y del inicio del juego
        private int xBeginMapa, yBeginMapa;
        //Coordenadas X e Y del objetivo del juego
        private int xEndMapa, yEndMapa;

	
	public Map(final int x, final int y,
                   final int inicioX, final int inicioY,
                   final int finX, final int finY,
                   final int porcentaje) {
		
           
            this.columnas = y;
            this.filas = x;
            xBeginMapa = inicioX;
            yBeginMapa = inicioY;
            xEndMapa = finX;
            yEndMapa = finY;
       
            pixelesMapa = new NodoMapa[x][y];
            
            //Inicializamos todos los nodos que componen el tablero
            for(int i=0; i<x; i++)
                for(int j=0; j<y; j++){
                    pixelesMapa[i][j] = new NodoMapa(i,j);
                    pixelesMapa[i][j].setNodoFinal(getFin());
                }
            //Definimos el porcentaje obstaculos
            this.obstPercentage = porcentaje;
            //Generamos un mapa de manera aleatoria
            generarMapaRandom();
            
            
	}
	
        //Metodo que nos permite pintar a traves de un Graphics2D el mapa resultante
        //de la generacion aleatoria y la solucion
        public void pintarMapa(Graphics2D g){
            
            
            for(int i = 0; i < this.filas; i++){
                for(int j=0; j < this.columnas; j++){
                    
                   g.setColor(Color.gray);
                    if(pixelesMapa[i][j].getTipo() == BLOQUEADA)
                        g.setColor(Color.darkGray);
                    
                    if (pixelesMapa[i][j].getTipo() == INICIO)
                        g.setColor(Color.YELLOW);
                    
                    if (pixelesMapa[i][j].getTipo() == FINAL)
                        g.setColor(Color.BLUE);
                    
                    if (pixelesMapa[i][j].getTipo() == SOLUCION)
                        g.setColor(Color.GREEN);
                   
                g.fillRect(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                

                
            }
            
            
            }
        }
        
        //Sobrecarga del metodo para pintar otro mapa distinto
        public void pintarMapa(Graphics2D g, Map mapa){
            
            for(int i = 0; i < this.filas; i++){
                for(int j=0; j < this.columnas; j++){
                    
                   g.setColor(Color.gray);
                    if(mapa.getNodoAt(j, j).getTipo() == BLOQUEADA)
                        g.setColor(Color.darkGray);
                    
                    if (mapa.getNodoAt(i,j).getTipo() == INICIO)
                        g.setColor(Color.YELLOW);
                    
                    if (mapa.getNodoAt(i, j).getTipo() == FINAL)
                        g.setColor(Color.BLUE);
                    
                    if (mapa.getNodoAt(i, j).getTipo() == SOLUCION)
                        g.setColor(Color.GREEN);
                    
                g.fillRect(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                //g.fillRect(filas*TILE_SIZE, columnas*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                //g.drawRect(filas*TILE_SIZE, columnas*TILE_SIZE, TILE_SIZE, TILE_SIZE);

                }   
            }
        }

        
        //Método usado para generar un mapa aleatorio en funcion
        //del porcentaje de obstaculos que se definio
        private void generarMapaRandom(){
            
            int count = 0;
           try{
                pixelesMapa[xBeginMapa][yBeginMapa].setTipo(INICIO);
                pixelesMapa[xEndMapa][yEndMapa].setTipo(FINAL);
                
                while (count < obstPercentage){
                    
                    int i = new Random().nextInt(filas);
                    int j = new Random().nextInt(columnas);
                    
                    if (pixelesMapa[i][j].getTipo() != INICIO &&
                        pixelesMapa[i][j].getTipo() != FINAL){
                     
                        pixelesMapa[i][j].setTipo(BLOQUEADA);
                        pixelesMapa[i][j].setTransitable(false);
                        count++;
                    }
                    
                }
                    
           }catch(ArrayIndexOutOfBoundsException excepcion){
               System.out.println("Fuera del rango del array");
           }
            
        }       
        
        //Definir la posicion inicial para el jugador
        public void setInicioMapa(int x, int y){
            
            xBeginMapa = x;
            yBeginMapa = y;
        }
        
        //Definir el objetivo del agente
        public void setFinalMapa(int x, int y){
            
            xEndMapa = x;
            yEndMapa = y;
        }
   
        //Definir el porcentaje de obstaculos del tablero
        public void setObstPercentage(final int percentage){
            
                this.obstPercentage = percentage;
        }
        
        //Devolver el porcentaje de obstaculos del tablero
        public int getObstPercentage(){
                
                return this.obstPercentage;
        }
        
        //Metodo para resetear el mapa cada vez que se pulsa el boton SETUP en la UI
        public void resetMapa(){
            
            pixelesMapa = null; //Resetamos el array
            filas = 0;
            columnas= 0;
            xBeginMapa = 0;
            yBeginMapa = 0;
            xEndMapa = 0;
            yEndMapa = 0;
            obstPercentage = 0;
        }
        
        
        //Nos devuelve en NodoMapa que corresponde al inicio
        public NodoMapa getInicio(){
            return pixelesMapa[xBeginMapa][yBeginMapa];
        }
        
        //Nos devuelve el NodoMapa que corresponde al final
        public NodoMapa getFin(){
            return pixelesMapa[xEndMapa][yEndMapa];
        }

        //Metodo para imprimir el mapa como una cadena de caracteres con los valores (x,y)
        public void printMapaString(){
            
            for(int i=0; i<filas; i++)
            for(int j=0; j<columnas; j++)
                System.out.print(pixelesMapa[i][j] + "\n");
        }    

        //Devuelve en numero de filas del mapa
        public final int getFilas(){
            return filas;
        }

        //Devuelve el numero de columnas del mapa
        public final int getColumnas(){
            return columnas;
        }
        
        //Devolver un NodoMapa que se encuentra en la posicion (x,y)
        public NodoMapa getNodoAt(final int x, final int y){
            return pixelesMapa[x][y];
        }
        
        //Metodo para cambiar el valor de un nodo
        //Se usa para cambiar el nodo en el caso de que pertenezca a la solucion
        public void cambiarValorNodo(final int x, final int y, final int valor){
            
            pixelesMapa[x][y].setTipo(valor);
        }
        
}
