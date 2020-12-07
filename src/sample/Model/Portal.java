package sample.Model;

import javafx.scene.image.Image;

public class Portal extends Entity {
    public final static String Portal = "sample/Image/portal.png";
    public final static String Brick = "sample/Image/brick.png";
    public boolean hienThiPortal = false;

    @Override
    public void update() {
        if(hienThiPortal == true) this.img = new Image(Portal);
    }

    public Portal(int x, int y)
    {
        super(x,y,new Image(Brick));
    }
}
