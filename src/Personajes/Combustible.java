package Personajes;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Combustible {
    
    public int x, y;
    public Image img;
    public Random n = new Random();
    
    public Combustible(){
        
        x = n.nextInt(400)+300;
        y = 0;
        
        try {
            
            img = ImageIO.read(new File("src/Imagenes/Npc/gasolina.png"));
            
        } catch (IOException e) {
            
            System.out.println("La Imagen no se encontro..."); 
            
        }
        
    }
    
    public Rectangle2D area(){
        
        return new Rectangle2D.Double(x, y, img.getWidth(null), img.getHeight(null));
        
    }
    
}
