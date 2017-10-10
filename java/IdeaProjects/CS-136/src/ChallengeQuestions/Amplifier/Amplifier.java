package ChallengeQuestions.Amplifier;

/**
 * Created by root on 4/3/17.
 */
public abstract class Amplifier {

    protected double r1;
    protected double r2;
    protected String description;

    public Amplifier(double r1, double r2, String description){
        this.r1 = r1;
        this.r2 = r2;
        this.description = description;
    }

    public abstract double getGain();

    public abstract String getDescription();


    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }
}
