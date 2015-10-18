/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemaps;


import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Map {

       
	public static final int TILE_SIZE = 15;
        public static final int INICIO = -1;
        public static final int FINAL = 2;
        private static final int VACIO = 0;
        private static final int BLOQUEADA = 1;
	private int ancho, alto, x, y, obsPercentage;
       
        private Scanner rutaMapa;
        public int[][] pixelesMapa; //Mapa 

        private int xBeginMapa, yBeginMapa;
        private int xEndMapa, yEndMapa;

	
	public Map(final int ancho, final int alto) {
		
            rutaMapa = null;
            this.alto = alto;
            this.ancho = ancho;
            pixelesMapa = new int [ancho][alto];
            
           // generarMapaRandom();
             cargarMapa();       
            
	}
	
        public void pintarMapa(Graphics2D g){
            
            
            for(int x = 0; x < ancho; x++){
                for(int y=0; y < alto; y++){
                    
                   g.setColor(Color.gray);
                    if(pixelesMapa[x][y] == BLOQUEADA)
                        g.setColor(Color.darkGray);
                    
                    if (pixelesMapa[x][y] == INICIO)
                        g.setColor(Color.YELLOW);
                    
                    if (pixelesMapa[x][y] == FINAL)
                        g.setColor(Color.BLUE);
                    
                   
                
                g.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                
                
            }
            
            
            }
        }
        
        public void generarMapaRandom(){
            
            
            for(int y=0; y<alto; y++){
                for(int x=0; x<ancho; x++){
                    
                  if(x == 0 || y == 0 ||
                       x == ancho-1 || y == alto-1 )
                        pixelesMapa[x][y] = 1;
                            
                  else 
                    pixelesMapa[x][y] = new Random().nextInt(2);
                    
                }
            }
            
        }
        //Cargamos un mapa desde un fichero
        public void cargarMapa(){
        
            try{
            rutaMapa = new Scanner(new File("src\\mapas\\mapa1.txt")); //Poner la ruta del fichero
            }catch(FileNotFoundException e){
                System.out.println("Fichero no encontrado \n");
            }
             
            for(int x=0; x<ancho; x++)
                for(int y=0; y<alto; y++)
                   pixelesMapa[x][y] = rutaMapa.nextInt();
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
        
        public boolean celdaBloqueada(float x, float y) {
		
		return pixelesMapa[(int) x][(int) y] == BLOQUEADA;
	}
        
        public void setObsPercentage(final int percentage){
            
                this.obsPercentage = percentage;
        }
        
        public int getObsPercentage(){
                
                return this.obsPercentage;
        }
}
