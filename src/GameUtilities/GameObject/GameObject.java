package GameUtilities.GameObject;

import GameUtilities.Cycle.Behaviour;
import GameUtilities.Components.Collider;
import GameUtilities.Components.Transform2DInt;
import GameUtilities.Handlers.GameObjectStateChanged;
import GameUtilities.Handlers.GameObjectStateListener;
import GameUtilities.Components.Physics;

import javax.swing.event.EventListenerList;

public abstract class GameObject extends Behaviour {
    protected Physics physics;
    protected Collider collider;
    protected Transform2DInt transform;
    protected boolean stateChanged;
    protected EventListenerList eventListenerList = new EventListenerList();
    private String name;
    private static int count;
    private final int id;

    public GameObject(){
        name = "GameObject("+count+")";
        id = count;
        count++;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }

    public void setPhysics(Physics physics) {
        this.physics = physics;
    }

    public void setTransform(Transform2DInt transform) {
        this.transform = transform;
    }

    public boolean getStateAndErase(){
        boolean stateChanged = this.stateChanged;
        this.stateChanged = false;
        return stateChanged;
    }

    public Physics getPhysics() {
        return physics;
    }

    public Collider getCollider() {
        return collider;
    }

    public Transform2DInt getTransform() {
        return transform;
    }

    public void onStateChanged(GameObjectStateListener stateListener){
        eventListenerList.add(GameObjectStateListener.class, stateListener);
    }

    public void removeStateChangedEvent(GameObjectStateListener stateListener){
        eventListenerList.remove(GameObjectStateListener.class, stateListener);
    }

    public void fireChange(){
        GameObjectStateListener[] listeners = eventListenerList.getListeners(GameObjectStateListener.class);
        this.stateChanged = true;
        for(int i = listeners.length-1; i >= 0; --i){
            listeners[i].changed(new GameObjectStateChanged(this));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int gameObjectId() {
        return id;
    }
}
