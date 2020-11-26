package br.com.tela;

import br.com.tela.progress.ProgressTask;
import br.com.tela.services.OneService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author MCesar
 */
public class MasterController implements Initializable {

    @FXML
    private AnchorPane paneMain;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onTaksOne(ActionEvent event) {
        OneService serviceOne = new OneService();
        ProgressTask.start(paneMain, serviceOne);
    }

    @FXML
    private void onBuscaCep(ActionEvent event) throws MalformedURLException, IOException {
        URL url = getClass().getResource("ViaCEP.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Consulta de endereço por CEP");
        stage.show();
    }

}
