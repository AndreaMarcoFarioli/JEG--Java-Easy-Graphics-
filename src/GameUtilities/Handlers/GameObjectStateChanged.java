package GameUtilities.Handlers;

import java.util.EventObject;

public class GameObjectStateChanged extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public GameObjectStateChanged(Object source) {
        super(source);
    }
}
