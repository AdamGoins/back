package homework5;

public class Quiz implements Measurable {

    private double score;
    private String lettergrade;

    public Quiz(double score, String lettergrade){
        this.score = score;
        this.lettergrade = lettergrade;

    }

    public double getScore(){
        return this.score;
    }

    public String getGrade(){
        return this.lettergrade;
    }

    @Override
    public double getMeasure() {
        return this.score;
    }
}
