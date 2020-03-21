package javafx.observer;

import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author MCesar
 */
public class FarolController implements Initializable {

    private Farol farol = new Farol();
    private int index = -1;
    private Timeline timeline;

    @FXML
    private AnchorPane contener;

    @FXML
    private Circle clicle_pare;

    @FXML
    private Circle clicle_atencao;

    @FXML
    private Circle clicle_siga;

    public FarolController() {
        KeyFrame frame = new KeyFrame(Duration.seconds(7), (event) -> change());
        timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline.play();
    }

    public void addObserver(Observer observer) {
        farol.addObserver(observer);
    }

    public void deleteObserver(Observer observer) {
        farol.deleteObserver(observer);
    }

    private void change() {
        changeIndex();
        Status status = Status.values()[index];
        farol.change(status);

        Platform.runLater(() -> {
            clicle_pare.setFill(Status.PARE.getColor(status));
            clicle_atencao.setFill(Status.ALERTA.getColor(status));
            clicle_siga.setFill(Status.SIGA.getColor(status));
        });
    }

    private void changeIndex() {
        index++;
        if (index > 2) {
            index--;
            close();
        }
    }

    private void close() {
        farol.deleteObservers();
        Stage stage = (Stage) contener.getScene().getWindow();
        stage.close();
    }
}
