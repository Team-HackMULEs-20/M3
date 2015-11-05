package gameConfig;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.*;
import java.util.Random;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class RandMap{
    private final int row;
    private final int col;
    private int randNum;
    public ImageView plain, town, pic;
    private File file;
    private File[] fileList1;
    private ArrayList<File> fileList2;

    public RandMap(int col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     *
     * @return row the row of the grid
     */
    public int getRow() {return row;}
    /**
     *
     * @return col the column of the grid
     */
    public int getCol() {return col;}

    /**
     *
     * @throws IOException
     */
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
