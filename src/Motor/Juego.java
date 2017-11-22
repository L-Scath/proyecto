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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**Declaracion de la clase Juego que Hereda un JFrame
 * 
 * @author Luis Uzcategui y Luis Torres
 */

public class Juego extends JFrame{
    Panel p;
    Random num, n;
    Timer t1, tiempo;
    Lienzo pantalla;
    int auxs=0;
    int auxm=0;
    int cont=0;
    int b1 = -1;
    int b2 = -1;
    int b3 = -1;
    Sfx sonido;
    ActionListener movimiento_enemigo;
    KeyListener comandos; 
    Menu m;
    Image logo;
    
    /**Creacion del Constructor de Juego en donde se instancean el sonido, la pantalla y el tiempo
     * 
     */
    public Juego(){
        sonido=new Sfx();
        pantalla = new Lienzo();
        tiempo = new Timer(1000,time);        
    }
   
    
    /**Metodo Iniciar,es donde empieza la parte 2 del proyecto en este caso el Juego en si
     * 
     */
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
        p = new Panel();
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
    
    /**Metodo CargarPared, es donde se crean las paredes derechas e izquierdas del juego
     * 
     */
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
    
    /**Metodo Cargar Eventos, es donde se capturan todos los eventos del juego, como: moverse y disparar
     * 
     */
    public void cargar_eventos(){        
        movimiento_enemigo = new ActionListener(){       
        @Override
        public void actionPerformed(ActionEvent e) {
            cont++;
            pantalla.rio.puntaje=Integer.toString(pantalla.jugador.puntaje);
            pantalla.gasoil.y += pantalla.mov;
            pantalla.enemigo1.y += pantalla.mov;
            pantalla.enemigo1.x += pantalla.mov*b1;
            pantalla.enemigo2.y += pantalla.mov;
            pantalla.enemigo2.x += pantalla.mov+25*b2;
            pantalla.enemigo3.y += pantalla.mov+10;
            pantalla.enemigo3.x += pantalla.mov*b3;
            pantalla.bala.y -= 30;
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
                               pantalla.jugador.x = 450;
                               cont = 1;
                               pantalla.jugador.vidas -= 1;
                                  pantalla.jugador.puntaje-=20;
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex){}
                vidas();
            } 
            if( pantalla.jugador.area().intersects(pantalla.enemigo2.area())){  
                pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               pantalla.enemigo2.y=1100;
                               pantalla.jugador.x = 450;
                               cont = 1;
                               pantalla.jugador.vidas -= 1;
                                  pantalla.jugador.puntaje-=20;
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex){}
                vidas();
            }
            if( pantalla.jugador.area().intersects(pantalla.enemigo3.area())){  
                pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               pantalla.enemigo3.y=1100;
                               pantalla.jugador.x = 450;
                               cont = 1;
                               pantalla.jugador.vidas -= 1;
                                  pantalla.jugador.puntaje-=20;
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex){}
                vidas();
            }             
            if( pantalla.jugador.area().intersects(pantalla.obs_c.area())){                
                pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               pantalla.obs_c.y += 200;
                               pantalla.jugador.x = 450;
                                cont = 1;
                                pantalla.jugador.vidas -= 1;
                                pantalla.jugador.puntaje-=20;
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex) {} 
                vidas();
            }
            
            if( pantalla.jugador.area().intersects(pantalla.gasoil.area())){
                pantalla.gasoil.y = 1100;
                pantalla.jugador.cant_gasoil = 100;
                pantalla.jugador.puntaje += 10;
                      try {
                    sonido.sonido(sonido.gas);
                } catch (IOException ex) {}
                      pantalla.rio.bargasx=400;
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
                pantalla.jugador.puntaje += 50;
            }
            if (pantalla.bala.area().intersects(pantalla.enemigo2.area())){
                try {
                    sonido.sonido(sonido.explosion);
                }catch (IOException ex) {}
                pantalla.bum.x = (int)(pantalla.enemigo2.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.enemigo2.area().getCenterY()- pantalla.bum.area().getHeight()/2);
                pantalla.enemigo2.y = 1100;
                pantalla.bala.y = -20;
                cont=1;
                pantalla.jugador.puntaje += 50;
            }
                        if (pantalla.bala.area().intersects(pantalla.enemigo3.area())){
                try {
                    sonido.sonido(sonido.explosion);
                }catch (IOException ex) {}
                pantalla.bum.x = (int)(pantalla.enemigo3.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.enemigo3.area().getCenterY()- pantalla.bum.area().getHeight()/2);
                pantalla.enemigo3.y = 1100;
                pantalla.bala.y = -20;
                cont=1;
                pantalla.jugador.puntaje += 50;
            }            
            if (pantalla.bala.area().intersects(pantalla.gasoil.area())){
                try {
                    sonido.sonido(sonido.explosion);
                } catch (IOException ex) {}
                pantalla.bum.x = (int)(pantalla.gasoil.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                pantalla.bum.y = (int)(pantalla.gasoil.area().getCenterY()- pantalla.bum.area().getHeight()/2);
                pantalla.gasoil.y = 1100;
                pantalla.bala.y = -20;
                cont=1;
                pantalla.jugador.puntaje -= 50;
            }
            
            if(pantalla.bala.area().intersects(pantalla.obs_c.area())){
                pantalla.bala.y = -20;                
            }
            
            if(cont%5==0){
                pantalla.bum.y= 1100;
            }  
            
            if (pantalla.enemigo1.y > 850){   
                pantalla.enemigo1.x = num.nextInt(800);
                pantalla.enemigo1.y = -10;
            }
            for (int i = 0; i < 350; i++) {
                if (pantalla.enemigo1.y<=0) {
                    if(pantalla.enemigo1.area().intersects(pantalla.paredd[i].area())||pantalla.enemigo1.area().intersects(pantalla.paredi[i].area()))
                        pantalla.enemigo1.x=num.nextInt(200)+250;
                }
            }
            
            if (pantalla.enemigo2.y > 850){   
                pantalla.enemigo2.x = num.nextInt(800);
                pantalla.enemigo2.y = -10;
            }
            for (int i = 0; i < 350; i++) {
                if (pantalla.enemigo2.y<=0) {
                    if(pantalla.enemigo2.area().intersects(pantalla.paredd[i].area())||pantalla.enemigo2.area().intersects(pantalla.paredi[i].area()))
                        pantalla.enemigo2.x=num.nextInt(200)+250;
                }
            }
            if (pantalla.enemigo3.y > 850){   
                pantalla.enemigo3.x = num.nextInt(800);
                pantalla.enemigo3.y = -10;
            }
            for (int i = 0; i < 350; i++) {
                if (pantalla.enemigo3.y<=0) {
                    if(pantalla.enemigo3.area().intersects(pantalla.paredd[i].area())||pantalla.enemigo3.area().intersects(pantalla.paredi[i].area()))
                        pantalla.enemigo3.x=num.nextInt(200)+250;
                }
            }            
            
            for (int i = 0; i < 350; i++) {
                
                    if(pantalla.jugador.area().intersects(pantalla.paredd[i].area())){
                        pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                        pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               cont = 1;
                               pantalla.jugador.vidas -= 1;
                               pantalla.jugador.x = 450;
                               pantalla.jugador.puntaje-=25;
                               vidas();
                    }
                    if(pantalla.jugador.area().intersects(pantalla.paredi[i].area())){
                        pantalla.bum.x = (int)(pantalla.jugador.area().getCenterX()- pantalla.bum.area().getWidth()/2);
                        pantalla.bum.y = (int)(pantalla.jugador.area().getCenterY()- pantalla.bum.area().getHeight()/2); ;
                               cont = 1;
                               pantalla.jugador.vidas -= 1;
                               pantalla.jugador.x = 450;
                               pantalla.jugador.puntaje-=25;
                               vidas();
                        
                    }    
                
            }
            
            if (pantalla.obs_c.y > 850){                
                pantalla.obs_c.x = num.nextInt(800);
                pantalla.obs_c.y =-500;
            }
            
            if (pantalla.rio.y>=-10 || pantalla.jugador.cant_gasoil <= 0){
                tiempo.stop();
                JOptionPane.showMessageDialog(null,"Perdio una vida");
                JOptionPane.showMessageDialog(null,"Su gasolina quedo en:0");
                pantalla.jugador.cant_gasoil = 100;
                pantalla.jugador.vidas--;
                pantalla.rio.bargasx=400;
            }
            
            if (pantalla.enemigo1.area().getMinX()<=1 || pantalla.enemigo1.area().getMaxX() >= pantalla.getWidth()){
                b1=b1*(-1);
            }            
            for (int i = 0; i < 350; i++) {                
                if(pantalla.enemigo1.area().intersects(pantalla.paredd[i].area())||pantalla.enemigo1.area().intersects(pantalla.paredi[i].area())){
                    b1=b1*(-1);
                }
            }
            if (pantalla.enemigo2.area().getMinX()<=1 || pantalla.enemigo2.area().getMaxX() >= pantalla.getWidth()){
                b2=b2*(-1);
            }            
            for (int i = 0; i < 350; i++) {                
                if(pantalla.enemigo2.area().intersects(pantalla.paredd[i].area())||pantalla.enemigo2.area().intersects(pantalla.paredi[i].area())){
                    b2=b2*(-1);
                }
            }
            if (pantalla.enemigo3.area().getMinX()<=1 || pantalla.enemigo3.area().getMaxX() >= pantalla.getWidth()){
                b3=b3*(-1);
            }            
            for (int i = 0; i < 350; i++) {                
                if(pantalla.enemigo3.area().intersects(pantalla.paredd[i].area())||pantalla.enemigo3.area().intersects(pantalla.paredi[i].area())){
                    b3=b3*(-1);
                }
            }            
            
            if(pantalla.jugador.vidas == 0){
                tiempo.stop();
                JOptionPane.showMessageDialog(null,"Termino el Juego, Ha perdido todas sus vidas\nSu puntaje Fue : " + pantalla.jugador.puntaje);
                top_10();
                System.exit(0);  
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
                pantalla.mov=18; 
                pantalla.jugador.nave = pantalla.jugador.naveacel;
            }            
            repaint();            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                pantalla.tdt=25;
                pantalla.mov=9;  
                pantalla.jugador.nave = new Jugador().nave;
            }
        }         
    };
    }

    ActionListener time = new ActionListener(){        
        public void actionPerformed(ActionEvent e) { 
            auxs++;
            if(auxs==60){
                auxs=0;
                auxm=01;
            }
            pantalla.rio.tiempo=("0"+auxm+":"+auxs);
            if(auxs %5 == 0){ // aparece gasolina cada 5 segundos
                int band=0;
                for (int i = 0; i < 350; i++) {
                    pantalla.gasoil.x = num.nextInt(400)+250;
                        pantalla.gasoil.y = 0;
                    if(pantalla.paredd[i].area().contains(pantalla.gasoil.area()) || pantalla.paredi[i].area().contains(pantalla.gasoil.area())){
                        pantalla.gasoil.x = num.nextInt(400+250);
                        pantalla.gasoil.y = 0;
                    }
                    if(pantalla.paredd[i].area().contains(pantalla.enemigo1.area()) || pantalla.paredi[i].area().contains(pantalla.enemigo1.area())){
                        pantalla.enemigo1.x = num.nextInt(400)+250;
                        pantalla.enemigo1.y = 0;
                    }
                    if(pantalla.paredd[i].area().contains(pantalla.enemigo2.area()) || pantalla.paredi[i].area().contains(pantalla.enemigo2.area())){
                        pantalla.enemigo2.x = num.nextInt(400)+250;
                        pantalla.enemigo2.y = 0;
                    }
                    if(pantalla.paredd[i].area().contains(pantalla.enemigo3.area()) || pantalla.paredi[i].area().contains(pantalla.enemigo3.area())){
                        pantalla.enemigo3.x = num.nextInt(400)+250;
                        pantalla.enemigo3.y = 0;
                    }                    
                }
  
            }
 // disminuye gasolina cada 3 seguntos
                pantalla.jugador.cant_gasoil -=07;
                pantalla.rio.bargasx-=20;

        }
    }; 
    /**Metodo Cerrar, cierra el proyecto como tal
     * 
     */
    public void cerrar(){
        System.exit(0);        
    }
    
    /**Metodo Vidas, es el metodo que se implementa luego de que pierde una vida
     * 
     */
    public void vidas(){
        tiempo.stop();
        pantalla.bum.x=445;
        if(pantalla.jugador.vidas != 0){
            JOptionPane.showMessageDialog(null,"Ha perdido una vida.");
        }
        pantalla.mov = 9;
        pantalla.enemigo1.y=-200;
        pantalla.enemigo2.y=-200;
        pantalla.enemigo3.y=-200;
        pantalla.obs_c.y=-200;
        t1.restart();
        tiempo.restart();
    }
   
    /**Metodo Top 10, guarga en un archivo (Usuarios) los puntos y el nombre del usuario actual.
     * 
     */
    public void top_10(){

                        try {                            
                            File archivo = new File("Usuarios.txt");
                            FileWriter fw = new FileWriter(archivo,true);                      
                            BufferedWriter bw = new BufferedWriter(fw);                            
                            fw.append(pantalla.jugador.puntaje + "\r\n");
                            fw.close();//cierro                            
                            bw.newLine();//creo una nueva linea                            
                        } catch (IOException e) {
                            
                            System.out.println("Error en escritura de archivo...");
                            
                        }
        
    }

}    
