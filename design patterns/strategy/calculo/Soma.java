package design.pattern.strategy.calculo;

/**
 * @author MCesar 09/09/2019 17:28:34
 */
public class Soma implements Calculo {

    @Override
    public Double calcular(Double num01, Double num02) {
        return num01 + num02;
    }

}
