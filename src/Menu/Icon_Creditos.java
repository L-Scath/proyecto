package Menu;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
