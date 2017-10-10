package hw6;

public class FillInQuestion extends Question {

    public FillInQuestion(String theString){

        String question = theString.substring(0, theString.indexOf("_"));
        String answer = theString.substring(theString.indexOf("_") + 1, theString.lastIndexOf("_"));

        int padding = answer.length();

        for(int i = 0; i < padding; i++){
            question += "_";
        }
        super.setText(question);
        super.setAnswer(answer.toLowerCase());

    }

    @Override
    public boolean checkAnswer(String answer){
        return super.checkAnswer(answer.toLowerCase());
    }

}
