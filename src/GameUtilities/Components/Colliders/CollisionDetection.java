package GameUtilities.Components.Colliders;

import GameUtilities.Components.Collider;

@FunctionalInterface
public interface CollisionDetection {
    boolean detection(RectCollider collider);
}
