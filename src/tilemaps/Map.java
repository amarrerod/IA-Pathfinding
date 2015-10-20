/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemaps;


import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.JOptionPane;



public class Map {

       
	public static final int TILE_SIZE = 15;
        public static final int INICIO = -1;
        public static final int FINAL = -2;
        private static final int VACIO = 0;
        private static final int BLOQUEADA = 1;
	private int ancho, alto, x, y, obstPercentage;
      
 //       public int[][] pixelesMapa; //Mapa 
        
        public NodoMapa[][] pixelesMapa;

        private int xBeginMapa, yBeginMapa;
        private int xEndMapa, yEndMapa;

	
	public Map(final int ancho, final int alto,
                   final int inicioX, final int inicioY,
                   final int finX, final int finY,
                   final int porcentaje) {
		
           
            this.alto = alto;
            this.ancho = ancho;
            xBeginMapa = inicioX;
            yBeginMapa = inicioY;
            xEndMapa = finX;
            yEndMapa = finY;
            //pixelesMapa = new int [ancho][alto];
            pixelesMapa = new NodoMapa[ancho][alto];
            
            for(int i=0; i<ancho; i++)
            for(int j=0; j<alto; j++)
            pixelesMapa[i][j] = new NodoMapa();
            
            obstPercentage = porcentaje;
            generarMapaRandom();
            
            
	}
	
        public void pintarMapa(Graphics2D g){
            
            
            for(int x = 0; x < ancho; x++){
                for(int y=0; y < alto; y++){
                    
                   g.setColor(Color.gray);
                    if(pixelesMapa[x][y].getTipo() == BLOQUEADA)
                        g.setColor(Color.darkGray);
                    
                    if (pixelesMapa[x][y].getTipo() == INICIO)
                        g.setColor(Color.YELLOW);
                    
                    if (pixelesMapa[x][y].getTipo() == FINAL)
                        g.setColor(Color.BLUE);
                    
                   
                
                g.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                
                
            }
            
            
            }
        }
        
        //Recibimos un ArrayList y vamos sacando los elementos y pintadolos en el mapa
        public void pintarCamino(ArrayList<NodoMapa> solucion, Graphics2D g){
            
           while (!solucion.isEmpty()){
               
               g.setColor(Color.GREEN);
               NodoMapa aux = solucion.remove(0); //Sacamos el primero
               g.fillRect(aux.getX()*TILE_SIZE, aux.getY()*TILE_SIZE,TILE_SIZE,TILE_SIZE);
               
           }
            
        }
        
        
        private void generarMapaRandom(){
            
            int count = 0;
           try{
                pixelesMapa[xBeginMapa][yBeginMapa].setTipo(INICIO);
                pixelesMapa[xEndMapa][yEndMapa].setTipo(FINAL);
                
                while (count < obstPercentage){
                    
                    int i = new Random().nextInt(ancho);
                    int j = new Random().nextInt(alto);
                    
                    if (pixelesMapa[i][j].getTipo() != INICIO &&
                        pixelesMapa[i][j].getTipo() != FINAL){
                     
                        pixelesMapa[i][j].setTipo(BLOQUEADA);
                        count++;
                    }
                    
                }
                    
           }catch(ArrayIndexOutOfBoundsException excepcion){
               System.out.println("Fuera del rango del array");
           }
            
        }       
        
        public int[] getInicioMapa(){
            
            int[] valores = {xBeginMapa, yBeginMapa};
            return (valores);
        }
        
        public int[] getFinalMapa(){
            
            int[] valores = {xEndMapa, yEndMapa};
            return (valores);
            
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
            ancho = 0;
            alto = 0;
            obstPercentage = 0;
        }
        
        public NodoMapa[][] getMatriz(){
            return pixelesMapa;
        }
        
        public NodoMapa getInicio(){
            return pixelesMapa[xBeginMapa][yBeginMapa];
        }
        
        public NodoMapa getFin(){
            return pixelesMapa[xEndMapa][yEndMapa];
        }
}
