module cs3330.hydragame.hydragame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens cs3330.hydragame.hydragame to javafx.fxml;
    exports cs3330.hydragame.hydragame;
}