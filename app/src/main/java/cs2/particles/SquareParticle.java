package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SquareParticle extends Particle {
    public SquareParticle(Vec2 sqPos) {
        super(sqPos);
        col = Color.ORANGERED;
    }

    public void display(GraphicsContext g) {
        g.setFill(col);
        g.fillRect(pos.x,pos.y, size,size);
    }
}
