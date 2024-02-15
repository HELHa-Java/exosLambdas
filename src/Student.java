public class Student {
    private String name;
    private int age;
    private double note;

    public Student(String name, int age, double note) {
        this.name = name;
        this.age = age;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Nom: " + name + ", Age: " + age + ", Note: " + note;
    }
}