package Menu;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * Clase Icono_Top es el icono del Trofeo en el boton Top 10
 * @author Luis Uzcategui y Luis Torres
 */
public class Icono_Top implements Icon{
    
    /**Metodo paintIcon, donde genera una Imagen la cual reemplazara el Icono por defecto de un Cuadro de Texto Grafico.
     * 
     * @param c
     * @param g
     * @param x
     * @param y
     * 
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {        
        Image trofeo = new ImageIcon(getClass().getResource("/Imagenes/Menu/Top_Icon.png")).getImage();
        g.drawImage(trofeo, x, y, c);        
    }
    
    /**Metodo getIconWidth.
     * 
     * @return, retorna el ancho qe tendra la imagen a utilizar.
     * 
     */
    @Override
    public int getIconWidth() {        
        return 50;        
    }
    
    /**Metodo getIconHeight.
     * 
     * @return, retorna el alto que tendra la imagen a utilizar. 
     * 
     */
    @Override
    public int getIconHeight() {        
        return 50;        
    }   
}
