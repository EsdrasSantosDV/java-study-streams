package org.gaje.backend.khan.infrastructure;

import java.util.Arrays;
import java.util.List;

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






    }
}