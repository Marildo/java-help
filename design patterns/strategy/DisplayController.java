package design.pattern.strategy;

import design.pattern.strategy.calculo.Divisao;
import design.pattern.strategy.calculo.Multiplicacao;
import design.pattern.strategy.calculo.RaizQuadrada;
import design.pattern.strategy.calculo.Soma;
import design.pattern.strategy.calculo.Subtracao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MCesar
 */
public class DisplayController implements Initializable {

    private Calculadora calculadora;

    @FXML
    private Label lbl_Hitorico;
    @FXML
    private Label lbl_digitado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculadora = new Calculadora();
    }

    @FXML
    private void onClickBtn(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String value = btn.getText();
        System.out.println("> " + value);

        switch (value) {
            case "=":
                calculadora.setNum02(Double.parseDouble(lbl_digitado.getText()));
                calculadora.calcular();
                setHistorico(lbl_digitado.getText(), " = " + calculadora.getResultado().toString());
                lbl_digitado.setText(calculadora.getResultado().toString());
                break;
            case "+":
            case "-":
            case "X":
            case "/":
                setOperacao(value);
                break;
            case "²√":
                calculadora.setNum01(Double.parseDouble(lbl_digitado.getText()));
                calculadora.setCalculo(new RaizQuadrada());
                calculadora.calcular();
                setHistorico(value + " " + lbl_digitado.getText(), " = " + calculadora.getResultado().toString());
                lbl_digitado.setText(calculadora.getResultado().toString());
                break;
            case "+/-":
                Double d = Double.valueOf(lbl_digitado.getText()) * -1;
                lbl_digitado.setText(d.toString());
                break;
            case "C":
                lbl_Hitorico.setText("");
                lbl_digitado.setText("0");
                calculadora.resete();
                break;
            case "OFF":
                System.exit(0);
                break;
            default:
                if (lbl_digitado.getText().equals("0")) {
                    lbl_digitado.setText(value.trim());
                } else {
                    lbl_digitado.setText(lbl_digitado.getText() + value.trim());
                }
        }
    }

    private void setOperacao(String operador) {
        switch (operador) {
            case "+":
                calculadora.setCalculo(new Soma());
                break;
            case "-":
                calculadora.setCalculo(new Subtracao());
                break;
            case "X":
                calculadora.setCalculo(new Multiplicacao());
                break;
            case "/":
                calculadora.setCalculo(new Divisao());
                break;
        }

        calculadora.setNum01(Double.parseDouble(lbl_digitado.getText()));
        setHistorico(lbl_digitado.getText(), operador);
        lbl_digitado.setText("");
    }

    private void setHistorico(String v0, String v1) {
        lbl_Hitorico.setText(String.format("%s %s %s  ", lbl_Hitorico.getText(), v0, v1));
    }
}
