package cs3330.hydragame.hydragame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class HydraHead
{
    private int headSize;
    private int currentGridX = 800;
    private int currentGridY = 850;
    private ImageView imageView;

    public HydraHead(Image image, int size) {
        this.headSize = size;
        this.imageView = new ImageView(image);
    }

    public int getHeadSize() {
        return headSize;
    }

    public int getGridX() {
        return currentGridX;
    }

    public int getGridY() {
        return currentGridY;
    }

    public void putIn(int gridX, int gridY, GridPane board) {
        this.currentGridX = gridX;
        this.currentGridY = gridY;
        // TODO: Add logic to place head in grid
    }
}
