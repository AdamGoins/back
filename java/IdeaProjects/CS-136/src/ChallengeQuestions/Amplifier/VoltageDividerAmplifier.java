package ChallengeQuestions.Amplifier;

/**
 * Created by root on 4/3/17.
 */
public class VoltageDividerAmplifier extends Amplifier {

    public VoltageDividerAmplifier(double r1, double r2){
        super(r1, r2, "A Voltage Divider Amplifier");
    }

    @Override
    public double getGain() {
        return getR2() / (getR2() + getR1());
    }

    @Override
    public String getDescription() {
        return description;
    }
}
