package GameUtilities.Components;

import java.util.ArrayList;

public class Physics {
    private double mass;
    private ArrayList<Force> forces = new ArrayList<>(3);


    public Physics(double mass){
        this.mass = mass;
    }

    /**
     *
     * @param force
     * @param theta
     * @param forceType
     * @param forceDecrease
     */
    public void addForce(double force, double theta, Force.ForceType forceType, Force.ForceDecrease forceDecrease){
        forces.add(new Force(force, theta, forceType, forceDecrease));
    }

    public void nextStep(){

    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
