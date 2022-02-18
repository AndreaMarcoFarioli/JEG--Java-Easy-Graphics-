package GameUtilities.Components.Colliders;


import GameUtilities.Components.Collider;

import java.awt.*;

public class RectCollider extends Collider {
    private Point position, size;

    public RectCollider(Point position, Point size){
        this.position = position;
        this.size = size;
    }

    public RectCollider(int xP, int yP, int xS, int yS){

    }

    @Override
    public boolean detection(RectCollider collider) {
        return false;
    }

    @Override
    public String toString() {
        return "RectCollider{" +
                "position=" + position +
                ", size=" + size +
                '}';
    }
}
