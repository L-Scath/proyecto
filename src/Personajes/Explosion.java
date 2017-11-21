package Personajes;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Explosion {    
    public int x, y;
    public Image explosion;
    
    public Explosion(){        
        x = 1100;
        y = 700;        
        try {            
            explosion = ImageIO.read(new File("src/Imagenes/Npc/explosion2.png"));            
        } catch (IOException e) {            
            System.out.println("La Imagen no se encontro...");            
        }        
    }
    
    public Rectangle2D area(){        
        return new Rectangle2D.Double(x, y, explosion.getWidth(null), explosion.getHeight(null));        
    }    
}
