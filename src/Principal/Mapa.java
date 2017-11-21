package Principal;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

    public class Mapa {    
    public int x, y;
    public Image map;
    
    public Mapa(){        
        x = 0;
        y = -14349;        
        try{            
            map = ImageIO.read( new File("src/Imagenes/Nivel/allStages.png"));            
        } catch (IOException e){            
            System.out.println("La Imagen no se Encontró...");            
        }        
    }    
}
