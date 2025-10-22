package cs2.particles;

import javafx.scene.paint.Color;

public class SolidColor implements ColorPattern {
    private Color col;
    public SolidColor(Color c) { col = c; } 
    public Color getColor() {
        return col;
    }
}
