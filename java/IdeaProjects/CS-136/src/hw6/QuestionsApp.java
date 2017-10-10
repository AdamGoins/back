package hw6;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionsApp
{

   static int correctCount = 0;

   public static void main(String[] args)
   {
      // Creates a new ArrayList that stores Question objects
      ArrayList<Question> questions = new ArrayList<>();

      // Creates new NumericQuestion objects
      NumericQuestion numQ = new NumericQuestion();
      numQ.setText("What are the first 3 digits of Pi?");
      numQ.setAnswer("3.14");
      questions.add(numQ);

      NumericQuestion numQ2 = new NumericQuestion();
      numQ2.setText("How old am I?");
      numQ2.setAnswer("22");
      questions.add(numQ2);

      //----------------------------


      // Creates FillInQuestion objects
      FillInQuestion fillIn1 = new FillInQuestion("I love _Ryan Gosling_");
      questions.add(fillIn1);

      FillInQuestion fillIn2 = new FillInQuestion("My first name is _Adam_");
      questions.add(fillIn2);
      //-----------------------------

      // Creates AnyCorrectChoice question objects
      AnyCorrectChoice any = new AnyCorrectChoice();
      any.setText("Who is one of my favorite actors?");
      any.addChoice("Ryan Gosling", true);
      any.addChoice("Beiber", false);
      any.addChoice("Liam Neesons", true);
      any.addChoice("Rick Sanchez", false);
      questions.add(any);

      AnyCorrectChoice any2 = new AnyCorrectChoice();
      any2.setText("Which of these are Object Oriented programming languages");
      any2.addChoice("Python", true);
      any2.addChoice("Java", true);
      any2.addChoice("Matlab", false);
      any2.addChoice("C", false);
      questions.add(any2);
      //----------------------------

      // Enhanced for-loop that loops through all 6 questions in the Questions ArrayList.
      for(Question question : questions){
         presentQuestion(question);

      }

   }

   /**
      Presents a question to the user and checks the response.
      @param q the question
   */
   public static void presentQuestion(Question q)
   {

      System.out.println("--------------------");
      q.display();
      System.out.print("Your answer: ");
      Scanner in = new Scanner(System.in);
      String response = in.nextLine();
      boolean correct = q.checkAnswer(response);

      // If the answer is correct, it awards to appropriate points for the answer.
      if(correct){
         System.out.println("That is correct!");
         if(q instanceof NumericQuestion){
           correctCount += 1;
         }
         else if(q instanceof FillInQuestion){
            correctCount += 2;
         }

         else if(q instanceof AnyCorrectChoice){
            correctCount += 3;
         }

      }

      else{
         System.out.println("That is incorrect.");
      }

      System.out.println("Your score is " + correctCount + "/12\n--------------------\n");
   }

}

