import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        DataReconciliation dataReconciliation = new DataReconciliation();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                // Считать все месячные отчёты
                monthlyReport.MonthlyReport();
                System.out.println("Все месячные отчёты считаны!\n");

            } else if (userInput == 2) {
                // Считать годовой отчёт
                yearlyReport.YearlyReport();
                System.out.println("Годовой отчёт считан!\n");

            } else if (userInput == 3) {
                // Сверить отчёты
                dataReconciliation.reconciliation();

            } else if (userInput == 4) {
                // Вывести информацию о всех месячных отчётах
                System.out.println("Информация о всех месячных отчётах:");
                monthlyReport.printMonthlyReport();

            } else if (userInput == 5) {
                // Вывести информацию о годовом отчёте
                System.out.println("Информация о годовом отчёте:");
                System.out.println("Рассматриваемый год: 2021");
                yearlyReport.profitMonthly();
                yearlyReport.printYearlyReport();

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

