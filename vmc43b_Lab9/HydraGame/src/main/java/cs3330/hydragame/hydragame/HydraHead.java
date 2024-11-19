package cs3330.hydragame.hydragame;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Random;

public class HydraHead
{
    //fields
    private int headSize;
    private int currentGridX;
    private int currentGridY;
    private ImageView imageView;
    public static int countHeads;

    //create random object
    private static Random rand = new Random();

    //create 2d array called occupied of type boolean to keep track which x,y cord is used or not
    public static boolean[][] occupied = new boolean[16][16];  // Track occupied spots
    //if a grid position at x,y is occupied, it'll be true

    //constructor for HydraHead
    public HydraHead(Image image, int size) {
        this.headSize = size;
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(40);
        this.imageView.setFitHeight(40);
    }

    public int getHeadSize() {
        return this.headSize;
    }

    public int getGridX() {
        return this.currentGridX;
    }

    public int getGridY() {
        return this.currentGridY;
    }

    public void putIn(int gridX, int gridY, GridPane board) {
        this.currentGridX = gridX;
        occupied[gridX][gridY] = true;
        this.currentGridY = gridY;

        gridY = this.getGridY();
        // Place the imageView we created in constructor
        board.add(imageView, gridX, gridY);
        // Add the click listener right after placing it
        addClickListener(board);
    }

    public void addClickListener(GridPane board)
    {
        imageView.setOnMouseClicked(event ->
        {
            countHeads++;
            // Get current position
            int currentX = GridPane.getColumnIndex(imageView);
            int currentY = GridPane.getRowIndex(imageView);

            // Clear current position
            occupied[currentX][currentY] = false;
            board.getChildren().remove(imageView);

            // If head size > 1, spawn 2-3 new heads
            if (headSize > 1)
            {
                //randomly make 2 or 3 heads
                int newHeadCount = 2 + rand.nextInt(2); // 2 or 3 heads
                for (int i = 0; i < newHeadCount; i++)
                {
                    // Find empty spot
                    int newX = rand.nextInt(16);
                    int newY = rand.nextInt(16);

                    // Keep trying until we find an empty spot
                    while (occupied[newX][newY])
                    {
                        newX = rand.nextInt(16);
                        newY = rand.nextInt(16);
                    }

                    // Create and place new head
                    HydraHead newHead = new HydraHead(HydraHeadFactory.getHead(this.getHeadSize() - 1), headSize - 1);
                    newHead.putIn(newX, newY, board);
                }
            }
            if(isGridEmpty()){
                VBox gameOverBox = new VBox();
                Label gameover = new Label("Good Job!-you have cut " + countHeads + " hydra heads");
                gameover.setStyle("-fx-font-size: 24; -fx-font-weight: bold; -fx-text-fill: red;");
                gameOverBox.getChildren().add(gameover);
                gameOverBox.setAlignment(Pos.CENTER);
                board.add(gameOverBox, 0, 7, 16, 2);
            }
        });
    }

    private boolean isGridEmpty()
    {
        for(int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                if(occupied[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
