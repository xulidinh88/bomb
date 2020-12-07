package sample.Model;

import javafx.scene.image.Image;

public class SpeedItem extends Entity{
    private final static String Brick = "sample/Image/brick.png";
    private final static String SpeedItem = "sample/Image/flameItem.png";
    public boolean hienThiSpeedItem = false;

    @Override
    public void update() {
        if(hienThiSpeedItem == true) this.img = new Image(SpeedItem);
    }

    public SpeedItem(int x, int y)
    {
        super(x,y,new Image(Brick));
    }
}
