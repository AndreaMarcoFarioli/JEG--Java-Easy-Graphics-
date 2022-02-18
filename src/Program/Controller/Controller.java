package Program.Controller;

import GameUtilities.Cycle.Behaviour;
import Program.Custom.Ball;
import Program.Custom.FPSLabel;
import Program.View.View;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Controller {
    private final View v;
    public Controller(View v){
        this.v = v;
    }

    public void start() throws Exception {
        try {
            SwingUtilities.invokeAndWait(v::render);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Ball[] balls = new Ball[1000];
        for (int i = 0; i < balls.length; i++){
            balls[i] = new Ball();
        }

        for(Ball b : balls) {
            //b.getTransform().getPoint().setLocation( 750,750);
            v.instantiate(b);
        }
        v.instantiate(new FPSLabel());
        initializeBehaviour();
    }

    public void initializeBehaviour(){
        Behaviour.initializeRuntime();
    }
}
