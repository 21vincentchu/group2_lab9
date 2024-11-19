package cs3330.hydragame.hydragame;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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

    //initialize fields
    private Button resetButton;
    private Button playButton;
    private Slider slider;
    private GridPane gameGrid;

    //make new random object
    Random rand = new Random();

    //make border pane for entire game
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

    //reset button functionality
    public void reset(ActionEvent event)
    {
        playButton.setDisable(false);
        slider.setDisable(false);
        slider.setValue(4);
        gameGrid.getChildren().clear();

        //clear the occupied array hydra head to default to all false ie. none of the grids are filled
        HydraHead.occupied = new boolean[16][16];
        HydraHead.countHeads = 0;
    }

    //play button functionality
    public void play(ActionEvent event)
    {
        //make the buttons gray when playing
        playButton.setDisable(true);
        slider.setDisable(true);

        //get the head size from the slider
        int headSize = (int) slider.getValue();

        //initialize the image for initial head
        Image initialHead = HydraHeadFactory.getHead(headSize);

        //get initial place to place initial head
        int numRow = rand.nextInt(16);
        int numCol = rand.nextInt(16);

        //creating the initial head with the headsize
        HydraHead head = new HydraHead(initialHead,headSize);

        //placing initial head in specified grid place
        head.putIn(numCol, numRow, gameGrid);
    }
}