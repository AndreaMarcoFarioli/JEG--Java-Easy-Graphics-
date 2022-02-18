package GameUtilities;

import GameUtilities.Cycle.Behaviour;
import GameUtilities.GameObject.GameObject;
import GameUtilities.GameObject.RenderObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Objects;

public class GameRender extends Behaviour {
    private final ArrayList<Object> gameObjects = new ArrayList<>();
    //protected final Object syncObj = new Object();
    private boolean stateChanged = true, resized = false, visible = false, renderAnyway = false;
    private final JPanel panel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            //hide super to don't clearing
            super.paintComponent(g);
            GameRender.this.paintComponent(g);
        }
    };

    //Da ottimizzare
    protected void paintComponent(Graphics g) {
        var t0 = System.nanoTime();
        Graphics2D da = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        da.setRenderingHints(rh);
        Dimension d = panel.getSize();
       //da.fillRect(0, 0, d.width, d.height);
        //da.setColor(Color.BLACK);

        for(Object gameObject : gameObjects){
            boolean state = ((GameObject)gameObject).getStateAndErase();
            if(!state && !renderAnyway)
                continue;
            ((RenderObject)gameObject).render(da);
        }
        var t1 = System.nanoTime();
        double m = ((double) t1-t0)*Math.pow(10,-6);
        if(m > 1)

            System.out.println(m);
        resized = false;
        visible = false;
    }

    @Override
    public void start() {
        System.out.println("anche io ci sono");
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                resized = true;
                renderAnyway =true;
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                visible = true;
                renderAnyway = true;
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                renderAnyway = true;
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                renderAnyway = true;
            }
        });
    }

    @Override
    public void update() {
        if(stateChanged){
            stateChanged = false;
            panel.repaint();
        }
        System.out.println("repain");
    }



    public void instantiate(Object object){
        ((GameObject)object).onStateChanged(e-> stateChanged = true);
        gameObjects.add(object);
        stateChanged = true;
    }

    public JPanel getPanel() {
        return panel;
    }

    public Object findGameObject(String name){
        Object obj = null;
        for (Object object : gameObjects)
            if(Objects.equals(((GameObject) object).getName(), name)){
                obj = object;
                break;
            }
        return obj;
    }
}