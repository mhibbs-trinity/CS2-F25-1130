package cs2.graphics;

import cs2.util.Vec2;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BounceBall {
    private Vec2 pos;
    private Vec2 vel;
    public BounceBall(Vec2 p) {
        pos = p;
        vel = Vec2.makeRandom(10);
    }
    public void display(GraphicsContext g) {
        g.setFill(Color.GREEN);
        g.fillOval(pos.x,pos.y, 40,40);
    }
    public void update(Canvas canvas) {
        if(pos.x > canvas.getWidth()-40 || pos.x < 0) {
            vel.x = -vel.x;
        }
        if(pos.y > canvas.getHeight()-40 || pos.y < 0) {
            vel.y = -vel.y;
        }
        pos.x += vel.x;
        pos.y += vel.y;
    }
}
