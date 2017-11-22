package Menu;

import Motor.Juego;
import Sonidos.Sfx;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**Declaracion de la Clase Menu que Hera de JFrame
 * 
 * @author Luis Uzcategui y Luis Torres
 */

public class Menu extends JFrame{    
    Panel panel = new Panel();
    Sfx sonido = new Sfx();
    Image logo;
    
    /**Creacion del Constructor de la clase Menu
     * 
     */
    public Menu(){        
        panel.iniciar();
        iniciar(); 
    }
    
    /**Metodo Iniciar, carga el menu del juego
     * 
     */ 
    public void iniciar(){
        try {            
            logo = ImageIO.read(new File("src/Imagenes/Menu/logo.png"));            
        } catch (IOException e) {            
            System.out.println("No se Encontro la Imagen...");            
        }
        super.setIconImage(logo);
        super.setTitle("Menu del Juego");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(0, 0, 1000, 700);
        super.setLocationRelativeTo(null);
        super.setContentPane(panel);
        super.setResizable(false);
        super.setLayout(new GridLayout(11,1));
        sonido.sonido_continuo(sonido.menu);
        super.setVisible(true);
    }
    
    /**Creacion del Main Principal
     * 
     * @param args 
     */
    public static void main(String[] args) {        
        Menu obj = new Menu();
    }
    
}
