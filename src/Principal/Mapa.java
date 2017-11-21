package Principal;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

    public class Mapa {    
    public int x, y;
    public Image map;
    public Image barrav;
    public Image barraa;
    public Image barrar;  
    public Image vidas[]=new Image[4];
    public Mapa(){        
        x = 0;
        y = -14349;        
        try{            
            map = ImageIO.read( new File("src/Imagenes/Nivel/allStages.png"));
            barrav = ImageIO.read( new File("src/Imagenes/Nivel/verde-min.png"));
            barraa = ImageIO.read( new File("src/Imagenes/Nivel/rojo-min.png"));
            barrar = ImageIO.read( new File("src/Imagenes/Nivel/amarillo-min.png"));
            vidas[0] = ImageIO.read( new File("src/Imagenes/Nivel/0vidas-min.png"));
            vidas[1] = ImageIO.read( new File("src/Imagenes/Nivel/1vida-min.png"));
            vidas[2] = ImageIO.read( new File("src/Imagenes/Nivel/2vidas-min.png"));
            vidas[3] = ImageIO.read( new File("src/Imagenes/Nivel/3vidas-min.png"));
        } catch (IOException e){            
            System.out.println("La Imagen no se Encontró...");            
        }        
    }    
}
