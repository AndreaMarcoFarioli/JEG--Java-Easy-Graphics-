package GameUtilities.Components;

import GameUtilities.Handlers.GameObjectStateChanged;
import GameUtilities.Handlers.GameObjectStateListener;

import javax.swing.event.EventListenerList;
import java.awt.*;

public class Transform2DInt {

    private final Point point;
    private final EventListenerList eventListenerList = new EventListenerList();

    public Transform2DInt(int x, int y){
        point = new Point(x, y);
    }

    public Transform2DInt(){
        this(0,0);
    }

    public void translate(int x, int y){
        point.setLocation(point.x + x, point.y + y);
        fireChange();
    }

    public Point getPoint() {
        return point;
    }

    public void onChange(GameObjectStateListener stateListener){
        eventListenerList.add(GameObjectStateListener.class, stateListener);
    }

    public void removeStateListener(GameObjectStateListener stateListener){
        eventListenerList.remove(GameObjectStateListener.class, stateListener);
    }

    public void fireChange(){
        GameObjectStateListener[] listeners = eventListenerList.getListeners(GameObjectStateListener.class);
        for(int i = listeners.length - 1; i >= 0; --i){
            listeners[i].changed(new GameObjectStateChanged(this));
        }
    }
}
