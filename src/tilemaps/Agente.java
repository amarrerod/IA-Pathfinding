

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
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


//CLase para definir la imagen del agente que hará el recorrido
public class Agente {
	
    
	private float x, y; //Posicion actual
	
        //Mapa sobre el que se mueve
	private Map map;

        //Escala del agente
	private float size = 0.01f;
	//Angulo --> en funcion de a donde mira
        private float ang;
        
        //URL para coger la imagen del agente
        private URL rutaImagenAgente;
        //Imagen del agente
        private Image spriteAgente;
	
        //Constructor para definir al agente inicialmente
        //en el mapa map y en la posicion (x,y)
	public Agente(Map map, int x, int y) {
		
		this.map = map;
		this.x = x;
		this.y = y;
                
            //Bloque try-catch para evitar que rompa en caso de que no se pueda cargar la imagen     
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
	
        //Metodo para pintar el agente con el Graphics2D pasado
	public void pintarAgente(Graphics2D g) {
	
            int xp = (int) (map.TILE_SIZE*x);
            int yp = (int) (map.TILE_SIZE*y);
            g.rotate(ang,xp,yp);
            g.drawImage(spriteAgente, (int)(yp-16),(int)(xp-16), null);
	    g.rotate(-ang,xp,yp);	
	}
        
        //Sobrecarga del metodo para pintar el agente en la posicion (x,y)
        //Usado cuando tenemos que definir la solucion
        public void pintarAgente(Graphics2D g, final int x, final int y){
            
            int xp = (int) (map.TILE_SIZE*x);
            int yp = (int) (map.TILE_SIZE*y);
            g.rotate(ang,xp,yp);
            g.drawImage(spriteAgente, (int)(yp-16),(int)(xp-16), null);
	    g.rotate(-ang,xp,yp);
            
        }
	
}