package model;

public class Employee extends Person{
    private static Long nextId = 1L;
    public Employee(String name, int age, String cpf) {
        super(nextId++, name, age, cpf);
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age + ", " + cpf;
    }

}
