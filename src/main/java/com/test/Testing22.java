package com.test;

import java.util.*;

public class Testing22 {

    public static void main(String[] args) {
        Employeee employee1 = new Employeee();
        employee1.setSalary(100.0);

        Employeee employee2 = new Employeee();
        employee2.setSalary(200.0);

        Employeee employee3 = new Employeee();
        employee3.setSalary(300.0);

        Employeee employee4 = new Employeee();
        employee4.setSalary(300.0);

        List<Employeee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        Optional<Double> secondHighest = list.stream().map(Employeee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHighest.ifPresent(System.out::println);
    }

}

class Employeee{
    private String name;
    private Locale location;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLocation() {
        return location;
    }

    public void setLocation(Locale location) {
        this.location = location;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
