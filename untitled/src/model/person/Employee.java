package model.person;

public class Employee extends Person {
    private String level;
    private String position;
    private float salary;

    public Employee() {
    }

    public Employee(String codePerson, String namePerson, String dateOfBirth, String gender, String identityCard, String phoneNumber, String email, String level, String position, float salary) {
        super(codePerson, namePerson, dateOfBirth, gender, identityCard, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary;
    }

}
