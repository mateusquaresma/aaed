package base;

/**
 * Created by mateus on 06/08/17.
 */
public class SomaPositivos {


    private Long resultado;


    public SomaPositivos(Integer[] arr) {
        resultado = soma(arr, arr.length - 1);
    }

    private Long soma(Integer[] arr, int n) {

        if (n == -1) {
            return 0l;
        } else {
            long s = soma(arr, n - 1);

            if (arr[n] > 0)
                return s + arr[n];
            else
                return s;
        }

    }


    public static void main(String[] args) {
        System.out.println("Soma dos positivos de 1 a 5 = " + new SomaPositivos(new Integer[]{1, 2, 3, 4}));
        System.out.println("Soma dos positivos de 1 a 5 = " + new SomaPositivos(new Integer[]{1, 2, 3, 4, 5}));
        System.out.println("Soma dos positivos de 1 a 5 = " + new SomaPositivos(new Integer[]{1, 2, 3, 4, 5, 6}));
        System.out.println("Soma dos positivos de 1 a 5 = " + new SomaPositivos(new Integer[]{1, 2, 3, 4, 5, Integer.MAX_VALUE}));
    }

    public String toString() {
        return String.valueOf(resultado);
    }

}
