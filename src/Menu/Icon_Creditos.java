package Menu;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * Clase Icon_Creditos es el icono de los personajes uniendo un rompecabezas en el boton Creditos
 * @author Luis Uzcategui y Luis Torres
 */
public class Icon_Creditos implements Icon{
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {        
        Image credito = new ImageIcon(getClass().getResource("/Imagenes/Menu/Credito_Icon.jpg")).getImage();
        g.drawImage(credito, x, y, c);        
    }
    @Override
    public int getIconWidth() {      
        return 50;        
    }

    @Override
    public int getIconHeight() {    
        return 50;        
    }    
}
