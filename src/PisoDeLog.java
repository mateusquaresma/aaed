/**
 * Piso de logaritmo truncado.
 *
 * Funciona apenas para inteiros
 */
public class PisoDeLog {


    private int resultado;


    public PisoDeLog(int n) {
        resultado = piso(n);
    }

    private int piso(int n) {
        if (n == 1) return 0;
        else return piso(n / 2) + 1;
    }


    public static void main(String[] args) {
        System.out.printf("Piso de log de %s = %s\n", 2, new PisoDeLog(2));
        System.out.printf("Piso de log de %s = %s\n", 3, new PisoDeLog(3));
        System.out.printf("Piso de log de %s = %s\n", 9, new PisoDeLog(9));
    }

    public String toString() {
        return String.valueOf(resultado);
    }

}
