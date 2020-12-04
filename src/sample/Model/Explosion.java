package sample.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.controllers.Controller;
import sample.Main;
import java.util.ArrayList;

public class Explosion extends Entity{
    private final static String bombExplosion = "main/java/sample/images/bomb_exploded.png";
    private final static String bomExplosion1 = "main/java/sample/images/bomb_exploded1.png";
    private final static String bomExplosion2 = "main/java/sample/images/bomb_exploded2.png";

    private ArrayList<donViNo> listDonViNo = new ArrayList<donViNo>();
    private long timeInit;
    private long thoiGianNo = 600;

    private boolean khoiTaoTrai = true;
    private boolean khoiTaoPhai = true;
    private boolean khoiTaoTren = true;
    private boolean khoiTaoDuoi = true;

    private GraphicsContext gc;
    @Override
    public void render(GraphicsContext gc) {
        for (donViNo i:listDonViNo) {
            i.render(gc);
        }
    }

    public Explosion(int x, int y)
    {
        super(x,y);
        System.out.println("Khởi tạo thành công");
    }
}
