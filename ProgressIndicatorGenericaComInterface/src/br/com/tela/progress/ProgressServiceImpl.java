package br.com.tela.progress;

import java.util.Observable;

/**
 * @author MCesar
 */
public abstract class ProgressServiceImpl extends Observable implements ProgressService {

    private boolean running;
    private String mensagem;
    private long workDone;
    private long totalWork;

    @Override
    public Thread task() {
        running = true;
        mensagem = "";
        return new Thread(() -> {
            process();
            running = false;
        });
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    @Override
    public long getWorkDone() {
        return workDone;
    }

    @Override
    public long getTotalWork() {
        return totalWork;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setWorkDone(long workDone) {
        this.workDone = workDone;
    }

    public void setTotalWork(long totalWork) {
        this.totalWork = totalWork;
    }

    public abstract void process();
}
