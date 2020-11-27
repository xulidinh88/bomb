package sample;

        import javafx.animation.AnimationTimer;
        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.canvas.Canvas;
        import javafx.scene.canvas.GraphicsContext;
        import javafx.stage.Stage;
        import org.jetbrains.annotations.NotNull;
        import sample.Model.*;
        import sample.graphics.Sprite;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;

public class Main extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();


    @Override
    public void start(@NotNull Stage stage) throws Exception {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        createMap();

        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void createMap() throws Exception {

        String url = "D:\\Code\\JAVA\\bomb\\src\\sample\\level.txt";
        File file = new File(url);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String target[][] = new String[31][31];

        try {
            for (int i = 0; i < HEIGHT; i++) {
                String line = reader.readLine();
                for (int j = 0; j < WIDTH; j++) {
                    target[i][j] = String.valueOf(line.charAt(j));
                    Entity object;
                    if (target[i][j].equals("#")) {
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                        stillObjects.add(object);
                    } else if (target[i][j].equals("p")) {

                        }
                        else if (target[i][j].equals("*")) {
                            object = new Brick(j, i, Sprite.brick_exploded.getFxImage());
                            stillObjects.add(object);
                        } else {
                        object = new Brick(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}