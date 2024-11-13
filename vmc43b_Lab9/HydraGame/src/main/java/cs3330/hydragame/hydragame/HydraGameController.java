package cs3330.hydragame.hydragame;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;

public class HydraGameController implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    private Button resetButton;
    private Button playButton;
    private Slider slider;
    private GridPane gameGrid;
    Random rand = new Random();


    public BorderPane getLayout()
    {
        //make border pane
        BorderPane root = new BorderPane();

        //control buttons
        resetButton = new Button("Reset");
        playButton = new Button("Play");

        // Set button sizes
        resetButton.setPrefWidth(100);  // Makes Reset button 100 pixels wide
        playButton.setPrefWidth(100);   // Makes Play button 100 pixels wide

        //slider with labels
        Label sliderLabel = new Label("Head Size");
        slider = new Slider(2, 6, 4);
        slider.setBlockIncrement(1);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        // Create VBox for slider and its label
        VBox sliderBox = new VBox(5);
        sliderBox.setAlignment(Pos.CENTER);
        sliderBox.getChildren().addAll(sliderLabel, slider);

        // Set up HBox for all controls
        HBox controls = new HBox(20);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));  // Same padding all around
        controls.getChildren().addAll(resetButton, sliderBox, playButton);

        // Create game grid
        gameGrid = new GridPane();
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true;");

        // Create 16x16 grid
        for (int i = 0; i < 16; i++) {
            ColumnConstraints column = new ColumnConstraints(40);
            gameGrid.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 16; i++) {
            RowConstraints row = new RowConstraints(40);
            gameGrid.getRowConstraints().add(row);
        }

        // Set up button actions
        resetButton.setOnAction(this::reset);
        playButton.setOnAction(this::play);

        // Add to border pane
        root.setTop(controls);
        root.setCenter(gameGrid);

        return root;
    }

    public void reset(ActionEvent event)
    {
        // TODO: Reset game state
        playButton.setDisable(false);
        slider.setDisable(false);
        slider.setValue(4);
        gameGrid.getChildren().clear();
    }

    public void play(ActionEvent event)
    {
        // TODO: Handle play action
        playButton.setDisable(true);
        slider.setDisable(true);

        int headSize = (int) slider.getValue();
        Image initialHead = HydraHeadFactory.getHead(headSize);
        //ImageView initialHeadView = new ImageView(initialHead);
        // TODO: Place head in random grid cell
        int numRow = rand.nextInt(16)+1;
        int numCol = rand.nextInt(16)+1;

        HydraHead head = new HydraHead(initialHead,headSize);
        head.putIn(numCol, numRow, gameGrid);

        //ararylistH
        //random 2 or 3,
        //arraylistV
        //while loop != arraylistH && !=arraylistV && == random number of heads, end of while loop, put a counter.
        //run every time person clicks head
        //pass headsize -1 to get the next head.
    }

    public void setHeadSize(MouseEvent event)
    {
        // TODO: Handle head size change
    }
}