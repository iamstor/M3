import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Newton {

    private static int n = 1;
    private static double c0;

    static double f(double x) {
        double f;
        return f = 2.3 * x * x * x + 5.75 * x * x - 7.41 * x - 10.6;
    }

    static double fdx(double x) {
        double f;
        return f = 2.3 * 3 * x * x + 5.75 * 2 * x - 7.41;
    }

    static double f2dx(double x) {
        double f;
        return f = 2.3 * 3 * 2 * x + 5.75 * 2;
    }


    public static void doNewton(double a, double b, double EPS) {

        if (f(a) * f2dx(a) < 0) {
            c0 = a;


        } else if
        (f(b) / f2dx(b) < 0) {
            c0 = b;

        } else {
            System.exit(0);
            System.out.println("Данные не корректны!");
        }

        while (Math.abs(f(c0)) >= EPS) {
            c0 = c0 - (f(c0) / fdx(c0));
            n = n + 1;

        }
        c0 = c0 - (f(c0) / fdx(c0));



        doFile();
    }

    public static void doFile() {
        System.out.println("Метод Ньютона выполнен.В каком виде вывести ответ: f- в файл, с - консоль");
        try {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case ("f"): {
                    try (FileWriter writer = new FileWriter("answer", false)) {
                        String text = "x = " + c0 + "  f(x) = " + f(c0) + "  n = " + n;
                        writer.write(text);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case ("c"): {
                    System.out.println("x = " + c0 + "  f(x) = " + f(c0) + "  n = " + n);
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}
