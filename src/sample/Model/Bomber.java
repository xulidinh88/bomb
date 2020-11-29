package sample.Model;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bomber extends Entity {

    public Bomber(int x, int y, String imgpath, int width, int height)
    {
        super( x, y, imgpath, width, height);
    }

    @Override
    public void update() {

    }
}