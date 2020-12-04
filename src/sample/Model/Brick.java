package sample.Model;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.Main;

public class Brick extends Entity {

    private final static String urlImage = "sample/Image/brick.png";
    private final static String brick = "sample/Image/brick_exploded.png";
    private final static String brick1 = "sample/Image/brick_exploded1.png";
    private final static String brick2 = "sample/Image/brick_exploded2.png";

    Animation brickDelete;
    public Brick(int x, int y)
    {
        super(x, y, new Image(urlImage));
        brickDelete = new Animation();
        brickDelete.add(new Image(brick));
        brickDelete.add(new Image(brick1));
        brickDelete.add(new Image(brick2));
    }
    boolean isDelete = false;
    boolean chayHieuUng = false;
    long timeInit;
    long thoiGianChayHieuUng = 600;
    @Override
    public void update() {
        if(isDelete)
        {
            if(chayHieuUng == false)
            {
                chayHieuUng =true;
                timeInit = System.currentTimeMillis();
            }
            if(chayHieuUng)
            {
                this.img = brickDelete.getCurrentFrame(200);
                if(System.currentTimeMillis() - timeInit >= thoiGianChayHieuUng)
                {
                    Main.ObjectToChange.remove(this);
                }
            }

        }
    }
}