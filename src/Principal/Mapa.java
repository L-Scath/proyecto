package Principal;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

    public class Mapa {    
    public int x, y,bargasx;
    public Image map;
    public Image barragas;
    public Image fondobarra;
    public Image vidas[]=new Image[4];
    public String tiempo;
    public Image score;
    public Mapa(){        
        x = 0;
        y = -14349;
        bargasx=400;
        tiempo= "00:";
 
        try{            
            map = ImageIO.read( new File("src/Imagenes/Nivel/allStages.png"));
            barragas = ImageIO.read( new File("src/Imagenes/Nivel/barragas.png"));
            fondobarra = ImageIO.read( new File("src/Imagenes/Nivel/fondobarra.png"));
            score = ImageIO.read( new File("src/Imagenes/Nivel/score.png"));
            vidas[0] = ImageIO.read( new File("src/Imagenes/Nivel/0vidas-min.png"));
            vidas[1] = ImageIO.read( new File("src/Imagenes/Nivel/1vida-min.png"));
            vidas[2] = ImageIO.read( new File("src/Imagenes/Nivel/2vidas-min.png"));
            vidas[3] = ImageIO.read( new File("src/Imagenes/Nivel/3vidas-min.png"));
        } catch (IOException e){            
            System.out.println("La Imagen no se Encontró...");            
        }        
    }    
}
