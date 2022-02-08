package gof_patterns.Pattern6_Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeCompositeExample {
    public static void main(String[] args) {

        Employee emp1 = new Developer("Ivan", 10000);
        Employee emp2 = new Developer("Michael", 15000);
        Employee emp3 = new Developer("John", 12000);
        Employee emp4 = new Developer("Junior", 14000);

        Employee manager1 = new Manager("Nick", 20000);
        Employee manager2 = new Manager("Dong", 18000);

        manager1.add(emp1);
        manager1.add(emp2);

        manager2.add(emp3);
        manager2.add(emp4);

        Manager generalManager = new Manager("Mark", 50000);
        generalManager.add(manager1);
        generalManager.add(manager2);

        Employee emp5 = new Developer("Peter", 20000);
        generalManager.add(emp5);

        generalManager.print();

    }

}

interface Employee {
    void add(Employee employee);
    void remove(Employee employee);
    Employee getChild(int i);
    String getName();
    double getSalary();
    void print();
}

class Manager implements  Employee {
    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    List<Employee> employees = new ArrayList();

    public void add(Employee employee) {
        employees.add(employee);
    }


    public Employee getChild(int i) {
        return (Employee) employees.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void print() {
        System.out.println("---------------");
        System.out.println("Name = " + getName());
        System.out.println("Salary = " + getSalary());
        System.out.println("Position = " + getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1));
        System.out.println("---------------");

        Iterator<Employee> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            employee.print();
        }
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}

class Developer implements Employee {

    private  String name;
    private double salary;
    List<Employee> employees = new ArrayList();
    List<Developer> developers = new ArrayList<>();

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void add(Employee employee) {
        //this is leaf-node so this method is not applicable to this class
        employees.add(employee);
    }

    public Employee getChild(int i) {
        //this is leaf-node so this method is not applicable to this class
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void print() {
        System.out.println("---------------");
        System.out.println("Name = " + getName());
        System.out.println("Salary = " + getSalary());
        System.out.println("Position = " + getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1));
        System.out.println("---------------");

    }

    public void remove(Employee employee) {
        //this is leaf-node so this method is not applicable to this class
    }

}


