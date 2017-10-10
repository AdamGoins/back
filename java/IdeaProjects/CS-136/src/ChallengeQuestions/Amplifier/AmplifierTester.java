package ChallengeQuestions.Amplifier;

/**
 * Created by root on 4/3/17.
 */
public class AmplifierTester {

    public static void main(String[] args){

        Amplifier[] amps = new Amplifier[3];
        Amplifier amp1 = new InvertingAmplifier(5, 10);
        Amplifier amp2 = new NonInvertingAmplifier(5, 10);
        Amplifier amp3 = new VoltageDividerAmplifier(5, 10);

        amps[0] = amp1;
        amps[1] = amp2;
        amps[2] = amp3;

        for(Amplifier amp : amps){
            System.out.println("-------");
            System.out.println("The amp is a: " + amp.getDescription());
            System.out.println("Resistance 1: " + amp.getR1());
            System.out.println("Resistance 2: " + amp.getR2());
            System.out.println("The gain is: " + amp.getGain());
        }

    }

}
