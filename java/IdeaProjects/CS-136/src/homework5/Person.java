package homework5;

/**
 * Created by root on 3/2/17.
 */
public class Person implements Measurable {

    private String name;
    private int measurement;

    public Person(String name, int measurement){

        this.name = name;
        this.measurement = measurement;
    }


    public String getName(){
        return this.name;
    }


    @Override
    public double getMeasure() {
        return this.measurement;
    }


}
