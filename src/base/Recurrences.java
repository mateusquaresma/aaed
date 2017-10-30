package base;

/**
 * Created by mateus on 10/09/17.
 */
public class Recurrences {

    static double lg(int n) {
        return Math.log10(n) / Math.log10(2);
    }


    static int exercicio8c(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else return exercicio8c(n - 2) + 2 * n + 1;
    }

    static int exercicio8d(int n){
        if (n == 1) return 1;
        else return exercicio8d(n / 2) + 1;
    }


    public static void main(String[] args) {
//        System.out.println(exercicio8c(1));
//        System.out.println(exercicio8c(2));
//        System.out.println(exercicio8c(3));
//        System.out.println(exercicio8c(4));
        System.out.println(exercicio8c(5));

        System.out.println(exercicio8d(2) + " -> " + (lg(2) + 1));
        System.out.println(exercicio8d(4) + " -> " + (lg(4) + 1));
        System.out.println(exercicio8d(8) + " -> " + (lg(8) + 1));
        System.out.println(exercicio8d(16) + " -> " + (lg(16) + 1));
    }

}
