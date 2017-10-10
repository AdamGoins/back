package ChallengeQuestions.Amplifier;

/**
 * Created by root on 4/3/17.
 */
public class NonInvertingAmplifier extends Amplifier {

    public NonInvertingAmplifier(double r1, double r2){
        super(r1, r2, "A Non-inverting Amplifier");
    }

    @Override
    public double getGain() {
        return 1 + (getR2() / getR1());
    }

    @Override
    public String getDescription() {
        return description;
    }
}
