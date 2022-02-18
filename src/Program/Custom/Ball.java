package Program.Custom;

import GameUtilities.Components.Colliders.RectCollider;
import GameUtilities.Components.Physics;
import GameUtilities.Components.Transform2DInt;
import GameUtilities.GameObject.*;
import GameUtilities.Generics.Time;
import Program.Main;

import javax.swing.*;
import java.awt.*;

public class Ball extends GameObject implements RenderObject {
    double k = 0.0;
    boolean x = false, y = false;
    int m = 0;
    Color c = new Color((int)(Math.random() * 0x1000000));
    int ma = ((int)(Math.random()*100))%10;

    //da sistemare
    public Ball(){
        Transform2DInt transform = new Transform2DInt();
        setCollider(new RectCollider(transform.getPoint(), new Point(20,20)));
        setPhysics(new Physics(1));
        setTransform(transform);
        transform.onChange(e-> fireChange());
        Timer timer = new Timer(10, e->{
            k+=0.01;
        });
        timer.start();
    }

    @Override
    public void start() {
        System.out.println("Spawno anche io");
        transform.getPoint().setLocation((Math.random()*1000)%700,(Math.random()*1000)%500);
    }

    @Override
    protected void update() {

        //System.out.println(",");
        var t = new Thread() {
            @Override
            public void run() {
                super.run();
                if(k > 1000 && ma > 0) {
                    c = new Color((int) (Math.random() * 0x1000000));
                    k = 0;
                }
                    k += Time.getRefreshRate();
                int xVect = x ? -1 : 1, yVect = y ? -1 : 1;

                    if (k > 1) {
                        getTransform().translate(ma * xVect, ma * yVect);
                        if (transform.getPoint().x > Main.v.getGameRenderSize().width - 20 && !x) {
                            x = true;
                            transform.getPoint().setLocation(Main.v.getGameRenderSize().width - 20, transform.getPoint().y);
                        } else if (transform.getPoint().x < 0 && x) {
                            x = false;
                            transform.getPoint().setLocation(0, transform.getPoint().y);
                        }
                        if (transform.getPoint().y > Main.v.getGameRenderSize().height - 20 && !y) {
                            y = true;
                            transform.getPoint().setLocation(transform.getPoint().x,  Main.v.getGameRenderSize().height - 20);
                        } else if (transform.getPoint().y < 0 && y) {
                            y = false;
                            transform.getPoint().setLocation(transform.getPoint().x, 0);
                        }
                        //k = 0;
                    }
                //System.out.println(Ball.this.getName());
            }
        };
        t.start();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(c);
        g.fillOval( transform.getPoint().x,transform.getPoint().y, 20,20);
    }
}
