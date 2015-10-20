/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemaps;


import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;


public class Agente {
	
    
	private float x, y; //Posicion actual
	
	private Map map;

	private float size = 0.01f;
	
        private float ang;
        
        private URL rutaImagenAgente;
        
         private Image spriteAgente;
	
	public Agente(Map map, int x, int y) {
		
		this.map = map;
		this.x = x;
		this.y = y;
                
                 
            try{
                URL url = Thread.currentThread().getContextClassLoader().getResource("res/sonic.png");
                
                if (url == null){
                    System.err.println("Unable to find sprite: res/sonic.png");
                    System.exit(0);
                }
                spriteAgente = ImageIO.read(url);
                
            }catch(IOException e){
                System.err.println("No se pudo cargar el sprite del jugador");
                System.exit(0);
            }
            
          
	}
	
	public void pintarAgente(Graphics2D g) {
	
            int xp = (int) (map.TILE_SIZE*x);
            int yp = (int) (map.TILE_SIZE*y);
            g.rotate(ang,xp,yp);
            g.drawImage(spriteAgente, (int)(xp-16),(int)(yp-16), null);
	    g.rotate(-ang,xp,yp);	
	}
//        
//        public boolean posicionValida(float nx, float ny) {
//		
//		if (map.celdaBloqueada(nx - size, ny - size)) {
//			return false;
//		}
//		if (map.celdaBloqueada(nx + size, ny - size)) {
//			return false;
//		}
//		if (map.celdaBloqueada(nx - size, ny + size)) {
//			return false;
//		}
//		if (map.celdaBloqueada(nx + size, ny + size)) {
//			return false;
//		}
//		
//		return true;
//	}
//	
//        
//        public boolean moverJugador (float dx, float dy){
//            
//            float nx = x + dx;
//		float ny = y + dy;
//		
//		if (posicionValida(nx, ny)) {
//			
//                        x = nx;
//			y = ny;
//	
//			ang = (float) (Math.atan2(dy, dx) - (Math.PI / 2));
//			return true;
//		}
//		
//		
//		return false;
//        }
//        
// 
	
}