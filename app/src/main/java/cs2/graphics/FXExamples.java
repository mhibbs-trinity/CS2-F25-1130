package cs2.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXExamples extends Application {
    public void start(Stage stg) {
        Canvas canvas = new Canvas(800,600);
        Scene scene = new Scene(new StackPane(canvas));
        stg.setTitle("Some window title");
        stg.setScene(scene);
        stg.show();

        GraphicsContext g = canvas.getGraphicsContext2D();

        g.strokeRect(100,200, 300,200);

        g.setFill(Color.ORANGERED);
        g.fillOval(100,200, 300,200);

        g.setStroke(Color.rgb(78, 54, 78));
        g.setLineWidth(20);
        g.strokeLine(100,200, 400,400);

    }
}
