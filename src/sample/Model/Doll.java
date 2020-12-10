package sample.Model;

import javafx.scene.image.Image;
import sample.Main;
import sample.controllers.Controller;

import java.util.Random;

public class Doll extends Entity{
    private final static String dollLeft = "sample/Image/doll_left1.png";
    private final static String dollLeft1 = "sample/Image/doll_left2.png";
    private final static String dollLeft2 = "sample/Image/doll_left3.png";

    private final static String dollRight = "sample/Image/doll_right1.png";
    private final static String dollRight1 = "sample/Image/doll_right2.png";
    private final static String dollRight2 = "sample/Image/doll_right3.png";

    private final static String dollDown = "sample/Image/doll_left1.png";
    private final static String dollDown1 = "sample/Image/doll_left2.png";
    private final static String dollDown2 = "sample/Image/doll_left3.png";

    private final static String dollUp = "sample/Image/doll_right1.png";
    private final static String dollUp1 = "sample/Image/doll_right2.png";
    private final static String dollUp2 = "sample/Image/doll_right3.png";

    private final static String dollDead = "sample/Image/doll_dead.png";
    private final static String dollDead0 = "sample/Image/doll_dead.png";
    private final static String dollDead1 = "sample/Image/explosion_vertical.png";
    private final static String dollDead2 = "sample/Image/explosion_vertical.png";

    private final static int STEP = 1;

    Animation aniDollLeft;
    Animation aniDollRight;
    Animation aniDollUp;
    Animation aniDollDown;
    Animation aniDollDead;

    public boolean isDie = false;
    private boolean isDelete = false;
    private long timeDead;

    public Doll(int x, int y){
        super(x,y,new Image(dollLeft), Controller.SCALESIZE, Controller.SCALESIZE);

        aniDollLeft = new Animation();
        aniDollLeft.add(new Image(dollLeft));
        aniDollLeft.add(new Image(dollLeft1));
        aniDollLeft.add(new Image(dollLeft2));

        aniDollRight = new Animation();
        aniDollRight.add(new Image(dollRight));
        aniDollRight.add(new Image(dollRight1));
        aniDollRight.add(new Image(dollRight2));

        aniDollDown = new Animation();
        aniDollDown.add(new Image(dollDown));
        aniDollDown.add(new Image(dollDown1));
        aniDollDown.add(new Image(dollDown2));

        aniDollUp = new Animation();
        aniDollUp.add(new Image(dollUp));
        aniDollUp.add(new Image(dollUp1));
        aniDollUp.add(new Image(dollUp2));

        aniDollDead = new Animation();
        aniDollDead.add(new Image(dollDead));
        aniDollDead.add(new Image(dollDead0));
        aniDollDead.add(new Image(dollDead1));
        aniDollDead.add(new Image(dollDead2));
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
                this.img = aniDollDead.getCurrentFrame(250);
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
                    this.img = aniDollLeft.getCurrentFrame(100);
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
                    this.img = aniDollRight.getCurrentFrame(100);
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
                    this.img = aniDollUp.getCurrentFrame(100);
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
                    this.img = aniDollDown.getCurrentFrame(100);
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
            if(i instanceof Brick || i instanceof Bomb || i instanceof Portal || i instanceof BombItem || i instanceof DeleteOneItem)
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
