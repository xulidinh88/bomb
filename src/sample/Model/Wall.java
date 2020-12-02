
package sample.Model;

import javafx.scene.image.Image;

public class Wall extends Entity {

    private final static String urlImage = "sample/Image/wall.png";
    public Wall(int x, int y)
    {
        super(x, y, new Image(urlImage));
    }
    @Override
    public void update() {

    }
}