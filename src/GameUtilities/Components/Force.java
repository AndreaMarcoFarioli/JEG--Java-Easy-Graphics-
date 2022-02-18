package GameUtilities.Components;

public class Force {
    public enum ForceType {Impulse};
    public enum ForceDecrease {NoDecrease, ConstantVelocity}
    private double force, theta;
    private ForceType forceType;
    private ForceDecrease forceDecrease;

    public Force(double force, double theta, Force.ForceType forceType, Force.ForceDecrease forceDecrease){
        this.force = force;
        this.theta = theta;
        this.forceType = forceType;
        this.forceDecrease = forceDecrease;
    }

    public double getForce() {
        return force;
    }

    public double getTheta() {
        return theta;
    }

    public ForceDecrease getForceDecrease() {
        return forceDecrease;
    }

    public ForceType getForceType() {
        return forceType;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public void setForceDecrease(ForceDecrease forceDecrease) {
        this.forceDecrease = forceDecrease;
    }

    public void setForceType(ForceType forceType) {
        this.forceType = forceType;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }
}
