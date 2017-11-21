package Sonidos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Sfx {
    
    public String disparo, menu, seleccion, explosion, pausa, fin, juego, vida,gas;
    
    public Sfx(){
        
        disparo = "src/Audios/laser.wav";
        menu = "src/Audios/temappal.wav";
        seleccion = "src/Audios/sonido1.wav";
        explosion = "src/Audios/explosion.wav";
        pausa = "src/Audios/sonido1.wav";
        fin = "src/Audios/sonido1.wav";
        juego = "src/Audios/sonido1.wav";
        vida = "src/Audios/sonido1.wav";
        gas = "src/Audios/gas.wav";
        
    }
    
    public void sonido_continuo(String tipo){
        
        try {
            AudioData data = new AudioStream(new FileInputStream(tipo)).getData();
            ContinuousAudioDataStream BGM = new ContinuousAudioDataStream(data);
            AudioPlayer.player.start(BGM);
        } catch (IOException ex) {
            System.out.println("No se encontro el archivo");
        }
        
    }
    
    public void sonido(String tipo) throws FileNotFoundException, IOException{
        
        InputStream in = new FileInputStream(tipo);
        AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
        
    }
    
}
