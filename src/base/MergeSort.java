package base;

/**
 * Created by mateus on 23/08/17.
 */
public class MergeSort {


  static void merge(int[] data, int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int[] left = new int[n1];
    int[] right = new int[n2];

    for (int i = 0; i < n1; i++)
      left[i] = data[p + i];
    for (int i = 0; i < n2; i++)
      right[i] = data[q + i + 1];

    int i = 0;
    int j = 0;

    for (int k = p; k <= r; k++) {
      // Garante que os limites superiores não são últrapassados
      if (j == right.length)
        data[k] = left[i++];
      else if (i == left.length)
        data[k] = right[j++];
      else {
        if (left[i] <= right[j])
          data[k] = left[i++];
        else
          data[k] = right[j++];
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
    int[] data = new int[]{3, 2, 4, 1, 5, 0};
    // ordene do primeiro ao último índice
    sort(data, 0, data.length - 1);
    print(data);
  }
}
