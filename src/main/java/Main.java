import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static double a = 0;
    static double b = 0;
    static double e = 0;
    String ans;


    public static void input(Scanner scanner) throws InputMismatchException, FileNotFoundException, IOException {
        System.out.println("Выберите тип ввода(0 - из файла, 1 - с клавиатуры): ");
        switch (scanner.next()) {
            case ("0"): {
                System.out.println("Введите полный путь к файлу: ");
                String path = scanner.next();
                FileReader fr = new FileReader(path);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                a = Double.parseDouble(line);
                b = Integer.parseInt(reader.readLine());
                e = Double.parseDouble(reader.readLine());
                System.out.println("a = " + a+ " ;" + "b = " + b + " ;"  + "e = " + e + " ;");
                break;
            }
            case ("1"): {
                System.out.println("Введите левый край интервала ");
                a = scanner.nextInt();

                System.out.println("Введите правый край интервала ");
                a = scanner.nextInt();
                System.out.println("Введите точность: ");
                e = scanner.nextDouble();
                break;
            }
            default: {
                System.out.println("Wrong answer. Try again.");
                input(scanner);
                break;
            }
        }

    }


    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(System.in);
            scanner.useLocale(new Locale("Russian"));
          //  PrintWriter printWriter = new PrintWriter(System.out);
            input(scanner);
            Grafik grafik=new Grafik();
            grafik.plot(a,b);
            grafik.pack();
            grafik.setVisible(true);


            System.out.println("Выберите метод решения: \n " +
                    "a - метод половинного деления, \n " +
                    "z  - метод Ньютона, \n " +
                    "с - метод простой итерации");
            switch (scanner.next()) {
                case ("a"): {
                    Half_del.doHDPlusCheck(a,b,e);

                break;
                }
                case ("z"): {
                    Newton.doNewton(a,b,e);
                    break;
                }
                case ("c"): {

                    SimpleIteration.doSimpleIt(a,b,e);
                    break;

                }

            }


        } catch (Exception e) {


        }

    }
}