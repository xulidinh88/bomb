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

    }

    public static void main(String[] args) {
        launch(args);
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