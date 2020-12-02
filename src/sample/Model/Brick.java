package sample.Model;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

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
    @Override
    public void update() {

    }
}