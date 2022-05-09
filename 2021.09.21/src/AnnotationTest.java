/**
 * @author lixhui
 * @create 2021-09-13:26
 */
public class AnnotationTest {
}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface info{
    void show();
}

class Student extends Person implements info{
    @Override
    public void walk() {
        System.out.println("学生走路比较快");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭比较快");
    }

    @Override
    public void show() {
        System.out.println("学生可以参加比赛，展示自身的才能");
    }
}
