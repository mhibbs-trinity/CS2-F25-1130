package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ImageParticle extends Particle {
    private Image img;

    public ImageParticle(Vec2 p, Image i) {
        super(p);
        img = i;
    }
    @Override
    public void display(GraphicsContext g) {
        g.setGlobalAlpha(0.1);       
        g.drawImage(img, pos.x, pos.y);
        g.setGlobalAlpha(1.0);
    }
    
}
