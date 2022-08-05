public class Test {
    
    public static void main(String[] args) {
        System.out.println(getResult(10000));
    }

    public static double getResult(double monto) {
    Double result = 0.0;
    for (int i = 1; i <= 12 * 19; i++) {
        result += (monto * 0.0806) / 12;
        monto += result + 10000;
        System.out.println(result);
        System.out.println("Mes " + i + " - " + monto);
        result = 0.0;
    }
    return monto;
}
}


