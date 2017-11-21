package Personajes;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Jugador {    
    public int x, y, vidas,cant_gasoil, puntaje;
    public Image nave,naveacel;  
    
    public Jugador(){        
        x = 0;
        y = 0;
        vidas=3;
        cant_gasoil = 100;
        puntaje = 0;
        try {            
            nave = ImageIO.read( new File("src/Imagenes/Personaje/nave1.gif"));            
        }catch (IOException e) {            
            System.out.println("La Imagen no se encontro...");            
        }  
                try {            
            naveacel = ImageIO.read( new File("src/Imagenes/Personaje/nave1 acel.gif"));            
        }catch (IOException e) {            
            System.out.println("La Imagen no se encontro...");            
        }        
    
    }
    
    public void seleccion_nave(){ //nave que seleccione el usuario...
        
        
        
    }
    
    public Rectangle2D area(){        
        return new Rectangle2D.Double(x, y, nave.getWidth(null), nave.getHeight(null));        
    }    
}
