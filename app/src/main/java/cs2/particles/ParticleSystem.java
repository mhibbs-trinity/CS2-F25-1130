package cs2.particles;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ParticleSystem {
    private ArrayList<Particle> parts;
    private Vec2 origin;
    public ParticleSystem(Vec2 o) {
        origin = o;
        parts = new ArrayList<>();
    }
    public void addParticle() {
        if(Math.random() < 0.5) {
            parts.add(new SquareParticle(origin.clone()));
        } else {
            parts.add(new RoundParticle(origin.clone()));
        }
    }
    public void applyForce(Vec2 force) {
        for(Particle p : parts) {
            p.applyForce(force);
        }
    }
    public void display(GraphicsContext g) {
        for(Particle p : parts) {
            p.display(g);
        }
        System.out.println(parts.size());
    }
    public void update(Canvas can) {
        for(Particle p : parts) {
            p.update(can);
        }
    }

}
