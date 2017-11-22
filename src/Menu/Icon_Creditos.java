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
        Image credito = new ImageIcon(getClass().getResource("/Imagenes/Menu/Credito_Icon.jpg")).getImage();
        g.drawImage(credito, x, y, c);        
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
