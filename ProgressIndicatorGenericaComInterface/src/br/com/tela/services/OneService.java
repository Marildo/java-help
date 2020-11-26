package br.com.tela.services;

import br.com.tela.progress.ProgressServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marildo Cesar 26/11/2020
 */
public class OneService extends ProgressServiceImpl {

    private final int COUNT = 10;

    @Override
    public void process() {
        String message = "Processando...";
        setMensagem(message);
        setTotalWork(COUNT);

        for (int i = 0; i < COUNT; i++) {
            setWorkDone(i);
            try {
                Thread.sleep(1000);
                message += message;
                setMensagem(message);
            } catch (InterruptedException ex) {
                Logger.getLogger(OneService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
