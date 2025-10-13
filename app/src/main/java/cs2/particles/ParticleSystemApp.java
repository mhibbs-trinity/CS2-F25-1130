package cs2.particles;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ParticleSystemApp extends Application {

    private GraphicsContext g;
    public Vec2 wind = new Vec2();
    
    public void start(Stage stg) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        stg.setTitle("Prticles!");
        stg.setScene(scene);
        stg.show();

        g = canvas.getGraphicsContext2D();

        ArrayList<ParticleSystem> pss = new ArrayList<>();

        Vec2 gravity = new Vec2(0,0.5);
        
        canvas.setOnMouseMoved((MouseEvent e) -> {
            wind = new Vec2(e.getX() / 300.0 - 1,0);
        });

        canvas.setOnMousePressed( (MouseEvent e) -> {
            ParticleSystem newPS = new ParticleSystem(new Vec2(e.getX(),e.getY()));
            pss.add(newPS);
        } );

        Image img = new Image("file:star.png");
        

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long time) {
                g.setFill(Color.WHITE);
                g.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

                g.drawImage(img, 100,100);

                for(ParticleSystem ps : pss) {
                    ps.addParticle();
                    ps.display(g);
                    ps.update(canvas);
                    ps.applyForce(gravity);
                    ps.applyForce(wind);
                }
            }
        };
        timer.start();

    }
}