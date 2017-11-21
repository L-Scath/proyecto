package Menu;

import Motor.Juego;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Panel extends JPanel{
    Image fond;
    Botones botones;
    String como_jugar = "Movimiento del Avion:\n\n-Derecha:    Flecha Derecha ( > )\n-Izquierda:   Flecha Izquierda ( < )\n-Acelerar:    Flecha Arriba ( ^ )\n-Disparar:    Enter" ;
    String elaborado_por = "El siguiente juego esta basado\nen el clasico juego de Atari\nRiver Raid, esta es una version\nno oficial de dicho juego con algunos\ncambios en el entorno grafico, pero\ncon la misma logica del juego principal.";
    int seleccion = 0;
    Juego j;
    JButton []espacioenblanco=new JButton[5];
    
    public Panel(){
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
                JOptionPane.showOptionDialog(null, "Luis Torres 150.000", "Top 10", JOptionPane.OK_OPTION, JOptionPane.DEFAULT_OPTION, trofeo, new Object[] {"Regresar"}, "Regresar");
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
    
    
    
    public int validacion(){    
        System.out.println(seleccion);
        if(seleccion ==1 ){
            System.out.println("SDFSDFSDF");
            return 1;             
        }
        else{            
            return 0;            
        }        
    }
    
        protected void paintComponent(Graphics g) {        
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.        
        Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(this.fond,0,0,this);
    }
 
}
