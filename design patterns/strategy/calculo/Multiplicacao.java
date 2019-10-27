package design.pattern.strategy.calculo;

/**
 * @author MCesar  10/09/2019 14:47:20
 */
public class Multiplicacao  implements Calculo{

    @Override
    public Double calcular(Double num01, Double num02) {
         return num01 * num02;
    }

}

