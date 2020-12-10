package sample.Model;

import javafx.scene.image.Image;
import sample.controllers.Controller;

public class Portal extends Entity {
    public final static String Portal = "sample/Image/portal.png";
    @Override
    public void update() {
    }

    public Portal(int x, int y)
    {
        super(x,y,new Image(Portal), Controller.SCALESIZE, Controller.SCALESIZE);
    }
}
