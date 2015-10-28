package gameConfig;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;
import java.awt.image.Raster;
import javafx.scene.image.ImageView;
import java.util.ArrayList;



/**
 * Created by Abigail on 10/18/15.
 */
public class RandMap{
    private int row, col, randNum;
    public ImageView plain, town, pic;
    private File file;
    private File[] fileList1;
    private ArrayList<File> fileList2;

    public RandMap(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {return row;}

    public int getCol() {return col;}

    public void setImages() throws IOException {

        File file = new File("UIFiles/Media/RandMapTiles");
        File[] fileList1 = file.listFiles();
        ArrayList<File> fileList2 = new ArrayList<>();

        for (File file1 : fileList1) {
            fileList2.add(file1);
        }
        Parent mainMap = FXMLLoader.load(getClass().getResource("UIFiles/MainMap.fxml"));
        GridPane grid = (GridPane) mainMap;
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 5; j++) {
                    Random rand = null;
                    int randNum = rand.nextInt(fileList2.size()) + 1;
                    ImageView pic = new ImageView();
                    Object toAdd = fileList2.get(randNum).toURI().toString();
                    pic.setImage((javafx.scene.image.Image) toAdd);
                    grid.add(pic, i, j);
                }
            }
            for (int i = 0; i < 5; i++) {
                Object plainFile = new File("/UIFiles/Media/plain.png");
                ImageView plain = new ImageView();
                plain.setImage((javafx.scene.image.Image) plainFile);
                grid.add(plain, 4, i);
            }
            Object townFile = new File("/UIFiles/Media/town.png");
            ImageView town = new ImageView();
            town.setImage((javafx.scene.image.Image) townFile);
            grid.add(town, 4, 2);
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
