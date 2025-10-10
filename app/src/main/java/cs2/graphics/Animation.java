package cs2.graphics;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Animation extends Application {

    private GraphicsContext g;
    public double priorX = 0;
    public double priorY = 0;

    private void handleKeyPress(KeyEvent e) {
        System.out.println("Key pressed!!!");
        if(e.getCode() == KeyCode.R) {
            g.setFill(Color.RED);
            g.fillRect(0,0, 600,600);
        }
        if(e.getCode() == KeyCode.SPACE) {
            g.setFill(Color.WHITE);
            g.fillRect(0,0, 600,600);
        }
    }

    public void start(Stage stg) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        stg.setTitle("Thing");
        stg.setScene(scene);
        stg.show();

        g = canvas.getGraphicsContext2D();

        ArrayList<BounceBall> bs = new ArrayList<>();
        for(int ctr=0; ctr<50; ctr++) {
            BounceBall b = new BounceBall(new Vec2(200,200));
            bs.add(b);
        }

        canvas.setOnMousePressed((MouseEvent e) -> {
            BounceBall b = new BounceBall(new Vec2(e.getX(),e.getY()));
            bs.add(b);
            System.out.println(bs.size());
        });

        AnimationTimer timer = new AnimationTimer() {
            // double x = 100;
            // double vx = 3;
            // double y = 100;
            // double vy = 2;

            public void handle(long t) {
                g.setFill(Color.WHITE);
                g.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
                
                for(int i=0; i<bs.size(); i++) {
                    bs.get(i).display(g);
                    bs.get(i).update(canvas);
                }
                // g.setFill(Color.GREEN);
                // g.fillOval(x,y, 100,100);
                // if(x > canvas.getWidth()-100 || x < 0) {
                //     vx = -vx;
                // }
                // if(y > canvas.getHeight()-100 || y < 0) {
                //     vy = -vy;
                // }
                // x += vx;
                // y += vy;
            }
        };
        timer.start();

        canvas.requestFocus();
        canvas.setOnKeyPressed(this::handleKeyPress);
        
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                g.strokeLine(300,300, e.getX(),e.getY());
            }
        });

        canvas.setOnMouseDragged((MouseEvent e) -> {
            g.strokeLine(priorX,priorY, e.getX(),e.getY());
            priorX = e.getX();
            priorY = e.getY();
        });

    }
}