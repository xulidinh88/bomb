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
    private boolean isDelete = false;
    public boolean isDie = false;
    private long timeDead;
    @Override
    public void update() {
        //Xử lý va chạm:
        for (Entity i:Main.ObjectToChange) {
            if(i instanceof Balloom)
            {
                if(this.collision(i))
                {
                    this.isDie = true;
                    break;
                }
            }
            else continue;
        }
        if(isDie)
        {
            if(!isDelete)
            {
                isDelete = true;
                timeDead = System.currentTimeMillis();
            }
            else
            {
                this.img = player_dead.getCurrentFrame(300);
                if(System.currentTimeMillis() - timeDead >= 900)
                {
                    Main.ObjectToChange.remove(this);
                }
            }
        }
        else
        {
            if(!collinsMap())
            {
                this.x += moveStepX;
                this.y += moveStepY;
            }
        }
    }

    //Check va chạm với Brick và Wall
    public boolean collinsMap()
    {
        //System.out.println("Toa do: "+x+","+y);
        boolean collinsMap = false;
        for(Entity o: Main.staticObject)
        {
            if(o instanceof Wall)
            {
                if(this.collision(o))
                {
                    System.out.println("Va cham");
                    if(trangThai.equals(Huong.LEN)) this.y += STEP;
                    if(trangThai.equals(Huong.XUONG))this.y -= STEP;
                    if(trangThai.equals(Huong.PHAI)) this.x -=  STEP;
                    if(trangThai.equals(Huong.TRAI)) this.x += STEP;
                    collinsMap = true;
                    break;
                }
            }
            else continue;
        }
        for (Entity o:Main.ObjectToChange)
        {
            if(o instanceof Brick)
            {
                if(this.collision(o))
                {
                    System.out.println("Va cham");
                    if(trangThai.equals(Huong.LEN)) this.y += STEP;
                    if(trangThai.equals(Huong.XUONG))this.y -= STEP;
                    if(trangThai.equals(Huong.PHAI)) this.x -=  STEP;
                    if(trangThai.equals(Huong.TRAI)) this.x += STEP;
                    collinsMap = true;
                    break;
                }
            }
            else continue;
        }
        return collinsMap;
    }

    enum Huong {
        DUNGIM, PHAI, TRAI, LEN, XUONG;
    }

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

    Animation player_right;
    Animation player_left;
    Animation player_up;
    Animation player_down;
    Animation player_dead;

    Huong trangThai = Huong.DUNGIM;

    public int moveStepX, moveStepY;

    public Bomber(int x, int y) {
        super(x, y, new Image(bomberRigh),Controller.SCALESIZE-4, Controller.SCALESIZE-3);

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

    public void KeyPress(KeyEvent e) {
        System.out.println(e.getCode().toString());
        switch (e.getCode().toString()) {
            case "LEFT":
                Main.upkey = false;
                Main.downkey = false;
                Main.rightkey = false;
                Main.leftKey = true;
                break;
            case "RIGHT":
                Main.upkey = false;
                Main.downkey = false;
                Main.rightkey = true;
                Main.leftKey = false;
                break;
            case "UP":
                Main.upkey = true;
                Main.downkey = false;
                Main.rightkey = false;
                Main.leftKey = false;
                break;
            case "DOWN":
                Main.upkey = false;
                Main.downkey = true;
                Main.rightkey = false;
                Main.leftKey = false;
                break;
            case "SPACE":
                thaBom();
                break;
        }
    }

    public void keyRelease(KeyEvent e) {

        Main.upkey = false;
        Main.downkey = false;
        Main.rightkey = false;
        Main.leftKey = false;
        moveStepY = 0;
        moveStepX = 0;
    }
    public void thaBom()
    {
        System.out.println("Thả bom");
        Bomb b = new Bomb(this.y,this.x);
        Main.ObjectToChange.add(b);
    }
    public void Tien() {
        moveStepX = STEP;
        trangThai = Huong.PHAI;
        this.img = player_right.getCurrentFrame();
    }

    public void Lui() {
        moveStepX = -STEP;
        trangThai = Huong.TRAI;
        ;
        this.img = player_left.getCurrentFrame();
    }

    public void Len() {
        moveStepY = -STEP;
        trangThai = Huong.LEN;
        this.img = player_up.getCurrentFrame();
    }

    public void Xuong() {
        moveStepY = STEP;
        trangThai = Huong.XUONG;
        this.img = player_down.getCurrentFrame();
    }

}