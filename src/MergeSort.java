/**
 * Created by mateus on 23/08/17.
 */
public class MergeSort {


    static void merge(int[] data, int p, int q, int r) {

        int n = r - p + 1;

        int[] copy = new int[n];

        for (int i = 0; i < n; i++)
            copy[i] = data[p+i];

        int i = 0;
        int j = copy.length - 1;
        for (int k = p; k <= r; k++) {
            if (copy[i] <= copy[j])
                data[k] = copy[i++];
            else
                data[k] = copy[j--];
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
        int[] data = new int[]{3, 2, 1, 3};
        // ordene do primeiro ao último índice
        sort(data, 0, data.length - 1);
        print(data);
    }
}
