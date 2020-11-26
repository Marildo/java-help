package br.com.tela;

import br.com.tela.progress.ProgressTask;
import br.com.tela.services.ViaCEPService;
import java.net.URL;
import java.util.Map;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MCesar
 */
public class ViaCEPController implements Initializable, Observer {

    @FXML
    private TextField txf_cep;
    @FXML
    private TextArea txa_resultado;
    @FXML
    private AnchorPane paneMaster;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onBuscar(ActionEvent event) {
        try {
            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher matcher = pattern.matcher(txf_cep.getText());
            String number = matcher.replaceAll("");

            int cep = Integer.parseInt(number);

            ViaCEPService viaCEPService = new ViaCEPService(cep);
            viaCEPService.addObserver(this);
            ProgressTask.start(paneMaster, viaCEPService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        Map<String, String> endereco = (Map) arg;
        StringBuilder builder = new StringBuilder();
        endereco.forEach((key, value) -> {
            builder.append(key).append(": ").append(value).append("\n");
        });
        txa_resultado.setText(builder.toString());
    }

}
