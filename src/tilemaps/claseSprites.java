/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemaps;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Alejandro Marrero
 */
public class claseSprites {
    
    private final int ancho, alto;
  
    public final int[] pixeles;
    
    public claseSprites(final String ruta, final int ancho, final int alto) throws IOException{
     
            this.ancho = ancho;
            this.alto = alto;
            pixeles = new int [this.ancho * this.alto];
            BufferedImage imagen;
            try{
            imagen = ImageIO.read(claseSprites.class.getResource(ruta));
             imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
            }catch(IOException e){
                e.printStackTrace();
            }
           
        }
    
    
    public int getAncho(){
        
        return this.ancho;
    }
    
    public int getAlto(){
        
        return this.alto;
    }
}
