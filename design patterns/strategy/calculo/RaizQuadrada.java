package design.pattern.strategy.calculo;

/**
 * @author MCesar 10/09/2019 15:35:37
 */
public class RaizQuadrada implements Calculo {

    @Override
    public Double calcular(Double num01, Double num02) {
        return Math.sqrt(num01);
    }

}
