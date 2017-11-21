package Motor;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Menu.*;
import Personajes.Jugador;
import Sonidos.Sfx;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//----------//fdghdf
public class Juego extends JFrame{
    Panel p;
    Random num, n;
    Timer t1, tiempo;
    Lienzo pantalla;
    int aux=0;
    int cont=0;
    int b = -1;
    Sfx sonido;
    ActionListener movimiento_enemigo;
    KeyListener comandos; 
    Menu m;
    Image logo;

    public Juego(){
        sonido=new Sfx();
        pantalla = new Lienzo();
        tiempo = new Timer(1000,time);        
    }
   
    public void iniciar(){ 
        try {            
            logo = ImageIO.read(new File("src/Imagenes/Menu/logo.png"));            
        } catch (IOException e) {            
            System.out.println("No se Encontro la Imagen...");            
        }
        super.setIconImage(logo);
        cargar_eventos();
        cargarPared();
        t1 = new Timer(pantalla.tdt, movimiento_enemigo);
        super.setFocusable(true);
        super.setTitle("River Raid");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(0, 0, 1000, 700);
        super.setLocationRelativeTo(null);
        super.setContentPane(new JPanel( new BorderLayout()));
        super.setResizable(false);
        super.add(pantalla, BorderLayout.CENTER);
        super.setVisible(true);
        super.addKeyListener(comandos);
        t1.start();
        tiempo.start();        
    }
    
    public void cargarPared(){
        Random randpared=new Random();
        for (int i = 1; i < 350; i++) {            
            pantalla.paredi[i].x=randpared.nextInt(250)-450;
            pantalla.paredi[i].y=(int)pantalla.paredi[i-1].area().getCenterY()-(int)pantalla.paredi[0].area().getHeight();
        }
        for (int j = 1; j < 350; j++) {
            pantalla.paredd[j].x=randpared.nextInt(250)+650;
            pantalla.paredd[j].y=(int)pantalla.paredd[j-1].area().getCenterY()-(int)pantalla.paredd[0].area().getHeight();     
        }
                       
        }
    
    public void cargar_eventos(){        
        movimiento_enemigo = new ActionListener(){       
        @Override
        public void actionPerformed(ActionEvent e) {
            cont++;
            pantalla.gasoil.y += pantalla.mov;
            pantalla.enemigo1.y += pantalla.mov;
            pantalla.enemigo1.x = pantalla.enemigo1.x + pantalla.mov * b ;
            pantalla.bala.y -= pantalla.mov;
            pantalla.rio.y+=pantalla.mov;
            pantalla.bum.y+=pantalla.mov;
            pantalla.obs_c.y+=pantalla.mov;
            for (int i = 0; i < 350; i++) {
                pantalla.paredi[i].y+=pantalla.mov;
                pantalla.paredd[i].y+=pantalla.mov;
            }
            num=new Random();
            repaint();            
            if( pantalla.jugador.area().intersects(pantalla.enemigo1.area())){  
                pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               pantalla.enemigo1.y=1100;
                               cont = 1;
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex){}
            }            
            if( pantalla.jugador.area().intersects(pantalla.obs_c.area())){                
                pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               pantalla.obs_c.y=1100;
                                cont = 1;
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex) {}               
            }
            
            if( pantalla.jugador.area().intersects(pantalla.gasoil.area())){
                pantalla.gasoil.y = 1100;
                pantalla.jugador.cant_gasoil += 20;
                pantalla.jugador.puntaje += 50;
                      try {
                    sonido.sonido(sonido.gas);
                } catch (IOException ex) {}
            }
            
            if (pantalla.bala.area().intersects(pantalla.enemigo1.area())){
                try {
                    sonido.sonido(sonido.explosion);
                }catch (IOException ex) {}
                pantalla.bum.x = (int)(pantalla.enemigo1.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.enemigo1.area().getCenterY()- pantalla.bum.area().getHeight()/2);
                pantalla.enemigo1.y = 1100;
                pantalla.bala.y = -20;
                cont=1;
                pantalla.jugador.puntaje += 100;
            }
            
            if (pantalla.bala.area().intersects(pantalla.gasoil.area())){
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex) {}
                pantalla.bum.x = (int)(pantalla.enemigo1.area().getCenterX()- pantalla.gasoil.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.enemigo1.area().getCenterY()- pantalla.gasoil.area().getHeight()/2);
                pantalla.gasoil.y = 1100;
                pantalla.bala.y = -20;
                cont=1;
                pantalla.jugador.puntaje -= 100;
            }
            
            if(pantalla.bala.area().intersects(pantalla.obs_c.area())){
                pantalla.bala.y = -20;
            }
            
            if(cont%5==0){
                pantalla.bum.y= 1100;
            }  
            
            if (pantalla.enemigo1.y > 850){                
                pantalla.enemigo1.x = num.nextInt(800);
                pantalla.enemigo1.y = 0;
            }
            
            if (pantalla.obs_c.y > 850){                
                pantalla.obs_c.x = num.nextInt(800);
                pantalla.obs_c.y =-500;
            }
            
            if (pantalla.rio.y>=-10 || pantalla.jugador.cant_gasoil <= 0){
                tiempo.stop();
                JOptionPane.showMessageDialog(null,"Termino el Juego");
                JOptionPane.showMessageDialog(null,"Su gasolina quedo en: " + pantalla.jugador.cant_gasoil);
                JOptionPane.showMessageDialog(null,"Su puntaje fue: " + pantalla.jugador.puntaje);
                System.exit(0);
            }
            
            if (pantalla.enemigo1.area().getMinX()<=1 || pantalla.enemigo1.area().getMaxX() >= pantalla.getWidth()){
                b=b*(-1);
            }
            
            for (int i = 0; i < 350; i++) {
                
                if(pantalla.enemigo1.area().intersects(pantalla.paredd[i].area())  || pantalla.enemigo1.area().intersects(pantalla.paredi[i].area())){
                    
                    b = b / -1;
                }
            }    
            repaint();            
        }
    };
    
    comandos = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {            
        }
        @Override
        public void keyPressed(KeyEvent e) {            
            if(e.getKeyCode() == KeyEvent.VK_LEFT && pantalla.jugador.x>=20){                
                pantalla.jugador.x -= 20;                
            }            
            if(e.getKeyCode() == KeyEvent.VK_RIGHT && pantalla.jugador.x<=920){                
                pantalla.jugador.x += 20;                
            }            
            if(e.getKeyCode() == KeyEvent.VK_ENTER||e.getKeyCode() == KeyEvent.VK_SPACE ){ 
                if(pantalla.bala.y<=0){
                    try {
                        sonido.sonido(sonido.disparo);
                    } catch (IOException ex) {
                        Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int auxn= (int) pantalla.jugador.area().getCenterX();
                    int auxb =(int) pantalla.bala.area().getWidth()/2;
                    pantalla.bala.x = auxn - auxb ;
                    pantalla.bala.y = pantalla.jugador.y;     
                }
            }            
            if(e.getKeyCode() == KeyEvent.VK_UP){
                pantalla.tdt=10;
                pantalla.mov=30; 
                pantalla.jugador.nave = pantalla.jugador.naveacel;
            }            
            repaint();            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                pantalla.tdt=25;
                pantalla.mov=15;  
                pantalla.jugador.nave = new Jugador().nave;
            }
        }         
    };
    }

    ActionListener time = new ActionListener(){        
        public void actionPerformed(ActionEvent e) { 
            aux++;
            String aux2 = Integer.toString(aux);            
            System.out.println("00:"+aux2);
            if(aux %5 == 0){ // aparece gasolina cada 5 segundos
                int band=0;
                for (int i = 0; i < 350; i++) {
                    pantalla.gasoil.x = num.nextInt(700);
                        pantalla.gasoil.y = 0;
                    while(pantalla.paredd[i].area().contains(pantalla.gasoil.area()) || pantalla.paredi[i].area().contains(pantalla.gasoil.area())){
                        pantalla.gasoil.x = num.nextInt(700);
                        pantalla.gasoil.y = 0;

                    }
                }
  
            }
            if(aux %3 == 0){ // disminuye gasolina cada 3 seguntos
                pantalla.jugador.cant_gasoil -=0;
            }
        }
    }; 
 
    public void cerrar(){
        System.exit(0);        
    }

//    public static void main(String[] args) {
//        Juego obj = new Juego();
//        
//   }
    
}
