package GameUtilities.Cycle;

import GameUtilities.GameObject.GameObject;
import GameUtilities.Generics.Time;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Behaviour {
    private static final ArrayList<Behaviour> behaviours = new ArrayList<>();
    private static final ArrayList<Timer> timers = new ArrayList<>();
    private final int id;
    private int time;
    private static boolean update = false;
    private static int FPS;
    public Behaviour(){
        id = behaviours.size();
        behaviours.add(this);
    }

    public static void initializeRuntime(){
        update = false;
        for(Behaviour behaviour : behaviours){
            behaviour.start();
        }
        update = true;

        var t = new Timer((int) Time.getRefreshRate() -3, e->{

        });

        Thread gameLoop = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    int size = behaviours.size();
                    long mS, mE;
                    if(update) {
                        mS = System.currentTimeMillis();
                        for(int i = 1; i < size; i++)
                            behaviours.get(i).update();
                        behaviours.get(0).update();

                        //System.out.println("fps:"+(1*Math.pow(10,6)/((mE - mS)+13)));
                        try {
                            Thread.sleep(16);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mE = System.currentTimeMillis();
                        FPS = (int)(1000/(mE-mS));
                    }
                }
            }
        };

        gameLoop.setPriority(10);
        gameLoop.setDaemon(true);
        gameLoop.start();
        //System.out.println(Thread.currentThread().getName());

    }

    public int getId() {
        return id;
    }

    public static int getFPS() {
        return FPS;
    }

    public abstract void start();
    protected abstract void update();
}
