/**
 * Created by mateus on 23/08/17.
 */
public class MergeSort {


    static void merge(int[] data, int p, int q, int r) {

        // usa 2 arrays para armazenar a direita e a esquerda
        int n1 = q - p + 1; //meio - inicio + 1
        int n2 = r - q; // fim - meio
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = data[p + i];
        for (int i = 0; i < n2; i++)
            right[i] = data[q + i];

        int i = 0;
        int j = 0;
        for (int k = p; k < r; k++) {
            if (left[i] <= right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
        }
    }

    static void sort(int[] data, int p, int r) {

        if (p >= r) return;

        // divide
        int q = (p + r) / 2;

        // conquista
        // inicia o sort do primeiro ao meio
        sort(data, p, q);
        // inicia o sort do meio ao fim
        sort(data, q + 1, r);

        // combina
        merge(data, p, q, r);

    }

    static void print(int[] data) {
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 5, 6, 2, 8, 3, 9, 4, 7};
        // ordene do primeiro ao último índice
        sort(data, 0, data.length - 1);
        print(data);
    }
}
