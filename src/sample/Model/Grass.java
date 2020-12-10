package sample.Model;

import javafx.scene.image.Image;

public class Grass extends Entity {

    private final static String urlImage = "sample/Image/grass3.png";
    public Grass(int x, int y)
    {
        super(x, y, new Image(urlImage));
    }
    @Override
    public void update() {

    }
}