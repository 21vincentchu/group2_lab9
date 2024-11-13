package cs3330.hydragame.hydragame;
//group 2

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class HydraGameApplication extends Application
{
    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage)
    {
        // Set up window icon
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/cs3330/hydragame/hydragame/HydraIcon.png")));

        // Create controller and get layout
        HydraGameController controller = new HydraGameController();

        // Create scene with controller's layout
        Scene scene = new Scene(controller.getLayout(), 850, 850);

        stage.setTitle("Hydra Game");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }
}
//logic for the slider
//when we press play, it shows the head of the size from the slider.

//implement the images to show up when we click play
//logic for clicking the heads
//logic for popping up more heads when clicked, they should be randomly placed,
//additionally have 2-3 heads grow
//decrement sizes after they're all clicked. Initalized head when play is clicked is the headsize at slider
