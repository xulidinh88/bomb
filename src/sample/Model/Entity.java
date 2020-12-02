package sample.Model;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.controllers.Controller;
import sample.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;
    protected int width;
    protected int height;
    protected Image img;
    protected int list_index;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(int x, int y, Image img)
    {
        this.x = y;
        this.y = x;
        this.width = Controller.SCALESIZE;
        this.height = Controller.SCALESIZE;
        this.img = img;
    }
    public Entity(int x, int y, Image img, int witdth, int height)
    {
        this.x = y;
        this.y = x;
        this.width = witdth;
        this.height = height;
        this.img = img;
    }
    public Entity(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Entity(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
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
        gc.drawImage(img,x,y, Controller.SCALESIZE, Controller.SCALESIZE);
    }
    public void update(){}
}