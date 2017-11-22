package Menu;

import Motor.Juego;
import Personajes.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Sonidos.*;
import java.awt.Button;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**Declaracion de la Clase Panel que Hereda un JPanel
 * 
 * @author Luis Uzcategui y Luis Torres
 */

public class Panel extends JPanel{
    Image fond;
    Botones botones;
    String como_jugar = "Movimiento del Avion:\n\n-Derecha:    Flecha Derecha ( > )\n-Izquierda:   Flecha Izquierda ( < )\n-Acelerar:    Flecha Arriba ( ^ )\n-Disparar:    Enter" ;
    String elaborado_por = "Realizado por:\nLuis Torres CI : 26723334          seccion: 01(Prof. Yeniffer Peña) \nLuis Uzcategui CI : 25727657    seccion: 01(Prof. Yeniffer Peña)";
    int seleccion = 0;
    public String nombre;
    public String nombres[] = new String[100];
    public String puntos[] = new String[100];
    Juego j;
    JButton []espacioenblanco=new JButton[5];
    
    /**Creacion del Constructor del Panel
     * 
     */
    public Panel(){
        
    }
    /**Metodo Iniciar, se crea un nuevo juego, se agregan los botones y se llama al metodo Eventos. 
     * 
     */
    public void iniciar(){
        
        j = new Juego();
        try{
         fond = ImageIO.read(new File("src/Imagenes/Menu/fondM.png"));
        }catch(IOException e){}
        super.setFocusable(true);
        super.setBackground(Color.WHITE);
        for(int i=0;i<5;i++){
            espacioenblanco[i]=new JButton();
            super.add(espacioenblanco[i]);
            espacioenblanco[i].setVisible(false);
        }                
        botones = new Botones();
        botones.jugar.setBounds(botones.x,botones.y +(botones.jugar.getHeight()*0),botones.jugar.getWidth(),botones.jugar.getHeight());
        super.add(botones.jugar);
        botones.top.setBounds(botones.x,botones.y +(botones.top.getHeight() *1), botones.top.getWidth(), botones.top.getHeight());
        super.add(botones.top);
        botones.ayuda.setBounds(botones.x, botones.y + (botones.ayuda.getHeight() * 2), botones.ayuda.getWidth(), botones.ayuda.getHeight());
        super.add(botones.ayuda);
        botones.creditos.setBounds(botones.x, botones.y + (botones.creditos.getHeight() * 3), botones.creditos.getWidth(), botones.creditos.getHeight());
        super.add(botones.creditos);
        botones.salir.setBounds(botones.x, botones.y + (botones.salir.getHeight() * 4), botones.salir.getWidth(), botones.salir.getHeight());
        super.add(botones.salir);
        eventos();
        repaint();
        
    }
    
    /**Metodo Evento, es donde se capturan los eventos del menu principal
     * 
     */ 
    public void eventos(){
        botones.jugar.addMouseListener(new MouseAdapter(){  
            int auxselec=0;
            public void mouseEntered(MouseEvent e){                
                botones.band = 2;
                botones.jugar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Jugar" + botones.band +".png")));
            }
            public void mouseExited(MouseEvent e){                
                botones.band = 1;
                botones.jugar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Jugar" + botones.band +".png")));
            }
            public void mouseClicked(MouseEvent e) {
                nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
                try {
                            
                            File archivo = new File("Usuarios.txt");
                            FileWriter fw = new FileWriter(archivo,true);                      
                            BufferedWriter bw = new BufferedWriter(fw);
                            
                            fw.append(nombre + ";");
                            fw.close();//cierro
                            
                            
                            
                        } catch (IOException ex) {
                            
                            System.out.println("Error en escritura de archivo...");
                            
                        }
                
                j.iniciar();
                
            }
            
        } );
        
        botones.top.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                botones.band = 2;
                botones.top.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Top" + botones.band +".png")));
            }
            public void mouseExited(MouseEvent e){
                botones.band = 1;
                botones.top.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Top" + botones.band +".png")));
            }
            public void mouseClicked(MouseEvent e) {
                Icono_Top trofeo = new Icono_Top();
                JOptionPane.showOptionDialog(null, " ", "Top 10", JOptionPane.OK_OPTION, JOptionPane.DEFAULT_OPTION, trofeo, new Object[] {"Regresar"}, "Regresar");
            }
        } );
        
        botones.ayuda.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                botones.band = 2;
                botones.ayuda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Ayuda" + botones.band +".png")));
            }
            public void mouseExited(MouseEvent e){
                botones.band = 1;
                botones.ayuda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Ayuda" + botones.band +".png")));
                
            }
            public void mouseClicked(MouseEvent e) {
                Icon_Ayuda interrogacion = new Icon_Ayuda();
                JOptionPane.showOptionDialog(null, como_jugar, "Como Jugar", JOptionPane.OK_OPTION, JOptionPane.DEFAULT_OPTION, interrogacion, new Object[] {"Regresar"}, "Regresar");
            }
        } );
        
        botones.creditos.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                botones.band = 2;
                botones.creditos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Creditos" + botones.band +".png")));
            }
            public void mouseExited(MouseEvent e){
                botones.band = 1;
                botones.creditos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Creditos" + botones.band +".png")));
            }
            public void mouseClicked(MouseEvent e) {                
                Icon_Creditos credito = new Icon_Creditos();
                JOptionPane.showOptionDialog(null, elaborado_por, "Elaborado por ", JOptionPane.OK_OPTION, JOptionPane.DEFAULT_OPTION, credito, new Object[] {"Regresar"}, "Regresar");
            }
            
        } );        
        
        botones.salir.addMouseListener(new MouseAdapter(){            
            public void mouseEntered(MouseEvent e){               
                botones.band = 2;
                botones.salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Salir" + botones.band +".png")));                
            }
            public void mouseExited(MouseEvent e){                
                botones.band = 1;
                botones.salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Menu/Salir" + botones.band +".png")));                
            }            
            public void mouseClicked(MouseEvent e) {                
                System.exit(0);           
            }            
        } );        
    }
    
    /**Metodo ordenar, guarda los puntos y nombres respectivamente de cada usuario que ingreso
     * para luego generar el top 10.
     */ 
    public void ordenar(){
        try {
                            
                            FileReader archivo = new FileReader("Registros.txt");//busco el archivo
                            Scanner entrada = new Scanner(archivo);
                            
                            String Linea;
                            int i = 0;
                            
                            while(entrada.hasNextLine()){//ciclo mientras se encuentre una nueva linea
                                
                                Linea = entrada.nextLine();//se posiciona en la siguiente linea del archivo
                                String vec[] = Linea.split("-");//en esa linea guardo todo en un vector cada vez que se encuentre un -
                                nombres[i] = vec[0];//añado el primer elemento del vector a otro vector
                                puntos[i] = vec[1];//añado el segundo elemento del vector a otro vector
                                i++;//aumento la posicion de los vectores auxiliares
                                
                            }
                            
                            
                        } catch (FileNotFoundException e) {
                            
                            System.out.println("No se encontró el archivo...");
                            
                        }
        
    }
    
    /**Metodo paintComponent, en donde se pintan las imagenes
     * 
     * @param g 
     */
    protected void paintComponent(Graphics g) {        
        super.paintComponent(g);         
        Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(this.fond,0,0,this);
    }
 
}
