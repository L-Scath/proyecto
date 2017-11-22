package Personajes;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Enemigo2 {    
    public int x, y;
    public Image enemigo;
    public Random n = new Random();
    
    public Enemigo2(){        
        x = n.nextInt(200)+250 ;
        y = -200;        
        try{            
            enemigo = ImageIO.read( new File("src/Imagenes/Npc/enemigo2.png"));            
        } catch (IOException e){            
            System.out.println("La Imagen no se Encontró...");            
        }        
    }
    
    public Rectangle2D area(){        
       return new Rectangle2D.Double(x, y, enemigo.getWidth(null), enemigo.getHeight(null));        
    }    
}
