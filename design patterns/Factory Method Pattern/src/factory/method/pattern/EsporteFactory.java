package factory.method.pattern;

/**
 *
 * @author MCesar 07/10/2019 11:05:36
 */
public class EsporteFactory {

    public enum TipoEsporte {
        FUTEBOL, TENIS, UFC;
    }

    public static Esporte newEsporte(TipoEsporte tipo) {
        Esporte esporte = null;
        switch (tipo) {
            case FUTEBOL:
                esporte = new Futebol();
                break;
            case TENIS:
                esporte = new Tenis();
                break;
            case UFC:
                esporte = new UFC();
                break;
        }
        return esporte;
    }

}
