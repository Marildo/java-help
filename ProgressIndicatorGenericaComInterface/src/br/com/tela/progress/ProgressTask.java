package br.com.tela.progress;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author MCesar
 */
public class ProgressTask {

    private final Pane paneMain;
    private final Label lblMessage;
    private final ProgressIndicator progressIndicator;

    private String styleLabel;
    private String stylePaneCenter;

    private ProgressTask(Pane paneMain) {
        this.paneMain = paneMain;
        lblMessage = new Label();
        progressIndicator = new ProgressIndicator();
        initializeStyles();
    }

    public static void start(Pane contener, ProgressService service) {
        ProgressTask task = new ProgressTask(contener);
        task.show();
        task.process(service);
    }

    public void setStyleLabel(String styleLabel) {
        this.styleLabel = styleLabel;
    }

    public void setStylePaneCenter(String stylePaneCenter) {
        this.stylePaneCenter = stylePaneCenter;
    }

    private void show() {
        double width = paneMain.getWidth();
        double heigth = paneMain.getHeight();
        Rectangle rec = factoryRectangle(width, heigth);

        FlowPane paneCenter = factoryPaneCenter(width, heigth);

        FlowPane paneContener = factoryPaneContener(width, heigth);
        paneContener.getChildren().add(paneCenter);

        setPropertiesLabel(width, heigth);
        setPropertiesProgressIndicator();

        paneMain.getChildren().add(rec);
        paneMain.getChildren().add(paneContener);
    }

    private Rectangle factoryRectangle(double width, double height) {
        Rectangle rec = new Rectangle(width, height);
        rec.setFill(Color.rgb(10, 10, 10, 0.4));
        return rec;
    }

    private FlowPane factoryPaneContener(double width, double height) {
        FlowPane paneContener = new FlowPane();
        paneContener.setPrefWidth(width);
        paneContener.setPrefHeight(height);
        paneContener.setAlignment(Pos.CENTER);
        return paneContener;
    }

    private FlowPane factoryPaneCenter(double width, double height) {
        FlowPane paneCenter = new FlowPane();

        paneCenter.setAlignment(Pos.CENTER);
        paneCenter.setPrefWidth(width * 0.7);
        paneCenter.setPrefHeight(height * 0.7);       
        paneCenter.setStyle(stylePaneCenter);
        
        paneCenter.getChildren().add(progressIndicator);
        paneCenter.getChildren().add(lblMessage);

        System.out.println(paneCenter.getWidth());
        System.out.println(paneCenter.getHeight());
        return paneCenter;
    }

    private void setPropertiesLabel(double width, double height) {
        lblMessage.setPrefWidth(width * 0.7);
        lblMessage.setAlignment(Pos.TOP_CENTER);
        lblMessage.setWrapText(true);
        lblMessage.setStyle(styleLabel);

    }

    private void setPropertiesProgressIndicator() {
        progressIndicator.setPrefSize(60, 60);
        progressIndicator.setStyle("-fx-padding: 5;");
    }

    private void process(ProgressService servico) {
        Service task = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        servico.task().start();
                        while (servico.isRunning()) {
                            updateMessage(servico.getMensagem());

                            Long done = servico.getWorkDone();
                            Long total = servico.getTotalWork();

                            if (total > 0) {
                                updateProgress(done, total);
                            }
                            Thread.sleep(1000);
                        }
                        return null;
                    }

                    @Override
                    protected void succeeded() {
                        paneMain.getChildren().remove(paneMain.getChildren().size() - 2, paneMain.getChildren().size());
                    }

                    @Override
                    protected void failed() {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, getException().getMessage(), getException());
                    }
                };
            }

        };
        lblMessage.textProperty().bind(task.messageProperty());
        progressIndicator.progressProperty().bind(task.progressProperty());
        task.start();
    }

    private void initializeStyles() {
        styleLabel = "-fx-padding: 0 5 0 0; -fx-font-family:Segoe UI; -fx-font-weight: bold; -fx-font-size:12px; -fx-text-fill: #334151;";
        stylePaneCenter = "-fx-background-color: rgba(233,233,233,0.9); -fx-padding: 5;";
    }
}
