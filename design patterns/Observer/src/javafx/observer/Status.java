package javafx.observer;

import javafx.scene.paint.Color;

/**
 * @author Marildo César | 21/03/2020 10:06:20
 */
public enum Status {
    PARE("Pare!!!", Color.RED),
    ALERTA("Atenção!", Color.YELLOW),
    SIGA("Siga em frente...", Color.GREEN);

    private final String action;
    private final Color color;


    private Status(String action, Color color) {
        this.action = action;
        this.color = color;
    }

    public Color getColor(Status status) {
        return status.equals(this) ? status.color : Color.TRANSPARENT;
    }

    public String getAction() {
        return action;
    }

    public Color getColor() {
        return color;
    }
}
