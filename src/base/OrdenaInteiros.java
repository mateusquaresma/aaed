package base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static base.Exercicios17AB.max;
import static base.Exercicios17AB.cSort;


public class OrdenaInteiros {


    static Integer[] geraNumeros(int li, int ls) {

        Integer[] numeros = new Integer[ls];

        for (int i = 0; i < numeros.length; i++)
            numeros[i] = 0;

        for (int i = li; i < ls; i++)
            numeros[i] = i;

        List<Integer> ints = Arrays.asList(numeros);

        Collections.shuffle(ints);

        return ints.toArray(new Integer[]{});
    }

    public static void main(String[] args) {

        int n = 2;

        Integer[] numeros = geraNumeros(1, (int) Math.pow(n, 5) - 1);

        for (int i = 0; i < numeros.length; i++)
            System.out.print(numeros[i] + " ");

        System.out.println();

        System.out.println("--- C-SORT ---");

        int[] ordenados = cSort(numeros, numeros.length, max(numeros));

        for (int i = 0; i < ordenados.length; i++)
            System.out.print(ordenados[i] + " ");

        System.out.println();

    }

}
