package javafx.observer;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Marildo César | 21/03/2020 09:58:24
 */
public class CarroController implements Initializable, Observer {

    @FXML
    private Button button;
    @FXML
    private Label lbl_status;
    @FXML
    private Rectangle rec_instrucao;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        lbl_status.setText("Siga até o farol...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/farol.fxml"));
        Parent root = loader.load();

        FarolController ctrl = loader.getController();
        ctrl.addObserver(this);

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getWidth() / 2;
        stage.setX(x);
        stage.setY(3);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void update(Observable o, Object arg) {
        Status status = (Status) arg;
        lbl_status.setText(status.getAction());
        rec_instrucao.setStroke(status.getColor());
    }
}
