package Motor;
import Personajes.*;
import Principal.*;
import Obstaculo.*;
import Sonidos.Sfx;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Lienzo extends JPanel{
    
    public Enemigo enemigo1;
    public Jugador jugador;
    public Disparo bala;
    public Explosion bum; 
    public Mapa rio;
    public int tdt;
    public int mov;
    public Combustible gasoil;
    Terreno obs_c;
    public ParedIzq []paredi=new ParedIzq[350]; 
    public ParedDer []paredd=new ParedDer[350];  
    
    public Lienzo(){
        for (int i = 0; i < 350; i++) {
            paredi[i]=new ParedIzq();
            paredd[i]=new ParedDer();
        }                
        tdt=30;
        mov=10;
        obs_c= new Terreno();
        enemigo1 = new Enemigo();
        jugador = new Jugador();
        bala = new Disparo();
        bum = new Explosion();
        rio=new Mapa();
        gasoil = new Combustible();
        jugador.x = 300;
        jugador.y = 495;
        bala.x = -1000;
        bala.y = -1000;
        
    }

    @Override
    protected void paintComponent(Graphics g) {        
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.        
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(rio.map, rio.x, rio.y, this);
        for (int i = 349; i>=0; i--) {
        g2.drawImage(paredi[i].ob, paredi[i].x, paredi[i].y, this);
        g2.drawImage(paredd[i].ob, paredd[i].x, paredd[i].y, this);
        }
        g2.drawImage(enemigo1.enemigo, enemigo1.x, enemigo1.y, this);
        g2.drawImage(gasoil.img, gasoil.x, gasoil.y, this);
        g2.drawImage(jugador.nave, jugador.x, jugador.y, this);
        
        g2.drawImage(bala.misil, bala.x, bala.y, this);
        g2.drawImage(bum.explosion, bum.x, bum.y, this);        
        g2.drawImage(obs_c.ob, obs_c.x, obs_c.y, this);
        g2.drawImage(obs_c.ob, obs_c.x, obs_c.y, this);
    }   
    
}
