package design.pattern.strategy.calculo;

/**
 * @author MCesar  10/09/2019 14:46:19
 */
public class Subtracao  implements Calculo{

    @Override
    public Double calcular(Double num01, Double num02) {
         return num01 - num02;
    }

}
