package hw6;

public class NumericQuestion extends Question {

    public NumericQuestion(){

    }


    @Override
    public boolean checkAnswer(String response){

        if(super.checkAnswer(response)) return true;

        boolean result;
        double value = Double.parseDouble(response);

        for(double i = value - 0.01; i <= value + 0.01; i += 0.01){

            String answer =  String.format("%.2f", i);

            result = super.checkAnswer(answer);
            if(result){
                return true;
            }
        }

        return false;

    }


}
