/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    private boolean configurado = false;
    private final String nombre = "Inteligencia Artificial";
    private static Map map;
    private BufferStrategy strategy;
    private MouseListener mouseListen;

    public VentanaPrincipal() {
        
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(nombre);
        ImageIcon icono = new ImageIcon("res/safari.png");
        setIconImage(icono.getImage());
        this.setSize(1024,800);
        setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.setCanvasPanel();
        botonSetup.addActionListener(this);
        botonIniciar.addActionListener(this);
     
        configurado = false;
        
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        obstSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        columnasSpinner = new javax.swing.JSpinner();
        filasSpinner = new javax.swing.JSpinner();
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

        jLabel1.setText("Columnas");

        jLabel2.setText("Filas");

        obstSlider.setValue(0);

        jLabel3.setText("Porcentaje Obstaculos");

        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        columnasSpinner.setValue(47);

        filasSpinner.setValue(66);

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
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(filasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(columnasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
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
                                .addComponent(jLabel1)
                                .addComponent(columnasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(finYSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(finXSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(inicioYSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inicioXSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(filasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        canvasPanel.setBackground(Color.white);
        canvasPanel.createBufferStrategy(2);
        strategy = canvasPanel.getBufferStrategy();
        
         }

    private void pintarEntorno(Map map){
          
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
           
        //Reseteamos el marco
            g.setColor(Color.white);
            g.fillRect(0,0,canvasPanel.getWidth(),canvasPanel.getHeight());
        
        
            map.pintarMapa(g);
            g.dispose();
            strategy.show();      
    }
    
  
    private void setupEntorno(){
        

            // Creamos el mapa
            if (map != null)
                map.resetMapa();
            
            configurado = false;
            int inicioX,inicioY, finX,finY;
        
            inicioX = (int)inicioXSpin.getValue();
            inicioY = (int)inicioYSpin.getValue();
            finX = (int)finXSpin.getValue();
            finY = (int) finYSpin.getValue();
            int porcentaje;
            int x = (int) filasSpinner.getValue(); 
            int y = (int)columnasSpinner.getValue();
            porcentaje = ((x*y)*obstSlider.getValue())/100; 
            
            try {
              
                if(inicioX >= x || inicioX < 0)
                    throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if (inicioY >= y || inicioY < 0)
                      throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if (finX >= x || finX < 0)
                      throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if (finY >= y || finY <0)
                      throw new ExcepcionesPersonales("SE HA SALIDO DEL RANGO");
                
                if ( x <= 0)
                    throw new ExcepcionesPersonales("No pueden haber 0 filas");
                
                if (y <= 0)
                    throw new ExcepcionesPersonales("No pueden haber 0 columnas");
                
            }catch (Exception e){
            
                JOptionPane.showMessageDialog(this,e.getMessage());

            }
                        
            map = new Map(x,y,inicioX,inicioY,finX,finY,porcentaje);
            pintarEntorno(map);  
            configurado = true;
           
     
    }
    
    private void runAlgoritmo(){
        
      try{
           if (configurado == false)
               throw new ExcepcionesPersonales("PRIMERO CONFIGURE EL ENTORNO");          
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, e.getMessage());
      }
      
      
      AlgoritmoAEstrella AEstrella = new AlgoritmoAEstrella(map,map.getInicio(),map.getFin());
      System.out.println("Se han ejecutado: " + AEstrella.getIteraciones() + " iteraciones\n");
      Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
    
      try {
          
         ArrayList<NodoMapa> solucion = AEstrella.calcularSendero();
        
        if( solucion == null){
            throw new ExcepcionesPersonales("No hay solución");
           
        }
        else{
            System.out.println("Tenemos la solucion");
            System.out.println();
            System.out.println(solucion);
            System.out.println("Se han ejecutado: " + AEstrella.getIteraciones() + " iteraciones");
        }
        
        
              
      }catch(Exception e){
          
          JOptionPane.showMessageDialog(this, e.getMessage());
      }
             
    }

    public static void main (String[] args){
            
            new VentanaPrincipal();
            
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonSetup;
    private java.awt.Canvas canvasPanel;
    private javax.swing.JSpinner columnasSpinner;
    private javax.swing.JSpinner filasSpinner;
    private javax.swing.JSpinner finXSpin;
    private javax.swing.JSpinner finYSpin;
    private javax.swing.JSpinner inicioXSpin;
    private javax.swing.JSpinner inicioYSpin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JSlider obstSlider;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object o = e.getSource(); //Para identificar que boton fue el que produjo el evento
        
        if ( o == botonSetup)
            this.setupEntorno();
        
        else
            this.runAlgoritmo();
        
          }
}