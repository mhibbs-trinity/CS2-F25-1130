package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Particle {
    protected Vec2 pos;
    protected Vec2 vel;
    protected Color col;
    protected double size;
    public Particle(Vec2 p, Vec2 v, Color c, double s) {
        pos = p;
        vel = v;
        col = c;
        size = s;
    }
    public Particle(Vec2 p) {
        this(p, Vec2.makeRandom(10), Color.DARKTURQUOISE, 20);
    }
    public void applyForce(Vec2 force) {
        vel.addThis(force);
    }
    public abstract void display(GraphicsContext g);

    public void update(Canvas canvas) {
        /*
        if(pos.x > canvas.getWidth()-size || pos.x < 0) {
            vel.x = -vel.x;
        }
        if(pos.y > canvas.getHeight()-size || pos.y < 0) {
            vel.y = -vel.y;
        }*/
        pos.x += vel.x;
        pos.y += vel.y;
    }
}
