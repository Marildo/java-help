package br.com.tela.progress;

/**
 * @author MCesar
 */
public interface ProgressService {
    
     Thread task() ;

     boolean isRunning();

     String getMensagem();

     long getWorkDone();

     long getTotalWork();
}
