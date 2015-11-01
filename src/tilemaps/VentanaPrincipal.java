
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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class VentanaPrincipal extends javax.swing.JFrame implements ActionListener {

    //Variable para controlar que antes de ejecutar A*
    //se ha configurado el entorno
    private boolean configurado = false;
    //Nombre para la ventana
    private final String nombre = "Inteligencia Artificial";
    //Mapa sobre el que se ejecutará A*
    private static Map map;
    
    //Buffer de gráficos para pintar el mapa, jugador...etc
    private BufferStrategy strategy;
    private MouseListener mouseListen;
    //Agente que hará el recorrido --> SONIC
    private Agente jugador;
    //Graphics2D para pintar todo el entorno
    private Graphics2D g;

    public VentanaPrincipal() {
        
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(nombre);
        ImageIcon icono = new ImageIcon("res/safari.png");
        setIconImage(icono.getImage());
        this.setSize(1024,800);
        setResizable(false);
        this.setLocationRelativeTo(null);
        
        //Configuramos el panel donde se dibuja el mapa
        this.setCanvasPanel();
        //Definimos los listener para los botones de la UI
        botonSetup.addActionListener(this);
        botonIniciar.addActionListener(this);
        //Inicialmente el entorno no esta configurado
        configurado = false;
        //Hacemos visible la ventana
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        obstSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        canvasPanel = new java.awt.Canvas();
        botonSetup = new javax.swing.JButton();
        inicioYSpin = new javax.swing.JSpinner();
        inicioXSpin = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        finXSpin = new javax.swing.JSpinner();
        finYSpin = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setResizable(false);

        obstSlider.setValue(0);

        jLabel3.setText("Porcentaje Obstaculos");

        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        canvasPanel.setMaximumSize(new java.awt.Dimension(994, 663));
        canvasPanel.setMinimumSize(new java.awt.Dimension(994, 663));

        botonSetup.setText("Setup");

        jLabel4.setText("Inicio");

        jLabel5.setText("Fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inicioXSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inicioYSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(finXSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finYSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259)
                        .addComponent(obstSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canvasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonIniciar)
                        .addComponent(botonSetup)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(finYSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(finXSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(inicioYSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inicioXSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(obstSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addComponent(canvasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIniciarActionPerformed

          
    public void setCanvasPanel(){
        
        //Para poner colocar los obstaculos con un click
        //      NO FUNCIONANDO EN ESTA VERSION
        canvasPanel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) { //Cuando hacemos click dentro del panel se muestran las coordenadas
                
                int x = e.getX();
                int y = e.getY();
                System.out.println(x+" "+y);
                
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //Ponemos un color blanco de fondo
        canvasPanel.setBackground(Color.white);
        canvasPanel.createBufferStrategy(2);
        strategy = canvasPanel.getBufferStrategy();
        
         }
    
    
    //Metodo para pintar el entorno con el
    //mapa que pasamos por parametro
    private void pintarEntorno(Map map){
          
        //Cogemos el contenido del buffer que creamos antes 
        g = (Graphics2D) strategy.getDrawGraphics();
        
        //Reseteamos el marco
            g.setColor(Color.white);
            g.clearRect(0,0,canvasPanel.getWidth(),canvasPanel.getHeight());
        
            //Pintamos el mapa que se nos genera aleatoriamente
            map.pintarMapa(g);
            //Pintamos el agente en la posicion inicial
            jugador.pintarAgente(g);
            //Lo mostramos todo
            g.dispose();
            strategy.show();      
    }
    
    //Metodo que se utiliza para configurara todo el entorno
    //se invoca cuando se hace click en el boton SETUP de la UI
    private void setupEntorno(){
        
          
            // Creamos el mapa
            if (map != null)
                map.resetMapa();
            
            //Todavía no esta configurado
            configurado = false;
            
            //Definimos las variables para el inicio y fin del juego
            int inicioX,inicioY, finX,finY;
            inicioX = (int)inicioXSpin.getValue();
            inicioY = (int)inicioYSpin.getValue();
            finX = (int)finXSpin.getValue();
            finY = (int) finYSpin.getValue();
            
            //Definimos el porcentaje de obstaculos
            int porcentaje;
            //POR DEFECTO TENEMOS 44 FILAS y 66 COLUMNAS en el mapa
            porcentaje = ((44*66)*obstSlider.getValue())/100; 
            
            //Bloque try-catch para comprobar que los rangos están bien y evitar que rompa el programa
            try {
              
                if(inicioX >= 44 || inicioX < 0)
                    throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if (inicioY >= 66 || inicioY < 0)
                      throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if (finX >= 44 || finX < 0)
                      throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if (finY >= 66|| finY <0)
                      throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
               
            }catch (Exception e){
            
                JOptionPane.showMessageDialog(this,e.getMessage());

            }
             
            //Creamos el mapa con M=44 y N=66 por defecto
            map = new Map(44,66,inicioX,inicioY,finX,finY,porcentaje);
            //Creamos el agente en el mapa map y en la posicion (inicioX,inicioY)
            jugador = new Agente(map,inicioX, inicioY);
            //Pintamos el entorno
            pintarEntorno(map);  
            //Ya podemos considerar el entorno como configurado
            configurado = true;
           
     
    }
    
    //Metodo para ejecutar el algoritmo A*
    //se invoca cuando se hace click en el boton Iniciar de la UI
    private void runAlgoritmo(){
       
      //Primero hay que comprobar que el entorno esta configurado
      try{
           if (configurado == false)
               throw new ExcepcionesPersonales("PRIMERO CONFIGURE EL ENTORNO");          
            }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
      
      //Si el entorno esta configurado ejecutamos el algoritmo A* en el mapa map
      AlgoritmoAEstrella AEstrella = new AlgoritmoAEstrella(map,map.getInicio(),map.getFin());
        
      //Antes de pintar la solucion hay que comprobar que esa solucion existe
      try {
         //Nos devuelve un ArrayList con los nodos de la solucion o NULL si no existe la solucion
         ArrayList<NodoMapa> solucion = AEstrella.calcularSendero();
         //Si no hay solucion enviamos un alert indicando que noe existe
        if( solucion == null)
            throw new ExcepcionesPersonales("No hay solución");
           
        else{ //Si tenemos una solucion valida la pintamos en el entorno
            
            pintarSolucion(solucion);
            System.out.println("Se han ejecutado: " + AEstrella.getIteraciones() + " iteraciones");
        }}catch(Exception e){
          
          JOptionPane.showMessageDialog(this, e.getMessage());
      }
             
    }
    
    //Metodo para pintar la solucion de A*
    //recibe el ArrayList con la solucion
    private void pintarSolucion(ArrayList<NodoMapa>solucion){
        
        //En primer lugar recorremos el ArrayList
        //y cambiamos los valores de los nodos del mapa
        //que forman parte de la solucion 
        for(NodoMapa i: solucion)
            map.cambiarValorNodo(i.getX(), i.getY(), '*');
        
        //Mientras que queden nodos en la solucion
        while (!solucion.isEmpty()){
            
            //Sacamos el primer nodo que forma parte de la solucion
            NodoMapa aux = solucion.remove(0);
            g = (Graphics2D) strategy.getDrawGraphics();
            map.pintarMapa(g);
            //Pintamos el agente en la posicion de ese nodo
            jugador.pintarAgente(g, aux.getX(), aux.getY());
            
            g.dispose();
            strategy.show();
            //Hacemos que el programa se detenga durante 20ms para que se vea 
            //el movimiento del agente más lentamente
            try { Thread.sleep(20); } catch (Exception e) {};
        }
        
    }

    //Metodo de entrada del programa que solo crea una nueva ventana principal
    public static void main (String[] args){
            
            new VentanaPrincipal();
            
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonSetup;
    private java.awt.Canvas canvasPanel;
    private javax.swing.JSpinner finXSpin;
    private javax.swing.JSpinner finYSpin;
    private javax.swing.JSpinner inicioXSpin;
    private javax.swing.JSpinner inicioYSpin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JSlider obstSlider;
    // End of variables declaration//GEN-END:variables

    
    //Metodo para controlar los listeners de los botones de la UI
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object o = e.getSource(); //Para identificar que boton fue el que produjo el evento
        
        if ( o == botonSetup)
            this.setupEntorno();
        
        else
            this.runAlgoritmo();
        
          }
}