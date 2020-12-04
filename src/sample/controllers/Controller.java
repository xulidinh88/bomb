package sample.controllers;

import javafx.scene.layout.Pane;
import sample.Model.*;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static javafx.scene.input.KeyCode.*;

public class Controller {
    public static int kichThuocVuNo = 1; //Kích thước của vụ nổ tính từ tâm ra
    public final static int SCALESIZE = 32;
    public static Bomber player;
    public static char[][] MAP;
    public static Node getNode(String id, Pane root) {
        Node result = null;
        for (Node i : root.getChildren()) {
            if (i.getId().toString().equals(id)) {
                result = i;
            }
        }
        return result;
    }

    public static int[] loadObjectToList(List<Entity> ObjectToChange, List<Entity> staticObject) {
        int row = 0;
        int col = 0;
        try {
            File file = new File("D:\\Code\\JAVA\\bomb\\src\\sample\\level.txt");
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String firstLine[] = reader.readLine().split(" ");
            int level = Integer.parseInt(firstLine[0]);
            row = Integer.parseInt(firstLine[1]);
            col = Integer.parseInt(firstLine[2]);
            System.out.println("Level: " + level);
            System.out.println("Rows:  " + row);
            System.out.println("Colums:  " + col);
            MAP = new char[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    char read = (char) reader.read();
                    if (read == '\n') j--;
                    else {MAP[i][j] = read;System.out.print(MAP[i][j]);}

                    if (read == '#') staticObject.add(new Wall(i * SCALESIZE, j * SCALESIZE));
                    if (read != '#')
                    {
                        staticObject.add(new Grass(i * SCALESIZE, j * SCALESIZE));
                        if (read == 'p')
                        {
                            player = new Bomber(i*SCALESIZE,j*SCALESIZE);
                            ObjectToChange.add(player);
                        }
                        else if(read == '*') ObjectToChange.add(new Brick(i*SCALESIZE,j*SCALESIZE));
                        else if(read == '1') ObjectToChange.add(new Balloom(i*SCALESIZE,j*SCALESIZE));
                    }
                }
                System.out.println();

            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int[] result = {row, col};
        return result;
    }
}
