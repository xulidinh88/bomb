package sample.Model;

import javafx.scene.image.Image;

public class DeleteOneItem extends Entity{
    private final static String Brick = "sample/Image/gifttt.png";
    private final static String DeleteOneItem = "sample/Image/flameItem.png";
    public boolean hienThiDeleteOneItem = false;

    @Override
    public void update() {
        if(hienThiDeleteOneItem == true) this.img = new Image(DeleteOneItem);
    }

    public DeleteOneItem(int x, int y)
    {
        super(x,y,new Image(Brick));
    }
}
