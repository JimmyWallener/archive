package musicplayer;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;



public class Sounds {

    public static void getSound(String getId) {

        String file = ".\\mp3\\" + getId + ".mp3";

        try {
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(file).toURI().toString()));

            Runnable playMusic = mediaPlayer::play;
            mediaPlayer.setOnReady(playMusic);
            mediaPlayer.setAutoPlay(false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
