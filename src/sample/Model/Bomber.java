package sample.Model;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.controllers.Controller;
import sample.Main;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Bomber extends Entity {

    Animation player_right;
    Animation player_left;
    Animation player_up;
    Animation player_down;
    Animation player_dead;

    enum Huong {
        DUNGIM, PHAI, TRAI, LEN, XUONG;
    }

    Huong trangThai = Huong.DUNGIM;

    public int moveStepX, moveStepY;

    private final int STEP = Controller.SCALESIZE /8;
    private final static String bomberRigh = "sample/Image/player_right.png";
    private final static String bomberRigh1 = "sample/Image/player_right_1.png";
    private final static String bomberRigh2 = "sample/Image/player_right_2.png";

    private final static String bomberLeft = "sample/Image/player_left.png";
    private final static String bomberLeft1 = "sample/Image/player_left_1.png";
    private final static String bomberLeft2 = "sample/Image/player_left_2.png";

    private final static String bomberUp = "sample/Image/player_up.png";
    private final static String bomberUp1 = "sample/Image/player_up_1.png";
    private final static String bomberUp2 = "sample/Image/player_up_2.png";

    private final static String bomberDown = "sample/Image/player_down.png";
    private final static String bomberDown1 = "sample/Image/player_down_1.png";
    private final static String bomberDown2 = "sample/Image/player_down_2.png";

    private final static String bomberDead = "sample/Image/player_dead1.png";
    private final static String bomberDead1 = "sample/Image/player_dead2.png";
    private final static String bomberDead2 = "sample/Image/player_dead3.png";

    public Bomber(int x, int y) {
        super(x, y, new Image(bomberRigh), Controller.SCALESIZE-4, Controller.SCALESIZE-3);

        moveStepX = 0;
        moveStepY = 0;

        player_right = new Animation();
        player_right.add(new Image(bomberRigh));
        player_right.add(new Image(bomberRigh1));
        player_right.add(new Image(bomberRigh2));

        player_left = new Animation();
        player_left.add(new Image(bomberLeft));
        player_left.add(new Image(bomberLeft1));
        player_left.add(new Image(bomberLeft2));

        player_up = new Animation();
        player_up.add(new Image(bomberUp));
        player_up.add(new Image(bomberUp1));
        player_up.add(new Image(bomberUp2));

        player_down = new Animation();
        player_down.add(new Image(bomberDown));
        player_down.add(new Image(bomberDown1));
        player_down.add(new Image(bomberDown2));

        player_dead = new Animation();
        player_dead.add(new Image(bomberDead));
        player_dead.add(new Image(bomberDead1));
        player_dead.add(new Image(bomberDead2));
    }

    @Override
    public void update() {

    }
}