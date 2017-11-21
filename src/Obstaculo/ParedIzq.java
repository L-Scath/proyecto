package Obstaculo;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

    public class ParedIzq {
        
    public int x, y;
    public Image ob;
    public Random n = new Random();    
    public ParedIzq(){        
        x = -274 ;
        y = 400;
        
        try{
            
            ob = ImageIO.read( new File("src/Imagenes/Npc/Izq.png"));
            
        } catch (IOException e){            
            System.out.println("La Imagen no se Encontró...");            
        }            
        
    }
    
     public Rectangle2D area(){        
        return new Rectangle2D.Double(x, y, ob.getWidth(null), ob.getHeight(null));        
    }
    
    
}
