import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.abs;

public class SimpleIteration {

    public static final int q = 1;
    public static double aF;

    public static double aFx;
    public static double aN;

    public static double searchX(double minRange, double maxRange, double x) {

        double a = 2.3 * 3 * Math.pow(minRange, 2) + 5.75 * 2 * minRange - 7.41;
        double b = 2.3 * 3 * Math.pow(maxRange, 2) + 5.75 * 2 * maxRange - 7.41;
        double c = 2.3 * 3 * Math.pow(x, 2) + 5.75 * 2 * x - 7.41;
        return a >= b && a >= c ? minRange : b >= a && b >= c ? maxRange : x;
    }


    public static double getLambda(double x) {
        return -1. / (2.3 * 3 * Math.pow(x, 2) + 5.75 * 2 * x - 7.41);
    }


    private static void function(double lambda, double x, double eps) {
        double x0;
        double fx;
        int count = 0;
        // System.out.printf("%s %8s %15s\n", "Итераций", "x", "f(x)");
        do {
            x0 = x;
            x = x - lambda * (2.3 * Math.pow(x, 3) + 5.75 * Math.pow(x, 2) - 7.41 * x - 10.6);
            fx = 2.3 * Math.pow(x0, 3) + 5.75 * Math.pow(x0, 2) - 7.41 * x0 - 10.6;
            // System.out.printf("%5d %15.8f %15.8f\n", ++count, x0, fx);
            ++count;

        } while (Math.abs(x - x0) >= eps);
        aF = x0;
        aFx = fx;
        aN = count;
        doFile();
    }


    public static void doSimpleIt(double MIN_RANGE, double MAX_RANGE, double EPS) {

        double x = 0.83;

        System.out.printf("   Промежуточный корень: %.2f\n\n", x);

        x = searchX(MIN_RANGE, MAX_RANGE, x);
        double lambda = getLambda(x);

        if (x - lambda * (2.3 * Math.pow(x, 3) + 5.75 * Math.pow(x, 2) - 7.41 * x - 10.6) < q) {
            System.out.println("Условие сходимости выплнено!");
               /* System.out.printf("Начальный Х для итерации равен: %.3f;\n", x);
                System.out.printf("Лямбда равна: %.3f;\n\n", lambda);*/
            function(lambda, x, EPS);


        }
    }

    public static void doFile() {
        System.out.println("Метод итераций выполнен. В каком виде вывести ответ: f- в файл, с - консоль");
        try {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case ("f"): {
                    try (FileWriter writer = new FileWriter("answer", false)) {
                        String text = "x = " + aF + "  f(x) = " + aFx + "  n = " + aN;
                        writer.write(text);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case ("c"): {
                    System.out.println("x = " + aF + "  f(x) = " + aFx + "  n = " + aN);
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}