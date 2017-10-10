/**
 * Created by Adam on 1/29/2017.
 */
public class Person {

    protected String name;
    private int age;

    int personCounter = 0;
    public Person(String name, int age){

        this.name = name;
        this.age = age;


    }

    public void saySomething(String something){

        System.out.println(something);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
