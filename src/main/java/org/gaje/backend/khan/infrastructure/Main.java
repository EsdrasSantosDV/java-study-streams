package org.gaje.backend.khan.infrastructure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //EXERCISE 1- Find the sum of all even numbers in a list of integers.
        // Encontre a soma de todos os números pares em uma lista de inteiros.
        List<Integer> listNumbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        final var sum=listNumbers.stream().filter(n->n%2==0)
                .reduce(0,(a,b)->a+b);

        final var sum2=listNumbers.stream().filter(n->n%2==0).
                mapToInt(Integer::intValue).sum();

        System.out.println("Sum of all even numbers: "+sum2);

        //Find and print the count of strings that have length greater than 5.
        //Encontre e imprima a contagem de strings com comprimento maior que 5.

        List<String> listStrings=Arrays.asList("esd","saddasdsa","sdaasddas");

        final var countStringHaveGreatherThanFive=listStrings.stream().filter(n->n.length()>5).count();

        System.out.println(countStringHaveGreatherThanFive);

        //. Implement a function that takes a list of
        // integers as input and returns a new list containing the square of each element.
        List<Integer> square=squareList(listNumbers);
        //TEM DESSE JEITO
        //OU DESSE COLLECT E PRA TRANSFORMAR EM OUTRO TIPO
        final var squareList=listNumbers.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(squareList)
        ;

        System.out.println(square.toString());

    }

    static List<Integer> squareList(List<Integer> listInput)
    {
        return listInput.stream().map(n->n*n).toList();
    }

}