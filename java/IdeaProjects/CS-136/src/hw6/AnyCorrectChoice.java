package hw6;

import java.util.ArrayList;

public class AnyCorrectChoice extends ChoiceQuestion {

    String answers = "";

    public AnyCorrectChoice(){

        // Empty constructor

    }

    @Override
    public void addChoice(String choice, boolean correct){
        // Calls the superclass "addChoice()" method
        super.addChoice(choice, correct);

        if(correct){
            // Adds the answer to our list of correct choices
            // Replaces all spaces with underscores because we're going to split the string by a space in the checkanswer() method.
            answers += " " + choice.replaceAll(" ", "_");
        }

    }

    @Override
    public boolean checkAnswer(String answer){

        // Checks if their answer is in the list of correct answers. (Overridden from the superclass)
        for(String correctAnswer : answers.split(" ")){

            // Spaces in answers were replaced by underscores when being added to the answers string, this is where we put them back.
            if(answer.equalsIgnoreCase(correctAnswer.replaceAll("_", " "))){

                return true;
            }
        }
        return false;
    }


    @Override
    public void display(){
        super.display();
        System.out.println("Note, there may be several correct answers");

    }

}
