
package tilemaps;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;




public class Map {

       
	public static final int TILE_SIZE = 15;
        public static final int INICIO = -1;
        public static final int FINAL = -2;
        private static final int VACIO = 0;
        private static final int BLOQUEADA = 1;
        private static final int SOLUCION = '*';
	private int filas, columnas, obstPercentage;
      
 
        
        public NodoMapa[][] pixelesMapa;

        private int xBeginMapa, yBeginMapa;
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
            
            for(int i=0; i<x; i++)
                for(int j=0; j<y; j++){
                    pixelesMapa[i][j] = new NodoMapa(i,j);
                    pixelesMapa[i][j].setNodoFinal(getFin());
                }
            this.obstPercentage = porcentaje;
            generarMapaRandom();
            
            
	}
	
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
                    
                   
                g.fillRect(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                //g.fillRect(filas*TILE_SIZE, columnas*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                //g.drawRect(filas*TILE_SIZE, columnas*TILE_SIZE, TILE_SIZE, TILE_SIZE);

                
            }
            
            
            }
        }
        
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
        
        
        public void setInicioMapa(int x, int y){
            
            xBeginMapa = x;
            yBeginMapa = y;
        }
        
        public void setFinalMapa(int x, int y){
            
            xEndMapa = x;
            yEndMapa = y;
        }
   
        
        public void setObstPercentage(final int percentage){
            
                this.obstPercentage = percentage;
        }
        
        public int getObstPercentage(){
                
                return this.obstPercentage;
        }
        
        
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
        
           
        public NodoMapa getInicio(){
            return pixelesMapa[xBeginMapa][yBeginMapa];
        }
        
        public NodoMapa getFin(){
            return pixelesMapa[xEndMapa][yEndMapa];
        }

        public void printMapaString(){
            
            for(int i=0; i<filas; i++)
            for(int j=0; j<columnas; j++)
                System.out.print(pixelesMapa[i][j] + "\n");
        }    

        public final int getFilas(){
            return filas;
        }

        public final int getColumnas(){
            return columnas;
        }
        
        public NodoMapa getNodoAt(final int x, final int y){
            return pixelesMapa[x][y];
        }
        
        public void cambiarValorNodo(final int x, final int y, final int valor){
            
            pixelesMapa[x][y].setTipo(valor);
        }
        
}
