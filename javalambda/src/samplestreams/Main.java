package samplestreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G50", "G60", "g51",
                "I26", "I17", "I29",
                "O71"
        );
        //filter all numbers starting with g or G and sort ti and print it
        List<String> gNumbers = new ArrayList<>();
        someBingoNumbers.forEach(s -> {
            if (s.toUpperCase().startsWith("G")) {
                gNumbers.add(s);
            }
        });
        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
        gNumbers.forEach(s -> System.out.println(s));
        System.out.println("-----------------------");
        //above functionality using streams
        someBingoNumbers
                .stream()
                .filter(s -> s.toUpperCase().startsWith("G"))
                .sorted((s1, s2) -> s1.compareTo(s2))
                .forEach(s -> System.out.println(s));
        System.out.println("-----------------------");
        //above functionality using collect
        List<String> collectList = someBingoNumbers
                .stream()
                .filter(s -> s.toUpperCase().startsWith("G"))
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
        collectList.forEach(System.out::println);
        //Stream functionality
        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNumberStream);
        System.out.println("-----------------------");
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        //Stream FlatMap functionality
        Employee chetan = new Employee("Chetan Kuna", 31);
        Employee nithesh = new Employee("Nithesh Raju", 30);
        Employee akash = new Employee("Akash Tumkur", 29);
        Employee meghraj = new Employee("Meghraj Nadagouda", 30);
        Employee sunil = new Employee("Sunil Murthy", 32);

        Department humanResources = new Department("Human Resources");
        humanResources.addEmployee(sunil);
        humanResources.addEmployee(meghraj);
        humanResources.addEmployee(akash);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(chetan);
        accounting.addEmployee(nithesh);
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(humanResources);
        departmentList.add(accounting);

        //Simple flatmap
        departmentList.stream().flatMap(department -> {
            return department.getEmployees().stream();
        }).forEach(System.out::println);

        //grouping by age
        Map<Integer, List<Employee>> groupByAge = departmentList
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        //find youngest employee
        departmentList.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge()<e2.getAge()?e1:e2)
                .ifPresent(System.out::println);
    }
}
