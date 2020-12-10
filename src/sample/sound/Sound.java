package sample.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Sound {

    private final static String anItemURl = new File("").getAbsolutePath() + "\\src\\sample\\sound\\anItem.wav";
    private final static String datBomURL = new File("").getAbsolutePath() + "\\src\\sample\\sound\\datBom.wav";
    private final static String anPortalURL = new File("").getAbsolutePath() + "\\src\\sample\\sound\\anPortal.wav";
    private final static String bigBangURL = new File("").getAbsolutePath() + "\\src\\sample\\sound\\bomb_bang.wav";
    private final static String playSoundURL = new File("").getAbsolutePath() + "\\src\\sample\\sound\\beethoven.wav";
    public static void play_anItem()
    {
        Media media = new Media(new File(anItemURl).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public static void play_datBom()
    {
        Media media = new Media(new File(datBomURL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public static void play_anPortal()
    {
        Media media = new Media(new File(anPortalURL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public static void bigBang() {
        Media media = new Media(new File(bigBangURL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public static void playGame() {
        Media media = new Media(new File(playSoundURL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
