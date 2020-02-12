/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;



/**
 *
 * @author youss
 */
public class SoundClick extends javax.swing.JApplet{
    
    public static AudioClip ThemeMusic;
  
    
    
    public void PlayClick()
    {

        ThemeMusic = Applet.newAudioClip(Get_Location("/Audio/[EXCLU] Soolking Guerilla #PlaneteRap.mp3"));
        ThemeMusic.play();
    }
    
    public URL Get_Location(String filename)
    {URL url = null;
        try{
            url = this.getClass().getResource(filename);
        }
        catch(Exception e ){
    }
        return url;}
    
        
        
    
    
        
    

}
