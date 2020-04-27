import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.abs;
public class Half_del {

    static double f(double x) {
        double f;
        return f = 2.3 * x * x * x + 5.75 * x * x - 7.41 * x - 10.6;
    }

    static void doHDPlusCheck(double a, double b,double eps) {
        if (f(a) * f(b) < 0) {
            System.out.println("Корень существует на данном интервале");
           doHalfDel(a, b, eps);
           doFile();
            }else{
                System.out.println("Выберите другой интервал,здесь корня нет");
            }

        }
        static double x = 0, c;

        static int kol = 0;

        public static void doHalfDel ( double a, double b, double eps){


            System.out.println("Метод дихотомии: ");

            while (abs(a - b) > eps) {
                c = (a + b) / 2;
                if (f(a) * f(c) <= 0) b = c;
                else {
                    a = c;
                    x = (a + b) / 2;
                }
                kol++;
            }



        }

    public static void doFile() {
        System.out.println("Метод деления выполнен.В каком виде вывести ответ: f- в файл, с - консоль");
        try {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case ("f"): {
                    try (FileWriter writer = new FileWriter("answer", false)) {
                        String text = "x = " + x + "  f(x) = " + f(x) + "  n = " + kol;
                        writer.write(text);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case ("c"): {
                    System.out.println("x = " + x + "  f(x) = " + f(x) + "  n = " + kol);
                    break;
                }
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }}







