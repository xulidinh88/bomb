package sample.Model;

import javafx.scene.image.Image;

public class BombItem extends Entity{
    private final static String Brick = "sample/Image/gifttt.png";
    private final static String BomItem = "sample/Image/flameItem.png";
    public boolean hienThiBombItem = false;

    @Override
    public void update() {
        if(hienThiBombItem == true) this.img = new Image(BomItem);
    }

    public BombItem(int x, int y)
    {
        super(x,y,new Image(Brick));
    }
}