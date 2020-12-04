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
        MAP = null;
        try {
            String urlMap = new File("").getAbsolutePath() + "\\out\\production\\bomb\\sample\\";
            File myObj = new File(urlMap + "level.txt");
            Scanner myReader = new Scanner(myObj);
            String firstline = myReader.nextLine();
            String[] mapsize = firstline.split(" ", 3);
            row = Integer.parseInt(mapsize[1]);
            col = Integer.parseInt(mapsize[2]);
            int level1 = Integer.parseInt(mapsize[0]);
            System.out.println("Level: " + level1);
            System.out.println("Rows:  " + row);
            System.out.println("Colums:  " + col);
            int i = 0;
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                for(int j = 0;j < col;j++)
                {

                    char read = data.charAt(j);
                    //System.out.print(read + ": " +i +"," +j);
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
                        else if(read == '1') {
                            ObjectToChange.add(new Balloom(i*SCALESIZE,j*SCALESIZE));
                        }
//                        else if(read == 'x')ObjectToChange.add(new Portal(i*SCALESIZE,j*SCALESIZE));
//                        else if(read == 'f')ObjectToChange.add(new FrameItem(i*SCALESIZE,j*SCALESIZE));
                    }
                }
                i++;
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int[] result = {row, col};
        return result;
    }
}
