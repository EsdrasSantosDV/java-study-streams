package org.gaje.backend.khan.infrastructure;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //EXERCISE 1- Find the sum of all even numbers in a list of integers.
        // Encontre a soma de todos os números pares em uma lista de inteiros.
        List<Integer> listNumbers= Arrays.asList(1,2,3,4,5,6,787,7,8,9,10);

        final var sum=listNumbers.stream().filter(n->n%2==0)
                .reduce(0,(a,b)->a+b);

        final var sum2=listNumbers.stream().filter(n->n%2==0).
                mapToInt(Integer::intValue).sum();

        System.out.println("Sum of all even numbers: "+sum2);

        //Find and print the count of strings that have length greater than 5.
        //Encontre e imprima a contagem de strings com comprimento maior que 5.

        List<String> listStrings=Arrays.asList("esd","asaddasdsa","sdaasddas");

        final var countStringHaveGreatherThanFive=listStrings.stream().filter(n->n.length()>5).count();

        System.out.println(countStringHaveGreatherThanFive);

        //. Implement a function that takes a list of
        // integers as input and returns a new list containing the square of each element.
        List<Integer> square=squareList(listNumbers);
        //TEM DESSE JEITO
        //OU DESSE COLLECT E PRA TRANSFORMAR EM OUTRO TIPO
        final var squareList=listNumbers.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(squareList);
        System.out.println(square.toString());

        //Find the maximum element in a list of integers.
        //Encontre o elemento máximo em uma lista de inteiros.
        //Encontre o elemento minimo em uma lista de inteiros.
        final var maxNumberInList=listNumbers.stream().mapToInt(Integer::intValue).max();
        final var minNumberList=listNumbers.stream().mapToInt(Integer::intValue).min();
        System.out.println(maxNumberInList);
        System.out.println(minNumberList);

        //Concatenate all the strings in a list into a single string.
        //Concatene todas as strings de uma lista em uma única string.
        final var stringConcat=listStrings.stream().collect(Collectors.joining());
        System.out.println(stringConcat);
        /*
        Convert each string to uppercase and then sort them in alphabetical order.
        Converta cada string em maiúsculas e classifique-as em ordem alfabética.
         */

        final var stringConvertAndSort=listStrings.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(stringConvertAndSort);

        // Find the average of all the numbers in a list of doubles using Streams.
        //Encontre a média de todos os números em uma lista de duplas usando Streams.
        List<Double> listDoubles=Arrays.asList(10.0,12.4,124.25,125.6,12.12);
        final var averageInList=listDoubles.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(averageInList);

        // Create a new list that contains only unique words (remove duplicates).
        /*
        Crie uma nova lista que contenha apenas palavras exclusivas (remova as duplicatas).
         */


        List<String> listStringsDuplicate=Arrays.asList("esd","asaddasdsa","sdaasddas","esd");
        final var duplicateRemoved=listStringsDuplicate.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicateRemoved);

        /*
        Check if all elements in a List satisfy a given condition using streams.
        Verifique se todos os elementos de uma lista satisfazem uma determinada condição usando fluxos.
         */
        final var condition=listNumbers.stream().allMatch(n->n%2==0);
        //temos o nonMatch tbm
        System.out.println(condition);
        /*
        . Check if a list contains a specific element using streams.
        Verifique se uma lista contém um elemento específico usando streams.
         */
        final var containsSeven=listNumbers.stream().anyMatch(n->n==12);
        System.out.println(containsSeven);

        /*
        . Find the longest string in a list using streams.
         Encontre a string mais longa em uma lista usando streams.
         */
        final var stringLongest=listStrings.stream().mapToInt(String::length).max();

        /*
        Remove null values from a list using streams.
         */
        final var removeNullValues=Arrays.asList("easds",null,"edsd").stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(removeNullValues);

        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee("DIEGO","DEV",8000));
        employees.add(new Employee("CHICO","fgas",9000));
        employees.add(new Employee("PEDRO","DEV",9000));
        final var highestSalaryPerDebt=employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
        );
        System.out.println(highestSalaryPerDebt.get("DEV").toString());


        /*
        Find Second Smallest Element in a List
           Encontre o segundo menor elemento em uma lista
         */
        final var secondValue=listNumbers.stream().distinct().sorted().skip(1).findFirst();
        System.out.println(secondValue);

        /*
        Find Intersection of Two Lists
        Encontre a interseção de duas listas
         */

        List<Integer> secondList=Arrays.asList(1,4,5,6,12,194);
        final var intersection=listNumbers.stream().distinct().filter(secondList::contains).collect(Collectors.toList());
        System.out.println(intersection);


    }

    static List<Integer> squareList(List<Integer> listInput)
    {
        return listInput.stream().map(n->n*n).toList();
    }

}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(final String name,final String department, final double salary)
    {
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}