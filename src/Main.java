import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport(2021, "resources/y.2021.csv");

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                // Считать все месячные отчёты
                monthlyReport.printMonthlyReport();
            } else if (userInput == 2) {
                // Считать годовой отчёт
                yearlyReport.printYearlyReport();
            } else if (userInput == 3) {
                // Сверить отчёты
            } else if (userInput == 4) {
                // Вывести информацию о всех месячных отчётах
            } else if (userInput == 5) {
                // Вывести информацию о годовом отчёте
            } else if (userInput == 0) {
                System.out.println("Вы вышли из программы!");
                break;
            } else {
                System.out.println("Извините, такой команды нет");
            }
        }
    }
        public static void printMenu() {
            System.out.println("Выберите пункт меню:");
            System.out.println("1 - Считать все месячные отчёты");
            System.out.println("2 - Считать годовой отчёт");
            System.out.println("3 - Сверить отчёты");
            System.out.println("4 - Вывести информацию о всех месячных отчётах");
            System.out.println("5 - Вывести информацию о годовом отчёте");
            System.out.println("0 - Выход из программы");
        }

}

