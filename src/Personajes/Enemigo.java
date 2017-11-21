package Personajes;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Enemigo {    
    public int x, y;
    public Image enemigo;
    public Random n = new Random();
    
    public Enemigo(){        
        x = n.nextInt(400)+250 ;
        y = 0;        
        try{            
            enemigo = ImageIO.read( new File("src/Imagenes/Npc/enemigo1.png"));            
        } catch (IOException e){            
            System.out.println("La Imagen no se Encontró...");            
        }        
    }
    
    public Rectangle2D area(){        
       return new Rectangle2D.Double(x, y, enemigo.getWidth(null), enemigo.getHeight(null));        
    }    
}
