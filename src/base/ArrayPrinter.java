package base;

public final class ArrayPrinter {

  static void print(int[] data) {
    for (int i = 0; i < data.length; i++)
      System.out.print(data[i] + " ");
    System.out.println();
  }

}
