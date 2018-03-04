package com.netcracker;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int _id, String _firstName, String _lastName, int _salary) {
        if (_salary >= 0) {
            this.salary = _salary;
        }
        else {
            System.out.println("Salary can't be negative.");
        }
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    public int getID() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public void setSalary(int _salary) {
        if (_salary >= 0) {
            this.salary = _salary;
        }
        else {
            System.out.println("Salary can't be negative.");
        }
    }

    public int getAnnualSalary() {
        return this.getSalary() * 12;
    }

    public int raiseSalary(int percent) {
        if (percent >= 0 && percent <= 100) {
            this.setSalary((int)(this.getSalary() * (1.0 + (double) percent / 100)));
        }
        else {
            System.out.println("Enter value from 0 to 100 for raising salary.");
        }
        return this.getSalary();
    }

    @Override
    public String toString() {
        return "Employee[id = " + this.getID() + ", name = " + this.getName() + ", salary = " + this.getSalary() + "]";
    }
}
