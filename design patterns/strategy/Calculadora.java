package design.pattern.strategy;

import design.pattern.strategy.calculo.Calculo;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author MCesar 09/09/2019 17:14:57
 */
public class Calculadora {

    private Calculo calculo;
    private Double num01;
    private Double num02;
    private Double resultado;

    public void calcular() {
        resultado = new BigDecimal(calculo.calcular(num01, num02))
                .setScale(3, RoundingMode.HALF_EVEN)
                .doubleValue();
    }

    public Calculo getCalculo() {
        return calculo;
    }

    public void setCalculo(Calculo calculo) {
        this.calculo = calculo;
    }

    public Double getNum01() {
        return num01;
    }

    public void setNum01(Double num01) {
        this.num01 = num01;
    }

    public Double getNum02() {
        return num02;
    }

    public void setNum02(Double num02) {
        this.num02 = num02;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    void resete() {
        num01 = 0.0;
        num02 = 0.0;
        calculo = null;
    }

}
