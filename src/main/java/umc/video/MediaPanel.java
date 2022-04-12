package umc.video;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.JPanel;  
  
public class MediaPanel extends JPanel {  
    public MediaPanel( URL mediaURL ) {  
  
        setLayout( new BorderLayout() ); // use a BorderLayout  
  
//        try {  
//  
//        	Player mediaPlayer = Manager.createRealizedPlayer( mediaURL );  
              
  
//            Component video = mediaPlayer.getVisualComponent();  
//            Component controls = mediaPlayer.getControlPanelComponent();  
//  
//  
//  
//            if ( video != null )  
//                add( video, BorderLayout.CENTER ); // add video component  
//  
//            if ( controls != null )  
//                add( controls, BorderLayout.SOUTH ); // add controls  
//  
//            mediaPlayer.start();  
  
  
  
            // start playing the media clip  
        // end try  
//        catch ( NoPlayerException e ) {  
//            System.err.println( "No media player found" );  
//            e.printStackTrace();
//        } // end catch  
//        catch ( CannotRealizeException cannotRealizeException ) {  
//            System.err.println( "Could not realize media player" );  
//        } // end catch  
//        catch ( IOException iOException ) {  
//            System.err.println( "Error reading from the source" );  
//        } // end catch  
    } // end MediaPanel constructor  
} // end class MediaPanel  