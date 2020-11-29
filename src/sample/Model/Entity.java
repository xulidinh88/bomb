package sample.Model;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;
    protected int width;
    protected int height;
    String imgpath;
    protected Image img;
    protected int list_index;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, String imgpath, int width, int height) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.imgpath = imgpath;
        this.width = width;
        this.height = height;
    }

    public Boolean collision(Entity entity) {
        if (entity.x >= this.x && entity.x - this.x < this.width && entity.y >= this.y && entity.y - this.y < this.height) return true;
        if (this.x >= entity.x && this.x - entity.x < entity.width && entity.y >= this.y && entity.y - this.y < this.height) return true;
        if (entity.x >= this.x && entity.x - this.x < this.width && this.y >= entity.y && this.y - entity.y < entity.height) return true;
        if (this.x >= entity.x && this.x - entity.x < entity.width && this.y >= entity.y && this.y - entity.y < entity.height) return true;
        return false;
    }
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();
}