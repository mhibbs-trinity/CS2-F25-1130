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
        parts.add(new Particle(origin));
    }
    public void display(GraphicsContext g) {
        for(Particle p : parts) {
            p.display(g);
        }
    }
    public void update(Canvas can) {
        for(Particle p : parts) {
            p.update(can);
        }
    }

}
