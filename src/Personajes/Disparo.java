package Personajes;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Disparo {    
    public int x, y;
    public Image misil;
    
    public Disparo(){        
        x = -100;
        y = -100;        
        try {            
            misil = ImageIO.read( new File("src/Imagenes/Personaje/misil1.png"));            
        } catch (IOException e) {            
            System.out.println("La Imagen no se encontro...");            
        }        
    }
    
    public Rectangle2D area(){        
        return new Rectangle2D.Double(x, y, misil.getWidth(null), misil.getHeight(null));        
    }    
}
