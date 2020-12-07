package sample.Model;

import javafx.scene.image.Image;
import sample.Main;
import sample.controllers.Controller;

import java.util.Random;

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

    public boolean isDie = false;
    private boolean isDelete = false;
    private long timeDead;

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

    private int huong = 0;
    @Override
    public void update() {
        if(isDie)
        {
            if(isDelete == false)
            {
                isDelete = true;
                timeDead = System.currentTimeMillis();//Lưu lại thời gian lúc bắt đầu va chạm chết để xử lý Animation
            }
            else if(isDelete)
            {
                Controller.bot--;
                this.img = aniBalloomDead.getCurrentFrame(250);
                if(System.currentTimeMillis() - timeDead >= 1000) //xóa Object
                {
                    Main.ObjectToChange.remove(this);
                }
            }

        }
        else
        {
            if(huong == 0)
            {
                if(!checkVaChamWalBrickBomb())
                {
                    moveLeft();
                    this.img = aniBalloomLeft.getCurrentFrame(100);
                }
                else
                {
                    System.out.println("Va chạm đổi hướng");
                    moveRight();
                    randomHuong();
                }
            }
            else if(huong == 1)
            {
                if(!checkVaChamWalBrickBomb())
                {
                    moveRight();
                    this.img = aniBalloomRight.getCurrentFrame(100);
                }
                else
                {
                    moveLeft();
                    randomHuong();
                }
            }

            else if(huong == 2)
            {
                if(!checkVaChamWalBrickBomb())
                {
                    moveUp();
                    this.img = aniBalloomUp.getCurrentFrame(100);
                }
                else
                {
                    moveDown();
                    randomHuong();
                }

            }
            else if(huong == 3)
            {
                if(!checkVaChamWalBrickBomb())
                {
                    moveDown();
                    this.img = aniBalloomDown.getCurrentFrame(100);
                }
                else
                {
                    moveUp();
                    randomHuong();
                }
            }
        }

        /*
            Random integer:
            0: Trái
            1: Phải
            2: Trên
            3: Xuống
         */

    }
    public void moveLeft()
    {
        this.x -= STEP;
    }
    public void moveRight()
    {
        this.x += STEP;
    }
    public void moveUp()
    {
        this.y -= STEP;
    }
    public void moveDown()
    {
        this.y += STEP;
    }

    public boolean checkVaChamWalBrickBomb()
    {
        for (Entity i: Main.staticObject) {
            if(i instanceof Wall)
            {
                if(this.collision(i))
                {
                    return true;
                }
            }
        }
        for (Entity i: Main.ObjectToChange) {
            if(i instanceof Brick || i instanceof Bomb)
            {
                if(this.collision(i))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void randomHuong()
    {
        Random rd = new Random();
        huong = rd.nextInt(4);
    }
}
