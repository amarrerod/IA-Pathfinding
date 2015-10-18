/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemaps;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * A very simple example to illustrate how simple tile maps can be
 * used for basic collision. This particular technique only works
 * in certain circumstances and for small time updates. However, this 
 * fits many maze based games perfectly. 
 * 
 * @author Kevin Glass
 */
public class Game extends Canvas implements KeyListener {
	
    
      private static final String NOMBRE = "Inteligencia Artificial - Pathfinding";
      private static final int ANCHO = 800;
      private static final  int ALTO = 600;
      
      private static final int ANCHO_MAPA = 30;//128;
      private static final int ALTO_MAPA = 30;//68;
      
      private static JFrame ventanaPrincipal;
      
      
      /** True if the left key is currently pressed */
	private boolean left;
	/** True if the right key is currently pressed */
	private boolean right;
	/** True if the up key is currently pressed */
	private boolean up;
	/** True if the down key is currently pressed */
	private boolean down;

      
     
      private Map map;
      private Agente jugador;
      private BufferStrategy strategy;
      
      private static volatile boolean funcionando = false;
      
       
	public Game() {
		
           
            ventanaPrincipal = new JFrame(NOMBRE);
            ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventanaPrincipal.setLayout(new BorderLayout());
           
            //setBounds(0,0,ANCHO*15,ALTO*15);
            ventanaPrincipal.pack();
            ventanaPrincipal.add(this, BorderLayout.CENTER);
            ventanaPrincipal.setSize(ANCHO,ALTO);
            ventanaPrincipal.setResizable(true);
            ventanaPrincipal.setLocationRelativeTo(null); //Para que quede centrada en el centro del escritorio       
            
             
            
            ventanaPrincipal.addKeyListener(this);
            addKeyListener(this);
            ventanaPrincipal.setVisible(true); 
             
             createBufferStrategy(2);
             strategy = getBufferStrategy();
             map = new Map(ANCHO_MAPA, ALTO_MAPA);
             map.setObsPercentage(50);
             jugador = new Agente(map, 1,1);
             bucleJuego();
	}
	
	public void bucleJuego() {
            
        funcionando = true;
        long ultimo = System.nanoTime();
               
        System.nanoTime();
        while (funcionando){ //Mientras el juego esté funcionando
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
           
            map.pintarMapa(g);
            jugador.pintarAgente(g);
            g.dispose();
            strategy.show();
            
            try{
                Thread.sleep(4);
            }catch(Exception e){};
            
            long delta = (System.nanoTime() - ultimo) / 1000000;
            ultimo = System.nanoTime();
            
            for(int i=0; i<delta / 5; i++)
                logic(5);
	
            if ((delta % 5) != 0)
                logic(delta % 5);
        
        
        }
    }
        
    public void logic(long delta){
        
        float dx = 0;
		float dy = 0;
		if (left) {
			dx -= 1;
		}
		if (right) {
			dx += 1;
		}
		if (up) {
			dy -= 1;
		}
		if (down) {
			dy += 1;
		}
		
		
		if ((dx != 0) || (dy != 0)) {
			jugador.moverJugador(dx * delta * 0.003f,
						dy * delta * 0.003f);
		}
        
    }
      
    public static void main (String[] args){
        
        new Game();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
    }
    
    
}


	
	


    

	