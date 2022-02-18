package Program.Custom;

import GameUtilities.Components.Collider;
import GameUtilities.Components.Colliders.RectCollider;
import GameUtilities.GameObject.GameObject;
import GameUtilities.Components.Transform2DInt;

public class Block extends GameObject {
    public Block(int x, int y, int z){
        setCollider(null);
        setTransform(new Transform2DInt());
    }

    @Override
    public void start() {

    }

    @Override
    protected void update() {

    }
}
