package GameUtilities.Handlers;

import java.util.EventListener;

@FunctionalInterface
public interface GameObjectStateListener extends EventListener {
    void changed(GameObjectStateChanged stateChanged);
}
