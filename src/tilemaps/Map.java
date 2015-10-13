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
import tilemaps.claseSprites;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {

       
	public static final int TILE_SIZE = 20;
        public static final int ANCHO_CELDA = 15;
        public static final int ALTO_CELDA = 15;
        private static final int VACIO = 0;
        private static final int BLOQUEADA = 1;
	private int ancho, alto, x, y;
        
        public int[][] pixelesMapa; //Mapa 
	

	
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
         
            
	}
	
        public void pintarMapa(Graphics2D g){
            
            for(int x = 0; x < this.ancho; x++){
                for(int y=0; y < this.alto; y++){
                    
                    g.setColor(Color.darkGray);
                    if(pixelesMapa[x][y] == BLOQUEADA)
                        g.setColor(Color.gray);
                    
                   
                
                g.fillRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE);
                
                
            }
            
            
            }
        }
        
        public void generarMapaRandom(){
            
            for(int y=0; y<alto; y++){
                for(int x=0; x<ancho; x++){
                    pixelesMapa[x][y] = new Random().nextInt(2);
                    
                }
            }
            
        }
        
        public void cargarMapa(String ruta) {
        
            try {
                DataInputStream ds = new DataInputStream(new FileInputStream(ruta));
                
                //Leer filas y columnas --> cargar mapa                 
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        }
        
        
	
	public boolean blocked(float x, float y) {
		// look up the right cell (based on simply rounding the floating

		// values) and check the value

		return pixelesMapa[(int) x][(int) y] == BLOQUEADA;
	}
}
