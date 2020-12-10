package sample;


import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Model.*;
import sample.Model.Entity;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import sample.controllers.Controller;
import sample.sound.Sound;
import sun.plugin2.message.GetAppletMessage;

import javax.naming.TimeLimitExceededException;

import java.util.ArrayList;

public class Main extends Application {


    private int WIDTH;
    private int HEIGHT;
    private final int FPS = 60;
//    private GraphicsContext gc;
//    private Canvas canvas;
//    private List<Entity> entities = new ArrayList<>();
//    private List<Entity> stillObjects = new ArrayList<>();

    private String phaDaoURl = "sample/Image/congratulations.png";

    public static List<Entity> ObjectToChange = new ArrayList<Entity>();
    public static List<Entity> staticObject = new ArrayList<Entity>();
    public static List<Entity> Explosion = new ArrayList<Entity>();

    public static boolean upkey = false;
    public static boolean rightkey = false;
    public static boolean downkey = false;
    public static boolean leftKey = false;

    static Timeline gameloop;

    @Override
    public void start(Stage stage) throws Exception {
        try {
//            // Tao Canvas
//            canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
//            gc = canvas.getGraphicsContext2D();

            Pane root = (Pane) FXMLLoader.load(getClass().getResource("sample.fxml"));
            Canvas display = (Canvas) Controller.getNode("display", root);
            GraphicsContext gc = display.getGraphicsContext2D();
            int[] size = Controller.loadObjectToList(ObjectToChange,staticObject);
            root.setPrefSize(size[1]* Controller.SCALESIZE + 50, size[0]* Controller.SCALESIZE + 50);
            stage.setTitle("Bomberman Game");
            Scene scene = new Scene(root);

            //GET SIZE MAP
            HEIGHT = size[0]* Controller.SCALESIZE;
            display.setHeight(HEIGHT);
            WIDTH = size[1]* Controller.SCALESIZE;
            display.setWidth(WIDTH);

            //CREATE MAP
            render(gc);

            scene.setOnKeyPressed(event -> Controller.player.KeyPress(event));
            scene.setOnKeyReleased(event -> Controller.player.keyRelease(event));

            //Game loop:
            gameloop = new Timeline(new KeyFrame(Duration.millis(Controller.speed), event -> {

                if(rightkey) {
                    Controller.player.Tien();
                }
                if(leftKey) {
                    Controller.player.Lui();
                }
                if(downkey) {
                    Controller.player.Xuong();
                }
                if(upkey)
                {
                    Controller.player.Len();
                }

            }), new KeyFrame(Duration.millis(1000/FPS), event -> {
                if(Controller.GAME_OVER)
                {

                    ResetGame();
//                    Sound.playGame();
                    Controller.loadObjectToList(ObjectToChange,staticObject);
                    render(gc);
                    Controller.GAME_OVER = false;
                }
                if(Controller.PHA_DAO == true)
                {
                    renderManHinhPhaDao(gc);
                    gameloop.stop();
                }
                else
                {
                    update();
                    Sound.playGame();
                    render(gc);
                }
            }));

            gameloop.setCycleCount(Timeline.INDEFINITE);
            gameloop.play();

            // Them scene vao stage
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void renderManHinhPhaDao(GraphicsContext gc)
    {
        Sound.playGame();
        Image phaDao = new Image(phaDaoURl);
        gc.clearRect(0,0,WIDTH,HEIGHT);
        gc.drawImage(phaDao,0+(WIDTH/2 - phaDao.getWidth()/2),0);
        System.out.println("Xóa màn hình");

    }

    private void render(GraphicsContext gc) {
        gc.clearRect(0,0,WIDTH,HEIGHT);
        for (Entity e: staticObject) {
            e.render(gc);
        }
        for (Entity e: Explosion) {
            e.render(gc);
        }
        for (Entity e: ObjectToChange) {
            e.render(gc);
        }
    }

    private void update()
    {
        try{
            for(Entity o:Explosion)
            {
                o.update();
            }

            for (Entity o:ObjectToChange) {
                o.update();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void ResetGame()
    {
        ObjectToChange = new ArrayList<Entity>();
        staticObject = new ArrayList<Entity>();
    }
    public static void main(String[] args) {
        launch(args);
    }

}