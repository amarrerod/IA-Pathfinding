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
import javax.imageio.ImageIO;


public class Agente {
	
    
	private int x, y; //Posicion actual
	
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
	
            g.drawImage(spriteAgente, x,y, null);
		
	}
	
}