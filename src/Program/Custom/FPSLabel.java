package Program.Custom;

import GameUtilities.Cycle.Behaviour;
import GameUtilities.GameObject.GameObject;
import GameUtilities.GameObject.RenderObject;
import GameUtilities.GameRender;
import GameUtilities.Generics.Time;

import java.awt.*;

public class FPSLabel extends GameObject implements RenderObject {
    private int act, time;
    @Override
    public void start() {
        act = getFPS();
    }

    @Override
    protected void update() {
        time+= Time.getRefreshRate();
        if(time > 100) {
            act = getFPS();
            time = 0;
        }
        stateChanged = true;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("FPS: "+ act, 10,20);
    }
}
