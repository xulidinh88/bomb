package sample.Model;

import javafx.scene.image.Image;
import sample.controllers.Controller;

public class Balloom extends Entity{
    private final static String balloomLeft = "sample/Image/balloom_left1.png";
    private final static String balloomLeft1 = "sample/Image/balloom_left2.png";
    private final static String balloomLeft2 = "sample/Image/balloom_left3.png";

    private final static String balloomRight = "sample/Image/balloom_right1.png";
    private final static String balloomRight1 = "sample/Image/balloom_right2.png";
    private final static String balloomRight2 = "sample/Image/balloom_right3.png";

    private final static String balloomDown = "sample/Image/balloom_left1.png";
    private final static String balloomDown1 = "sample/Image/balloom_left2.png";
    private final static String balloomDown2 = "sample/Image/balloom_left3.png";

    private final static String balloomUp = "sample/Image/balloom_right1.png";
    private final static String balloomUp1 = "sample/Image/balloom_right2.png";
    private final static String balloomUp2 = "sample/Image/balloom_right3.png";

    private final static String balloomDead = "sample/Image/balloom_dead.png";
    private final static String balloomDead0 = "sample/Image/mob_dead1.png";
    private final static String balloomDead1 = "sample/Image/mob_dead2.png";
    private final static String balloomDead2 = "sample/Image/mob_dead3.png";

    private final static int STEP = 1;

    Animation aniBalloomLeft;
    Animation aniBalloomRight;
    Animation aniBalloomUp;
    Animation aniBalloomDown;
    Animation aniBalloomDead;


    public Balloom(int x, int y){
        super(x,y,new Image(balloomLeft), Controller.SCALESIZE, Controller.SCALESIZE);

        aniBalloomLeft = new Animation();
        aniBalloomLeft.add(new Image(balloomLeft));
        aniBalloomLeft.add(new Image(balloomLeft1));
        aniBalloomLeft.add(new Image(balloomLeft2));

        aniBalloomRight = new Animation();
        aniBalloomRight.add(new Image(balloomRight));
        aniBalloomRight.add(new Image(balloomRight1));
        aniBalloomRight.add(new Image(balloomRight2));

        aniBalloomDown = new Animation();
        aniBalloomDown.add(new Image(balloomDown));
        aniBalloomDown.add(new Image(balloomDown1));
        aniBalloomDown.add(new Image(balloomDown2));

        aniBalloomUp = new Animation();
        aniBalloomUp.add(new Image(balloomUp));
        aniBalloomUp.add(new Image(balloomUp1));
        aniBalloomUp.add(new Image(balloomUp2));

        aniBalloomDead = new Animation();
        aniBalloomDead.add(new Image(balloomDead));
        aniBalloomDead.add(new Image(balloomDead0));
        aniBalloomDead.add(new Image(balloomDead1));
        aniBalloomDead.add(new Image(balloomDead2));
    }
}
