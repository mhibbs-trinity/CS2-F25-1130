package cs2.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ShapeExamples extends Application {

    public static void drawCircle(GraphicsContext g, double x, double y, double r) {
        g.strokeOval(x-r,y-r, 2*r,2*r);
        if(r > 20) {
            drawCircle(g, x-r,y, r/2);
            drawCircle(g, x+r,y, r/2);
            drawCircle(g, x,y-r, r/2);
            drawCircle(g, x,y+r, r/2);
        }
    }

    public void start(Stage stg) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        stg.setTitle("Thing");
        stg.setScene(scene);
        stg.show();

        GraphicsContext g = canvas.getGraphicsContext2D();
        drawCircle(g, 300,300, 150);
        /*
        g.fillRect(100,300, 400, 450);
        g.fillOval(100,100, 400,400);
        g.fillOval(100,550, 400,400);

        g.setFill(Color.LIGHTBLUE);
        g.fillArc(100,100, 400,400, 180,180, ArcType.ROUND);
        g.fillArc(100,200, 200,200, 0,180, ArcType.ROUND);
        g.fillArc(300,200, 200,200, 0,180, ArcType.ROUND);

        double[] xs = {300, 325, 300, 275};
        double[] ys = {300, 325, 350, 325};
        g.setFill(Color.BLACK);
        g.fillPolygon(xs,ys, 4);

        g.setLineWidth(2);
        g.setStroke(Color.ORANGE);
        for(int x=0; x<600; x++) {
            g.setStroke(Color.rgb((int)(x/600.0*255),0,0));
            g.strokeLine(x,0 ,x,800);
        }
        */

    }
}