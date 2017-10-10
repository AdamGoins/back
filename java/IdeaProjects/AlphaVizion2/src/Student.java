/**
 * Created by Adam on 1/29/2017.
 */
public class Student extends Person {

    private String GPA;
    private String major;

    public Student(String name, int age, String major, String GPA){

        super(name, age);

        this.major = major;
        this.GPA = GPA;

        String x = "Hey!";

        char[] chars = new char[] {'H', 'e', 'y', '!'};



    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
