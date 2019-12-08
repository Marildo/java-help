package factory.method.pattern;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MCesar 07/10/2019 10:40:20
 */
public class FactoryMethodPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Esporte esporte01 = EsporteFactory.newEsporte(EsporteFactory.TipoEsporte.TENIS);
        Logger.getGlobal().log(Level.INFO, "N\u00ba jogadores{0}", esporte01.numeroDeJogadores());

        Esporte esporte02 = EsporteFactory.newEsporte(EsporteFactory.TipoEsporte.FUTEBOL);
        Logger.getGlobal().log(Level.INFO, "N\u00ba jogadores{0}", esporte02.numeroDeJogadores());

        Esporte esporte03 = EsporteFactory.newEsporte(EsporteFactory.TipoEsporte.TENIS);
        Logger.getGlobal().log(Level.INFO, "N\u00ba jogadores{0}", esporte03.numeroDeJogadores());
    }

}
