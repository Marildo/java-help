package javafx.observer;

import java.util.Observable;

/**
 *
 * @author Marildo César | 21/03/2020 10:03:25
 */
public class Farol extends Observable {

    void change(Status status) {
        setChanged();
        notifyObservers(status);
    }

}
