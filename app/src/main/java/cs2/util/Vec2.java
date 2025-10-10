package cs2.util;

public class Vec2 {
    public double x,y;
    public Vec2() {
        x = 0; y = 0;
    }
    public Vec2(double _x, double _y) {
        x = _x; y = _y;
    }
    public static Vec2 makeRandom(double scale) {
        Vec2 result = new Vec2();
        result.x = Math.random()*scale - (scale/2);
        result.y = Math.random()*scale - (scale/2);
        return result;
    }
    public static Vec2 makeRandom() {
        return makeRandom(2.0);
    }

    public Vec2 add (Vec2 other) {
        return new Vec2(this.x+other.x, this.y+other.y);
    }
    public void addThis(Vec2 other) {
        this.x += other.x;
        this.y += other.y;
    }

}
