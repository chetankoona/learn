package samplefunctionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Employee chetan = new Employee("Chetan Kuna", 31);
        Employee nithesh = new Employee("Nithesh Raju", 30);
        Employee akash = new Employee("Akash Tumkur", 29);
        Employee meghraj = new Employee("Meghraj Nadagouda", 30);
        Employee sunil = new Employee("Sunil Murthy", 32);

        List<Employee> employees = new ArrayList<>();
        employees.add(chetan);
        employees.add(nithesh);
        employees.add(akash);
        employees.add(meghraj);
        employees.add(sunil);

//        employees.forEach(employee -> {
//            System.out.println("Employee name = "+employee.getName());
//            System.out.println("Employee age = "+employee.getAge());
//        });

        printEmployeesByAge(employees, "Employees above 30 age", employee -> employee.getAge() > 30);
        System.out.println("\n");
        //We could use anonymous class here, but it is convinient to use lambda for java.util.Function package
        printEmployeesByAge(employees, "Employees 30 or younger age", employee -> employee.getAge() <= 30);
        System.out.println("\n");

        //We can combine the predicates as shown below.
        System.out.println("Combining 2 predicates");
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lesserThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lesserThan100).test(50));

        System.out.println("\n");

        //Supplier functional interface
        Random random = new Random();
        Supplier<Integer> randomInt = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomInt.get());
        }

        //Print the last name of employee...
        employees.forEach(employee -> {
            String name = employee.getName();
            String lastName = name.substring(name.indexOf(" ") + 1);
            System.out.println("Last Name of " + name + " is " + lastName);
        });

        //Example on using Function... (Instead of writing custom FunctionalInterface we can use Function<>)
        Function<Employee, String> getFirstName = employee -> {
            String name = employee.getName();
            return name.substring(0, name.indexOf(" "));
        };
        Function<Employee, String> getLastName = employee -> {
            String name = employee.getName();
            return name.substring(name.indexOf(" ") + 1);
        };
        employees.forEach(employee -> {
            System.out.println("FirstName = " + getName(getFirstName, employee) + " | LastName = " + getName(getLastName, employee));
        });

        //Example chaining Function
        Function<Employee,String> upperCaseName = employee -> employee.getName().toUpperCase();
        Function<String,String> firstName = name -> name.substring(0,name.indexOf(" "));
        Function upperAndGetFirstName = upperCaseName.andThen(firstName);
        employees.forEach(employee -> System.out.println("Upper and then get first name = "+upperAndGetFirstName.apply(employee)));

        //Checkout BiFunction
    }

    public static String getName(Function<Employee, String> getNameFunc, Employee employee) {
        return getNameFunc.apply(employee);
    }

    public static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=================================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee))
                System.out.println(employee.getName());
        }
    }
}
