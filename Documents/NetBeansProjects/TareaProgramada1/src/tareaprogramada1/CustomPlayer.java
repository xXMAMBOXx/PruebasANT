package tareaprogramada1;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.decoder.JavaLayerException;

import javazoom.jl.player.Player;


public class CustomPlayer {
private Player player;
private FileInputStream FIS;
private BufferedInputStream BIS;
private boolean canResume;
private String path;
private int total;
private int stopped;
private boolean valid;

public CustomPlayer(){
    player = null;
    FIS = null;
    valid = false;
    BIS = null;
    path = null;
    total = 0;
    stopped = 0;
    canResume = false;
    
}

public boolean canResume(){
    return canResume;
}

public void setPath(String path){
    this.path = path;
    //JFileChooser seleccionar = new JFileChooser();
}
public void terminar(){
    player.close();
    player=null;
}
public void pause(){
    try{
    stopped = FIS.available();
    player.close();
    FIS = null;
    BIS = null;
    player = null;
    if(valid) canResume = true;
    }catch(Exception e){

    }
}

public void resume(){
    if(!canResume) return;
    if(play(total-stopped)) canResume = false;
}
public int getPause(){
    return stopped;
}
public boolean play(int pos){
    valid = true;
    canResume = false;
    try{
       
        
    // archivo = seleccionar.getSelectedFile();
    
    FIS = new FileInputStream(path);
    total = FIS.available();
    if(pos > -1) FIS.skip(pos);
    BIS = new BufferedInputStream(FIS);
    
    player = new Player(BIS);
    new Thread(
            new Runnable(){
                public void run(){
                    try{
                        player.play();
                        
                    }catch(Exception e){
                        valid = false;
                    }
                }
            }
    ).start();
    }catch(Exception e){
        valid = false;
    }
    return valid;
}
public boolean getComplete() throws JavaLayerException{
return player.isComplete();
}

}
