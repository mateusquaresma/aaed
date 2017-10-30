package base;

public class Exercicios17AB {

    /**
     * Complexidade O(k + n)
     *
     * @param A Um array de inteiros naturais (n >= 0)
     * @param n O tamanho do array
     * @param k O valor máximo contido no array
     */
    public static int[] cSort(int[] A, int n, int k) {
        int[] C = new int[k + 1]; // crio um array de k + 1 posições pra poder iniciar por 1

        for (int i = 0; i < k; i++)
            C[i] = 0;

        for (int j = 0; j < n; j++)
            C[A[j]] = C[A[j]] + 1;

        int j = 0;

        for (int i = 0; i < k + 1; i++) {
            while (C[i] > 0) {
                A[j] = i;
                j = j + 1;
                C[i] = C[i] - 1;
            }
        }

        return A;
    }

    public static int[] cSort(Integer[] A, int n, int k) {
        int[] B = new int[A.length];

        for (int i = 0; i < B.length; i++)
            B[i] = A[i];

        return cSort(B, B.length, max(B));

    }

    public static void vitoSort(int[] A, int n, int k) {
        int i = 0; // inicio por 0 por causa da linguagem

        for (int a = 1; a < k - 1; a++) {
            for (int j = i; j < n; j++) {
                if (A[j] == a) {
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                    i = i + 1;
                }
            }
        }
    }

    public static int max(int[] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++)
            if (A[i] > max)
                max = A[i];

        return max;
    }

    public static int max(Integer[] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++)
            if (A[i] > max)
                max = A[i];

        return max;
    }

    public static void main(String[] args) {

        System.out.println("--- C-SORT ---");

        int[] A = {5, 2, 0, 3, 3};

        cSort(A, A.length, max(A));

        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

        System.out.println();

        int[] A2 = {5, 2, 0, 3, 3};

        System.out.println("--- VITO SORT ---");

        vitoSort(A2, A2.length, max(A2));

        for (int i = 0; i < A2.length; i++)
            System.out.print(A2[i] + " ");

        System.out.println();

    }


}
