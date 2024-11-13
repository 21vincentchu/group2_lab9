package cs3330.hydragame.hydragame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class HydraHead
{
    private int headSize;
    private int currentGridX = 40;
    private int currentGridY = 40;
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

        Image initialHead = HydraHeadFactory.getHead(headSize);
        ImageView initialHeadView = new ImageView(initialHead);
        initialHeadView.setFitWidth(40);
        initialHeadView.setFitHeight(40);
        board.add(initialHeadView,gridX,gridY);

        //check if they're not on top of each other.
    }
}
