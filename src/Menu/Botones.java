package Menu;
import java.io.File;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
*Clase Botones, contiene los botones que se usan en el menu Principal
*@author Luis Uzcategui y Luis Torres
*/
public class Botones {

    int x, y, band, seleccion;
    JLabel jugar, creditos, ayuda, salir, top;
    
    public Botones(){        
        x = 20;
        y = 25;
        band = 1;
        seleccion = 0;        
        jugar = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Menu/Jugar" + band +".png")));
        top = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Menu/Top" + band +".png")));
        ayuda = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Menu/Ayuda" + band +".png")));
        creditos = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Menu/Creditos" + band +".png")));
        salir = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Menu/Salir" + band +".png")));
    }
}
