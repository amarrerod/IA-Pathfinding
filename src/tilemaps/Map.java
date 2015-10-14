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
import tilemaps.claseSprites;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {

        
	public static final int TILE_SIZE = 15;
        
        public static final int INICIO = -1;
        public static final int FINAL = 2;
        private static final int VACIO = 0;
        private static final int BLOQUEADA = 1;
	private int ancho, alto, x, y;
        
        public int[][] pixelesMapa; //Mapa 

        private int xBeginMapa, yBeginMapa;
        private int xEndMapa, yEndMapa;

	
	public Map(final int ancho, final int alto) {
		
            this.alto = alto;
            this.ancho = ancho;
            pixelesMapa = new int [ancho][alto];
            
          
            generarMapaRandom();
            
//            for (int y=0;y<alto;y++) {
//			pixelesMapa[0][y] = BLOQUEADA;
//			pixelesMapa[2][y] = BLOQUEADA;
//			pixelesMapa[7][y] = BLOQUEADA;
//			pixelesMapa[11][y] = BLOQUEADA;
//			pixelesMapa[ancho-1][y] = BLOQUEADA;
//		}
//		for (int x=0;x<ancho;x++) {
//			if ((x > 0) && (x < ancho-1)) {
//				pixelesMapa[x][10] = VACIO;
//			}
//			
//			if (x > 2) {
//				pixelesMapa[x][9] = BLOQUEADA;
//			}
//			pixelesMapa[x][0] = BLOQUEADA;
//			pixelesMapa[x][alto-1] = BLOQUEADA;
//		}
//		
//		pixelesMapa[4][9] = VACIO;
//		pixelesMapa[7][5] = VACIO;
//		pixelesMapa[7][4] = VACIO;
//		pixelesMapa[11][7] = VACIO;
//         
            
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
        public void cargarMapa(String ruta) {
        
        
        
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
}
