/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author Marildo
 */
public class MainController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label lblStatus;
    @FXML
    private ProgressIndicator progress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onStart(ActionEvent event) {

        Service<Void> myService = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        //  updateProgress(1, 5); // setando a % de carregamento
                        updateMessage("Esperando o palmeiras ganhar um mudial");

                        esperarPalmeirasGanharOMundial(5);
                        //  updateProgress(2, 5);
                        updateMessage("Vai esperar mais um pouco..");

                        esperarPalmeirasGanharOMundial(5);
                        // updateProgress(3, 5);
                        updateMessage("Ainda esperando!");

                        esperarPalmeirasGanharOMundial(5);
                        //  updateProgress(5, 5);
                        updateMessage("Desisto");

                        return null;
                    }

                    @Override
                    protected void succeeded() {
                        progress.progressProperty().unbind();
                        progress.setVisible(false);
                    }

                };
            }

        };

        progress.progressProperty().bind(myService.progressProperty());
        lblStatus.textProperty().bind(myService.messageProperty());
        myService.start();
    }

    public void esperarPalmeirasGanharOMundial(long anos) throws InterruptedException {
        Thread.sleep(anos * 1000);
    }
}
